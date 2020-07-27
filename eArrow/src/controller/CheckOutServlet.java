package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import model.bean.CartaDiCreditoBean;
import model.bean.PagamentoBean;
import model.bean.ProdottoBean;
import model.bean.UtenteBean;
import model.dao.CartaDiCreditoDAO;
import model.dao.ComposizioneOrdineDAO;
import model.dao.OrdinaDAO;
import model.dao.PagamentoDAO;
import model.dao.ProdottoDAO;
import model.dao.StoricoOrdiniDAO;
import util.SessionArrow;
import util.ShoppingCart;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		SessionArrow sessione = new SessionArrow(request, response);
		UtenteBean utenteSessione = sessione.getSessionUser();
		
		if(utenteSessione == null) {
			request.setAttribute("sessionErroe", true);
			System.out.println("errore nella sessione");
			//pagina di errore
			/*url = response.encodeURL("");
			request.getRequestDispatcher(url).forward(request, response);*/
			//request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=E' stato riscontrato un problema relativo alla sessione").forward(request, response);
			request.getRequestDispatcher("/LoginServlet?vaiAlCarrello=true").forward(request, response);
			
		}
		
		boolean check = Boolean.parseBoolean(request.getParameter("checkout"));
		
		//Passo il controllo alla JSP corrispondente
		if(check == true) {
			
			String ruoloUtente = (String) request.getSession().getAttribute("role");
			
			if(ruoloUtente != null) {

			//verifico se esiste una carta associata all'utente per mostrarla di default
			carta = CartaDiCreditoDAO.doRetrievebyUserId(utenteSessione.getId());

			
			if(carta != null) {
				request.setAttribute("cartaAssociata", carta);
				request.setAttribute("user", utenteSessione);
			}
			
			if(request.getSession().getAttribute("carrello") == null) {
				request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=E' stato riscontrato un problema relativo al carrello").forward(request, response);
			}
			
			url = response.encodeURL("/view/CheckOut.jsp");
			request.getRequestDispatcher(url).forward(request, response);
			}
			
			else {
				request.getRequestDispatcher("/LoginServlet?vaiAlCarrello=true").forward(request, response);
			}
			
			}
		
		//elaboro le informazioni derivate dal form
		
		if(Boolean.parseBoolean(request.getParameter("formRequest")) == true) {
			
		String pan = request.getParameter("number");
		System.out.println(pan);
		//Aggiungo una nuova carta al database		
		if(pan != null) {

			//verifico se la carta è già associata all'utente
			//carta = CartaDiCreditoDAO.doRetrievebyPan(pan);
			carta = CartaDiCreditoDAO.doRetrievebyUserId(utenteSessione.getId());
			if(carta != null) {
				request.setAttribute("cartaDiCredito", carta);
				//passaggio alla servlet del riepilogo ordine 
				//carta
			}
			else {
				carta = new CartaDiCreditoBean();
				carta.setIdUtente(utenteSessione.getId());
				carta.setCodicePAN(pan.replaceAll("\\s+",""));
				carta.setCircuito(request.getParameter("circuito"));
				
				
				operazioneRiuscita = CartaDiCreditoDAO.addCard(carta);
				
				if(operazioneRiuscita == false) {
					request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=E' stato riscontrato un problema relativo al pagamento").forward(request, response);
				}
				
			}
			
			//passaggio alla servlet del riepilogo ordine 
			//salvataggio dei dati relativi all'ordine
			ShoppingCart productsS = (ShoppingCart) request.getSession().getAttribute("carrello");
	 		HashMap<ProdottoBean, Integer> products = productsS.getProductsList();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();

			java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

			double totalPrice = 0;
			for(HashMap.Entry<ProdottoBean, Integer> pair : products.entrySet()){
	 			ProdottoBean p = (ProdottoBean) pair.getKey();
	 			
	 			double prezzo = p.getPrezzo();	
				prezzo *= pair.getValue();
	 			totalPrice += prezzo;
	 		}
			
			int id = PagamentoDAO.addPagamento(carta.getCodicePAN(), "carta di credito", sqlDate, totalPrice);
			PagamentoBean pag = PagamentoDAO.doRetrievebyUserId(id);
			
			int idOrdine = OrdinaDAO.addOrder(carta.getIdUtente(), pag.getId(), sqlDate, "confermato", pag.getTipologia());
	 		
	 		for(HashMap.Entry<ProdottoBean, Integer> pair : products.entrySet()){
	 			ProdottoBean p = (ProdottoBean) pair.getKey();
	 			
	 			ComposizioneOrdineDAO.addProductOrder(idOrdine, p.getCodice(), products.get(p));
	 			
	 			//aggiurno la quantità dei prodotti rimasti in stock e se è uguale a zero li setta a non disponibili
	 			int num = p.getQuantita() - pair.getValue();
	 			ProdottoDAO.updateProductStock(p, num);
	 			boolean t = ProdottoDAO.updateDisponibilita();
	 			System.out.println(""+t);
	 		}
	 		
	 		StoricoOrdiniDAO.addProduct(idOrdine);
	 		
	 		request.getSession().setAttribute("idOrdine", idOrdine);
	 		
	 		
	 		ShoppingCart prod = (ShoppingCart) request.getSession().getAttribute("carrello");;
	 		
	 		request.getSession().removeAttribute("carrello");
	 		
	 		request.getSession().setAttribute("mapOrderProduct", prod);
	 		
			request.getRequestDispatcher("/OrderSummaryServlet").forward(request, response);
		}
		}
	}
	private String url;
	private boolean operazioneRiuscita = false;
	private CartaDiCreditoBean carta;

}
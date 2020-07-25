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
		}
		
		boolean check = Boolean.parseBoolean(request.getParameter("checkout"));
		
		//Passo il controllo alla JSP corrispondente
		if(check == true) {
			
			//verifico se esiste una carta associata all'utente per mostrarla di default
			carta = CartaDiCreditoDAO.doRetrievebyUserId(utenteSessione.getId());

			
			if(carta != null) {
				request.setAttribute("cartaAssociata", carta);
				request.setAttribute("user", utenteSessione);
			}
			
			url = response.encodeURL("/view/CheckOut.jsp");
			request.getRequestDispatcher(url).forward(request, response);
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
					
					//pagine di errore del mancato pagamento
					System.out.println("noooooooooooooooooooooooooooooooooooooooo");
					
				}
				
			}
			
			//passaggio alla servlet del riepilogo ordine 
			//salvataggio dei dati relativi all'ordine
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();

			java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
			Double d = (double) 3000;//importo
			
			System.out.println(sqlDate);
			
			int id = PagamentoDAO.addPagamento(carta.getCodicePAN(), "carta di credito", sqlDate, d);
			PagamentoBean pag = PagamentoDAO.doRetrievebyUserId(id);
			
			int idOrdine = OrdinaDAO.addOrder(carta.getIdUtente(), pag.getId(), sqlDate, "confermato", pag.getTipologia());
			
			ShoppingCart productsS = (ShoppingCart) request.getSession().getAttribute("carrello");
	 		HashMap<ProdottoBean, Integer> products = productsS.getProductsList();
	 		
	 		for(HashMap.Entry<ProdottoBean, Integer> pair : products.entrySet()){
	 			ProdottoBean p = (ProdottoBean) pair.getKey();
	 			
	 			ComposizioneOrdineDAO.addProductOrder(idOrdine, p.getCodice(), products.get(p));
	 		}

	 		System.out.println(ComposizioneOrdineDAO.doRetrievebyUserOrderId(idOrdine).toString());
		}
		}
	}
	private String url;
	private boolean operazioneRiuscita = false;
	private CartaDiCreditoBean carta;

}
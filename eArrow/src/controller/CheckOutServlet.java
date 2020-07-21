package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CartaDiCreditoBean;
import model.bean.UtenteBean;
import model.dao.CartaDiCreditoDAO;
import util.SessionArrow;

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
		
		//elaboro le informazioni derivate dal fom
		
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
					System.out.println("errore carta");
					request.setAttribute("erroreSalvataggioCarta", true);
					url = response.encodeURL("/view/CheckOut.jsp");
					request.getRequestDispatcher(url).forward(request, response);
				}else {
					//passaggio alla servlet del riepilogo ordine 
					System.out.println("fattooooooooooooooooooooooooooooooooooooooooooooo");
				}
				
			}
		}
		}
	}
	private String url;
	private boolean operazioneRiuscita = false;
	private CartaDiCreditoBean carta;

}

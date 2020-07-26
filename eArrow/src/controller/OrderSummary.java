package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ImmagineBean;
import model.bean.ProdottoBean;
import model.bean.UtenteBean;
import util.SessionArrow;

/**
 * Servlet implementation class OrderSummary
 */
@WebServlet("/OrderSummary")
public class OrderSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSummary() {
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
		
		ProdottoBean carrello = new ProdottoBean();
		
		carrello.setNome("kinetic-a1");
		carrello.setCodice(45);
		carrello.setDescrizione("sssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaggggggggggggggg\r\n" + 
				"					sssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaggggggggggggggg\r\n" + 
				"					sssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaggggggggggggggg\r\n" + 
				"					sssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaggggggggggggggg");
		carrello.setPrezzo(300);
		carrello.setQuantita(6);

		ImmagineBean img = new ImmagineBean();
		img.setCodiceProdotto(carrello.getCodice());
		img.setUri("/image/productImage/kinetic-a1.jpg");
		
		request.setAttribute("carrello", carrello);
		request.setAttribute("img", img);
		
		if(request.getAttribute("carrello") == null) {
			//pagina di errore
		}
		else {
		url = response.encodeURL("/view/OrderSummary.jsp");
		request.getRequestDispatcher(url).forward(request, response);
		}
	}
	
	private String url;

}

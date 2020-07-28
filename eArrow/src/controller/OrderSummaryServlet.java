package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.OrdineBean;
import model.bean.ProdottoBean;
import model.bean.UtenteBean;
import model.dao.ComposizioneOrdineDAO;
import model.dao.ProdottoDAO;
import util.SessionArrow;

/**
 * Servlet implementation class OrderSummaryServlet
 */
@WebServlet("/OrderSummaryServlet")
public class OrderSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSummaryServlet() {
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
		
		/*int idO = (int) request.getSession().getAttribute("idOrdine");
		
		HashMap<ProdottoBean, Integer> map = new HashMap<ProdottoBean, Integer>();
		
		
		HashMap<Integer, Integer> idAndQuantity = ComposizioneOrdineDAO.doRetrieveIdbyUserOrderId(idO);
		
		for(HashMap.Entry<Integer, Integer> pair : idAndQuantity.entrySet()){
			
			int idProd = (Integer) pair.getKey();
			
 			ProdottoBean p = ProdottoDAO.doRetrievebyCodeOrdered(idProd);
 			
 			map.put(p, pair.getValue());
 		}
		
		request.getSession().setAttribute("mapOrderProduct", map);*/
		
		
		
		url = response.encodeURL("/view/OrderSummary.jsp");
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}
	
	private String url;

}














package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.OrdineBean;
import model.bean.PagamentoBean;
import model.bean.StoricoOrdiniBean;
import model.bean.UtenteBean;
import model.dao.OrdinaDAO;
import model.dao.PagamentoDAO;
import model.dao.StoricoOrdiniDAO;
import util.SessionArrow;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
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
		
		if(request.getSession().getAttribute("role") == null || ((String) request.getSession().getAttribute("role")).equals("utente")) {
			request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=Non sei autorizzato ad accedere a questa risorsa!").forward(request, response);
		}
		
		SessionArrow sessione = new SessionArrow(request, response);
		UtenteBean utenteSessione = sessione.getSessionUser();
		
		
		url = response.encodeURL("/view/OrderList.jsp");
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private String url;
}


package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.EvidenzaBean;
import model.bean.UtenteBean;
import model.dao.EvidenzaDAO;
import model.dao.ImmagineDAO;
import util.SessionArrow;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
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
		
		List<EvidenzaBean> evidenza = EvidenzaDAO.doRetrieveAll();
		
		request.setAttribute("user", sessione.getSessionUser());
		request.setAttribute("evidenzaList", evidenza);
		
		request.getRequestDispatcher("view/HomePage.jsp").forward(request, response);
	}

}

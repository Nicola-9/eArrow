
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
		
		if(evidenza.size() > 0) {

			String user = sessione.getSessionRole();
	    
			request.setAttribute("evidenzaList", evidenza);
			
			request.getRequestDispatcher("view/HomePage.jsp").forward(request, response);
		} else {
			request.setAttribute("isHome", true);
			request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=Ops... Qualcosa non e' andato per il verso giusto").forward(request, response);
		}
	}

}

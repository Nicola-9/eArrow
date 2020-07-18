package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.IndirizzoBean;
import model.bean.UtenteBean;
import model.dao.IndirizzoDAO;
import model.dao.UtenteDao;
import util.SessionArrow;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		
		UtenteBean user = sessione.getSessionUser();
		
		if(user != null) {
			request.setAttribute("userProfile", user);
				
			IndirizzoBean address = IndirizzoDAO.doRetrievebyId(user.getIndirizzo());
				
			if(address != null ) {
				request.setAttribute("userAddress", address);
			}
				
			request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
		}
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileServlet() {
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
		if(request.getSession().getAttribute("role") == null || ((String) request.getSession().getAttribute("role")).equals("utente")) {
			request.getRequestDispatcher("/ErroreArrowServlet?testoErrore=Non sei autorizzato ad accedere a questa risorsa!").forward(request, response);
		}
		
		request.getRequestDispatcher("view/AdminProfile.jsp").forward(request, response);
	}

}

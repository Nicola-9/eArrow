package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UtenteBean;
import model.dao.UtenteDao;
import util.PasswordSha256;
import util.SessionArrow;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//Controllo se l utente è già loggato e lo rimando alla pagina corretta
				if(SessionArrow.loginSession() != false) {

					email = request.getParameter("Email");
					password = request.getParameter("Password");
					
					if (email == null || email.equals("") || password == null || password.equals("")) {
					SessionArrow.setSessionUserName(UtenteDao.doRetrievebyEmailAndPassword(email, password));
					}
					
				}
				else {
					
					email = request.getParameter("Email");
					password = request.getParameter("Password");
					
					if (email == null || email.equals("")) {
						request.getRequestDispatcher("view/Login.jsp").forward(request, response);
					}
					
					
					else {
						String passwordBase256format;
					try {
							
							passwordBase256format = PasswordSha256.getEncodedpassword(password);
						
						UtenteBean utente = UtenteDao.doRetrievebyEmailAndPassword(email, password);

						if (utente == null) {
							
							request.setAttribute("usernameErrato", true);
							request.getRequestDispatcher("view/Login.jsp").forward(request, response);
						} else {

							if (passwordBase256format.equals(utente.getPassword())) {
								SessionArrow.setSessionUserName(utente);
							}
							else {
								request.setAttribute("passwordErrata", true);
								request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
							}
							System.out.println("33333333333333333333333333333333333333333333333");
							request.getRequestDispatcher("view/HomePage.jsp").forward(request, response);
						}
					
						} catch (NoSuchAlgorithmException e) {
							
							e.printStackTrace();
						}
					
				}
	}

	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Controllo se l utente è già loggato e lo rimando alla pagina corretta
				
					HttpSession session= request.getSession(false);
					email = request.getParameter("Email");
					password = request.getParameter("Password");
					
					
					if (email != null) {
						System.out.println("444444444444444444444444444444444444444444444444444444444444444444444444444");
						request.getRequestDispatcher("view/Login.jsp").forward(request, response);
					}
					
					
					if (email == null && password == null) {
						System.out.println("55555555555555555555555555555555555555555555555555555555555555");
					email = request.getParameter("Email");
					password = request.getParameter("Password");
					
					if (email == null) {
						System.out.println("11111111111111111111111111111111111111");
						request.getRequestDispatcher("view/Login.jsp").forward(request, response);
					}
					else if(email.equals("")) {
						System.out.println("888888888888888888888888888888888888888888888888888888");
						request.getRequestDispatcher("view/Login.jsp").forward(request, response);
					}
					
					
					else {
						
						UtenteBean utente = UtenteDao.doRetrievebyEmailAndPassword(email, password);

						if (utente == null) {
							System.out.println("222222222222222222222222222222222222");
							request.setAttribute("usernameErrato", true);
							request.getRequestDispatcher("view/Login.jsp").forward(request, response);
						} else {

							System.out.println("33333333333333333333333333333333333333333333333");
							request.getRequestDispatcher("view/HomePage.jsp").forward(request, response);
						}
					
				}
	}

	}*/
	
	private String email;
	private String password;
}

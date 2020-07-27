package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UtenteBean;
import model.dao.UtenteDao;
import util.HexString;
import util.PasswordSha256;
import util.SessionArrow;
import util.ShoppingCart;

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
			boolean logJsp = Boolean.parseBoolean(request.getParameter("launch"));
			
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("carrello");
		
			SessionArrow sessione = new SessionArrow(request, response);
			UtenteBean utenteSessione = sessione.getSessionUser();
			
			if(cart != null)
				request.getSession().setAttribute("carrello", cart);
				
			if(logJsp == true) {
				url = response.encodeURL("/view/Login.jsp");
				request.getRequestDispatcher(url).forward(request, response);
			}
					//Controllo se l utente � gi� loggato e lo rimando alla pagina corretta
			else if(utenteSessione != null) {
						email = utenteSessione.getEmail();
						password = utenteSessione.getPassword();
						
						String ruolo = (String) sessione.getSessionRole();
						if (ruolo.equalsIgnoreCase("utente")) {
							url = response.encodeURL("/HomePageServlet");
							request.getRequestDispatcher(url).forward(request, response);
							return;	
						} else {			
							response.sendRedirect("----PAGINA AMMINISTRATORE----");
							return;	
						}
					}
				else {		
					email = request.getParameter("Email");
					password = request.getParameter("Password");
					
					
					if(request.getParameter("vaiAlCarrello") != null) {
						url = response.encodeURL("/view/Login.jsp");
						request.getRequestDispatcher(url).forward(request, response);
					}
					else 
					if (email == null || email.equals("")) {	
						request.setAttribute("emailErrata", true);
						url = response.encodeURL("/view/Login.jsp");
						request.getRequestDispatcher(url).forward(request, response);
					}
					else if(password == null || email.equals("")) {
						
						request.setAttribute("passwordErrata", true);
						url = response.encodeURL("/view/Login.jsp");
						request.getRequestDispatcher(url).forward(request, response);
					}
					else {					
						String passwordformat;					
					try {				
						passwordformat = PasswordSha256.getEncodedpassword(password);
						UtenteBean utente = UtenteDao.doRetrievebyEmailAndPassword(email, passwordformat);	
						System.out.println(utente);
						if (utente == null) {
							request.setAttribute("utenteNonDb", true);
							url = response.encodeURL("/view/Login.jsp");
							request.getRequestDispatcher(url).forward(request, response);
							
						} else {
							if (passwordformat.equals(utente.getPassword())) {								
								sessione.setSessionUser(utente);
							}					
							else {
								
								request.setAttribute("passwordErrata", true);
								url = response.encodeURL("/view/Login.jsp");
								request.getRequestDispatcher(url).forward(request, response);
								
							}
						
							sessione.setSessionUser(UtenteDao.doRetrievebyEmailAndPassword(email, passwordformat));
							SessionArrow.setSessionRole("utente");
							
							if(request.getParameter("vaiAlCarrello") != null) {
								request.getRequestDispatcher("/ShoppingBagServlet").forward(request, response);
							}
							
							url = response.encodeURL("/HomePageServlet");
							request.getRequestDispatcher(url).forward(request, response);
							
						}
					
						} catch (NoSuchAlgorithmException e) {
							
							e.printStackTrace();
							
						}
					
				}
	}

	}
	
	
	private String email;
	private String password;
	private String url;
}

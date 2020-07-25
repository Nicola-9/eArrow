package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.IndirizzoBean;
import model.dao.IndirizzoDAO;
import model.dao.UtenteDao;
import util.PasswordSha256;
import util.SessionArrow;
import util.ShoppingCart;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		String launchObj = request.getParameter("launch");
		
		boolean launch = Boolean.parseBoolean(launchObj);
		
		if(launch) {
			request.getRequestDispatcher("/view/SignUp.jsp").forward(request, response);
		} else {
			
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String numTel = request.getParameter("numTel");
			String city = request.getParameter("city");
			String via = request.getParameter("via");
			String civico = request.getParameter("civico");
			String cap = request.getParameter("cap");
			String password = request.getParameter("password");
			String confirmPass = request.getParameter("confirmPass");
			
			IndirizzoBean addressBean = new IndirizzoBean();
			
			int idIndirizzo = IndirizzoDAO.getMaxId();
			idIndirizzo++;
			
			addressBean.setId(idIndirizzo);
			addressBean.setCitta(city);
			addressBean.setVia(via);
			addressBean.setCivico(civico);
			addressBean.setCap(cap);
			addressBean.setTipologia("Fatturazione");
			
			IndirizzoDAO.insertAddress(addressBean);
			
			if(password.equals(confirmPass)) {
				try {
					password = PasswordSha256.getEncodedpassword(password);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
			
			UtenteDao.registerUser(idIndirizzo, name, surname, email, password, numTel);
			
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("carrello");
			
			SessionArrow sessione = new SessionArrow(request, response);
			sessione.setSessionUser(UtenteDao.doRetrievebyEmailAndPassword(email, password));
			SessionArrow.setSessionRole("utente");
			
			if(cart != null)
				request.getSession().setAttribute("carrello", cart);
			
			request.getRequestDispatcher("/HomePageServlet").forward(request, response);
		}
	}

}

package util;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ProdottoBean;
import model.bean.UtenteBean;

/*
 * classe per la gestione della sessione
 */

public class SessionArrow {
	
	private static HttpSession session;
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static String id;
	private static ArrayList<String> prodotti;

	public SessionArrow() {

	}

	public SessionArrow(HttpServletRequest req, HttpServletResponse res) {
		request = req;
		response = res;
	}

	/*
	 * metodo per la gestione del login
	 */

	public boolean isSession() {
		session = request.getSession(false);

		if (session == null) {
			// nuovo utente per la sessione

			session = request.getSession(true);

			return false;
		} else {
			id = session.getId();
			return true;
		}
	}

	public boolean logout() {
		session = request.getSession(false);

		if (session != null) {
			session.invalidate();
			return true;
		} else
			return false;
	}
	
	//metodo setta l'id dell'utente
	public boolean setSessionUserId(UtenteBean user) {
		session = request.getSession(false);
		
		if(session != null) {
			session.setAttribute("userId", user.getId());
			

			return false;
		} else {
			// sessione scaduta o inesistente
			return true;
		}
	}

	
	public static String getSessionUserId() {
		session = request.getSession(false);
		
		if(session.getAttribute("userId") == null) {
			return null;
		}else {
			return (String) session.getAttribute("userId");

		}
	}

	// metodo setta l'id dell'utente
	public boolean setSessionUserName(UtenteBean user) {
		session = request.getSession(false);
		
		if(session != null) {
			session.setAttribute("userName", user.getNome());

			return false;
		} else {
			// sessione scaduta o inesistente
			session = request.getSession(true);
			return true;
		}
	}

	
	//metodo setta il nome dell'utente
			public String getSessionUserName() {
				session = request.getSession(false);
				
				if(session != null) {
					return (String) session.getAttribute("userName");
				}
				else {
					//sessione scaduta o inesistente
					return null;
				}
			}
      



	// metodo setta il nome dell'utente
	public UtenteBean getSessionUser() {
		session = request.getSession(false);

		if (session != null) {

			return (UtenteBean) session.getAttribute("user");
		} else {
			// sessione scaduta o inesistente
			return null;
		}
	}

		
		//metodo setta il nome dell'utente
		public boolean setSessionUser(UtenteBean user) {
			session = request.getSession(false);
			
			if(session != null) {
				session.setAttribute("user", user);
				
				return false;
			}
			else {
				//sessione scaduta o inesistente
				return true;
			}
		}
		
	


	/*
	 * metodo che ritorna il JSESSIONID
	 */
	public static String getSessionId() {

		return (String) session.getId();

	}

	/*
	 * metodo che ritorna il ruolo, quidi o utente o Amministratore
	 */

		public static String getSessionRole() {
			session = request.getSession(false);
			if(session == null) {
				return null;
			}
			else {
				if(session.getAttribute("role") != null) {
					return (String) session.getAttribute("role");
				}else {
					return null;
				}
			}
		}
		
		/*
		 * metodo che ritorna il ruolo, quidi o utente o Amministratore
		 */
			public static void setSessionRole(String s) {
				session = request.getSession(false);
				session.setAttribute("role", s);
					
			}


	/*
	 * metodo per ottenere i prodotti nella sessione
	 */

	public ShoppingCart getProductCarrelloSession() {

		// verifica se gi� contiene prodotti
		if (session.getAttribute("carrello") != null) {
			return (ShoppingCart) session.getAttribute("carrello");
		} else {
			return null;
		}
	}

	/*
	 * URL-Rewriting
	 */

	public String rewriting(String url) {
		String rew = response.encodeURL(url);
		return rew;
	}
}

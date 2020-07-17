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
		
		if(session == null) {
			//nuovo utente per la sessione
			
			session = request.getSession(true);
			
			return false;
		}
		else {
			id = session.getId();
			return true;
		}
	}
	
	public boolean logout() {
		session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			return true;
		}
		else
			return false;
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
	
	//metodo setta l'id dell'utente
	public boolean setSessionUserId(UtenteBean user) {
		session = request.getSession(false);
		
		if(session != null) {
			session.setAttribute("userId", user.getId());
			
			return false;
		}
		else {
			//sessione scaduta o inesistente
			return true;
		}
	}
	
	//metodo setta l'id dell'utente
	public boolean setSessionUserName(UtenteBean user) {
		session = request.getSession(false);
		
		if(session != null) {
			session.setAttribute("user", user.getNome());
			
			return false;
		}
		else {
			//sessione scaduta o inesistente
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

  
	//metodo setta il nome dell'utente
		public UtenteBean getSessionUser() {
			session = request.getSession(false);
			
			if(session != null) {
				
				return (UtenteBean) session.getAttribute("user");
			}
			else {
				//sessione scaduta o inesistente
				return null;
			}
		}
		
		//metodo setta il nome dell'utente
		public String getSessionUserName() {
			session = request.getSession(false);
			
			if(session != null) {
				return (String) session.getAttribute("user");
			}
			else {
				//sessione scaduta o inesistente
				return null;
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
			if(session.getAttribute("role") == null) {
				return null;
			}else {
				return (String) session.getAttribute("role");
			}
		}
		
		/*
		 * metodo che ritorna il ruolo, quidi o utente o Amministratore
		 */
			public static void setSessionRole(String s) {
				
				session.setAttribute("role", s);
					
			}
	
	
	/*
	 * metodo per l'aggiunta dei prodotti nella sessione
	 */
	
	public void setCarrelloSession(ArrayList<ProdottoBean> prodottiDaAggiugere) {
		
		// Aggiunta del carrello alla sessione
		
		//verifica se gi� contiene prodotti
		if(session.getAttribute("carrello") != null) {
			Carrello c = (Carrello) session.getAttribute("carrello");
			
			ArrayList<ProdottoBean> prodotti = c.getListaProdotti();
			
			for(int i = 0; i < prodotti.size(); i++) {
				for( int j = 0; j < prodottiDaAggiugere.size(); j++) {
					if(prodotti.contains(prodottiDaAggiugere.get(j))!=true) {
						prodotti.add(prodottiDaAggiugere.get(j));
					}
				}
			}
			
			session.setAttribute("carrello", c);
		}
		else {
			Carrello c = new Carrello(prodottiDaAggiugere, session.getId());
			session.setAttribute("carrello", c);
		}
	}
	
	
	/*
	 * metodo per ottenere i prodotti nella sessione
	 */
	
	public Carrello getProductCarrelloSession() {
		
		//verifica se gi� contiene prodotti
		if(session.getAttribute("carrello") != null) {
			return (Carrello) session.getAttribute("carrello");
		}
		else {
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

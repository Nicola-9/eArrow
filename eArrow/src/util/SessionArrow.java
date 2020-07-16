package util;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ProdottoBean;
import model.bean.UtenteBean;
import model.dao.UtenteDao;

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
	
	public boolean loginSession() {
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
	
	//metodo setta il nome dell'utente
	public boolean setSessionUserName(UtenteBean user) {
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
	 * metodo che ritorna il nome dell'utente
	 */
		public static String getSessionUserName() {
			if(session.getAttribute("user") == null) {
				return null;
			}else {
				return (String) session.getAttribute("user");
			}
		}
		
		/*
		 * metodo che setta il nome dell'utente
		 */
			public static void setSessionUserName(String s) {
				
				session.setAttribute("user", s);
					
			}
	
	
	/*
	 * metodo per l'aggiunta dei prodotti nella sessione
	 */
	
	public void setCarrelloSession(ArrayList<ProdottoBean> prodottiDaAggiugere) {
		
		// Aggiunta del carrello alla sessione
		
		//verifica se già contiene prodotti
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
		
		//verifica se già contiene prodotti
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

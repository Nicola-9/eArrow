package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ProdottoBean;
import model.dao.ProdottoDAO;
import util.Carrello;
import util.SessionArrow;

/**
 * Servlet implementation class ShoppingBagServlet
 */
@WebServlet("/AddToShoppingBagServlet")
public class AddToShoppingBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToShoppingBagServlet() {
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
		Object updateObj = request.getParameter("update");
		String updateString = (String) updateObj;
		SessionArrow session = new SessionArrow(request, response);
		boolean update = false;
		
		if(updateObj != null) {
			update = Boolean.parseBoolean(updateString);
		}
		
		if(update) {
			Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
			String codeP = (String) request.getParameter("codiceProdotto");
			int codice = Integer.parseInt(codeP);
			
			if(cart != null) {
				ProdottoBean product = ProdottoDAO.doRetrievebyKey(codice);
				
				session.setProduct(product);
				
				System.out.println(session.getProductCarrelloSession());
				
			} else {
				ProdottoBean product = ProdottoDAO.doRetrievebyKey(codice);
				ArrayList<ProdottoBean> prod = new ArrayList<ProdottoBean>();
				prod.add(product);
				
				session.setCarrelloSession(prod);
				
				Carrello c = (Carrello) request.getSession().getAttribute("carrello");
				
				request.getSession().setAttribute("carrello", c);
				
				System.out.println(c.getListaProdotti().get(0).getNome());
			}
		}
	}

}

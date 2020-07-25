package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.ProdottoBean;
import model.dao.ProdottoDAO;
import util.SessionArrow;
import util.ShoppingCart;

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
		String codicePString = (String) request.getParameter("codiceProdotto");
		int codiceProdotto = Integer.parseInt(codicePString);
		
		String quantityString = (String) request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityString);
		
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("carrello");
		
		if(cart != null) {
			ProdottoBean product = ProdottoDAO.doRetrievebyCodeOrdered(codiceProdotto);
			HashMap<ProdottoBean, Integer> cartInSession = cart.getProductsList();
			boolean inCart = false;
			
			
			for(ProdottoBean p : cartInSession.keySet()) {
				if((p.getCodice() == product.getCodice())) {
					inCart = true;
					
					break;
				}
			}
			
			if(!inCart) {
				if(quantityString != null)
					cart.addProduct(product, quantity);
				else
					cart.addProduct(product, 1);
			}
				
			request.getSession().setAttribute("carrello", cart);
			request.setAttribute("product", product);
			
			request.getRequestDispatcher("/ShoppingBagServlet").forward(request, response);
		} else {
			ProdottoBean product = ProdottoDAO.doRetrievebyCodeOrdered(codiceProdotto);
			
			ShoppingCart cartNew = new ShoppingCart();
			
			cartNew.addProduct(product, 1);
			
			request.getSession().setAttribute("carrello", cartNew);
			request.setAttribute("product", product);
			
			request.getRequestDispatcher("/ShoppingBagServlet").forward(request, response);
		}
	}
}

package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ProdottoBean;
import util.ShoppingCart;

/**
 * Servlet implementation class RemoveFromShoppingCartServlet
 */
@WebServlet("/RemoveFromShoppingCartServlet")
public class RemoveFromShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromShoppingCartServlet() {
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
		String productCodeString = (String) request.getParameter("codiceProdotto");
		
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("carrello");
		
		ProdottoBean toDelete = null;
		
		if(productCodeString != null) {
			int productCode = Integer.parseInt(productCodeString);
			
			HashMap<ProdottoBean, Integer> products = cart.getProductsList();
			
			for(ProdottoBean p : products.keySet()) {
				if(p.getCodice() == productCode) {
					toDelete = p;
				}
			}
			
			cart.deleteProduct(toDelete);
			
			if(cart.getProductsList().size() == 0) {
				request.getSession().setAttribute("carrello", null);
			} else {
				request.getSession().setAttribute("carrello", cart);
			}
		}
		
		request.getRequestDispatcher("view/ShoppingBag.jsp").forward(request, response);
	}

}

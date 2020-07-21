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
		String codicePString = (String) request.getParameter("codiceProdotto");
		int codiceProdotto = Integer.parseInt(codicePString);
		
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		
		if(cart != null) {
			ProdottoBean product = ProdottoDAO.doRetrievebyCodeOrdered(codiceProdotto);
			ArrayList<ProdottoBean> cartInSession = cart.getListaProdotti();
			boolean inCart = false;
			
			for(ProdottoBean p : cartInSession) {
				if(p.getNome().equals(product.getNome())) {
					inCart = true;
					break;
				}	
			}
			
			if(!inCart) {
				cart.addProdotto(product);
			}
			
			request.setAttribute("product", product);
			request.getSession().setAttribute("carrello", cart);
			
			request.getRequestDispatcher("/ShoppingBagServlet").forward(request, response);
		} else {
			ProdottoBean product = ProdottoDAO.doRetrievebyCodeOrdered(codiceProdotto);
			
			Carrello cartNew = new Carrello();
			
			cartNew.addProdotto(product);
			
			request.getSession().setAttribute("carrello", cartNew);
			request.setAttribute("product", product);
			
			request.getRequestDispatcher("/ShoppingBagServlet").forward(request, response);
		}
	}
}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.ProdottoBean;
import util.ShoppingCart;

/**
 * Servlet implementation class ShoppingBagServlet
 */
@WebServlet("/ShoppingBagServlet")
public class ShoppingBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingBagServlet() {
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
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("carrello");
		
		String quantityString = (String) request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityString);
		
		ProdottoBean product = (ProdottoBean) request.getAttribute("product");
		
		if(cart != null && product != null) {
			ArrayList<ProdottoBean> products = new ArrayList<ProdottoBean>();
			
			
		}
	}

}

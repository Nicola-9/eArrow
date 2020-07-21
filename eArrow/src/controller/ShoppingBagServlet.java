package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ProdottoBean;
import util.Carrello;

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
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		
		if(cart != null) {
			ArrayList<ProdottoBean> products = new ArrayList<ProdottoBean>();
			
			for(int i=0; i < cart.getListaProdotti().size(); i++) {
				products.add(cart.getListaProdotti().get(i));
			}
			
			request.setAttribute("productsCart", products);
			
			request.getRequestDispatcher("view/ShoppingBag.jsp").forward(request, response);
		}
	}

}

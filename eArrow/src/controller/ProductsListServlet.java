package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ProdottoBean;
import model.dao.ProdottoDAO;

@WebServlet("/ProductsListServlet")
public class ProductsListServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductsListServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		
		if(category.toLowerCase().equals("archi")) {
			List<ProdottoBean> products = new ArrayList<ProdottoBean>();
			
			products = ProdottoDAO.doRetrievebyCategory("Riser");
			
			request.setAttribute("prodottiList", products);
			request.setAttribute("category", "Archi");
			
			request.getRequestDispatcher("view/ProductListResponsive.jsp").forward(request, response);;
		}
	}
}

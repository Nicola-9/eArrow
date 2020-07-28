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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String products = (String) request.getParameter("suggestion");
		
		List<ProdottoBean> suggestedProd = ProdottoDAO.doRetrievebySubstringObject(products);
		
		if(suggestedProd.size() >= 1) {
			request.setAttribute("prodottiList", suggestedProd);
			
			request.setAttribute("category", "search");
			
			request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
		} else {
			request.setAttribute("prodottiList", null);
			
			request.setAttribute("category", "search");
			
			request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
		}
	}
}

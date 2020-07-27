package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ProdottoBean;
import model.dao.ProdottoDAO;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
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
		String codeS = (String) request.getParameter("codice");
		int codiceP = Integer.valueOf(codeS);
		
		ProdottoBean prodotto = new ProdottoBean();
		prodotto = ProdottoDAO.doRetrievebyCodeOrdered(codiceP);
		
		if(prodotto == null) {
			System.out.println("errore");//inserire pagina di errore 
		}
		else if(prodotto != null) {
			request.setAttribute("prodotto", prodotto);
			
			request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
		}
		
	}

}

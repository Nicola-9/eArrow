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
 * Servlet implementation class AdminVisualizeProductServlet
 */
@WebServlet("/AdminVisualizeProductServlet")
public class AdminVisualizeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminVisualizeProductServlet() {
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
		String ordinamento = request.getParameter("ordinamento");
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		
		if (ordinamento != null) {
			
			if (ordinamento.equals("nome")) {
				String ordin = "nome";
				Object ordering = (Object) ordin;

				products = this.retrieveProductsList(ProdottoDAO.ORDINA_NOME);
	
				request.setAttribute("prodottiList", products);
				request.setAttribute("ordinamento", ordering);
	
				request.getRequestDispatcher("view/AdminVisualizeProductsList.jsp").forward(request, response);
				
			} else
				if(ordinamento.equals("prezzoC")) {
					
					String ordin = "prezzoC";
					Object ordering = (Object) ordin;

					products = this.retrieveProductsList(ProdottoDAO.ORDINA_PREZZOC);
					
					request.setAttribute("prodottiList", products);
					request.setAttribute("ordinamento", ordering);
		
					request.getRequestDispatcher("view/AdminVisualizeProductsList.jsp").forward(request, response);
				} else
					if(ordinamento.equals("prezzoD")) {
						
						String ordin = "prezzoD";
						Object ordering = (Object) ordin;

						products = this.retrieveProductsList(ProdottoDAO.ORDINA_PREZZOD);
						
						request.setAttribute("prodottiList", products);
						request.setAttribute("ordinamento", ordering);
			
						request.getRequestDispatcher("view/AdminVisualizeProductsList.jsp").forward(request, response);
					}
						
		} else {
			String ordin = "nome";
			Object ordering = (Object) ordin;

			products = this.retrieveProductsList(ProdottoDAO.ORDINA_NOME);

			request.setAttribute("prodottiList", products);
			request.setAttribute("ordinamento", ordering);

			request.getRequestDispatcher("view/AdminVisualizeProductsList.jsp").forward(request, response);
			 
		}
	}
	
	private List<ProdottoBean> retrieveProductsList(int ordinamento){
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		
		switch(ordinamento) {
			case ProdottoDAO.ORDINA_NOME:
				products = ProdottoDAO.doRetrieveAllbyCategoryOrdered(ProdottoDAO.ORDINA_NOME);
				break;
			case ProdottoDAO.ORDINA_PREZZOC:
				products = ProdottoDAO.doRetrieveAllbyCategoryOrdered(ProdottoDAO.ORDINA_PREZZOC);
				break;
			case ProdottoDAO.ORDINA_PREZZOD:
				products = ProdottoDAO.doRetrieveAllbyCategoryOrdered(ProdottoDAO.ORDINA_PREZZOD);
				break;
		}
		
		return products;
	}
}

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
		String ordinamento = request.getParameter("ordinamento");
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		
		if (ordinamento != null) {
			
			if (ordinamento.equals("nome")) {
				String ordin = "nome";
				Object ordering = (Object) ordin;

				switch (category.toLowerCase()) {
					case "archi":
						products = this.retrieveProductsList("archi", ProdottoDAO.ORDINA_NOME);
	
						request.setAttribute("prodottiList", products);
						request.setAttribute("category", "Archi");
						request.setAttribute("ordinamento", ordering);
	
						request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
						break;
	
					case "accessori-arco":
						products = this.retrieveProductsList("accessori-arco", ProdottoDAO.ORDINA_NOME);
	
						request.setAttribute("prodottiList", products);
						request.setAttribute("category", "Accessori Arco");
						request.setAttribute("ordinamento", ordering);
	
						request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
						break;
	
					case "accessori-arciere":
						products = this.retrieveProductsList("accessori-arciere", ProdottoDAO.ORDINA_NOME);
	
						request.setAttribute("prodottiList", products);
						request.setAttribute("category", "Accessori Arciere");
						request.setAttribute("ordinamento", ordering);
	
						request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
						break;
	
					case "frecce":
						products = this.retrieveProductsList("frecce", ProdottoDAO.ORDINA_NOME);
	
						request.setAttribute("prodottiList", products);
						request.setAttribute("category", "Frecce e Componenti");
						request.setAttribute("ordinamento", ordering);
	
						request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
						break;
	
					case "paglioni":
						products = this.retrieveProductsList("paglioni", ProdottoDAO.ORDINA_NOME);
	
						request.setAttribute("prodottiList", products);
						request.setAttribute("category", "Paglioni e Bersagli");
						request.setAttribute("ordinamento", ordering);
	
						request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
						break;
				} 
			} else
				if(ordinamento.equals("prezzoC")) {
					
					String ordin = "prezzoC";
					Object ordering = (Object) ordin;

					switch (category.toLowerCase()) {
						case "archi":
							products = this.retrieveProductsList("archi", ProdottoDAO.ORDINA_PREZZOC);
		
							request.setAttribute("prodottiList", products);
							request.setAttribute("category", "Archi");
							request.setAttribute("ordinamento", ordering);
		
							request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
							break;
		
						case "accessori-arco":
							products = this.retrieveProductsList("accessori-arco", ProdottoDAO.ORDINA_PREZZOC);
		
							request.setAttribute("prodottiList", products);
							request.setAttribute("category", "Accessori Arco");
							request.setAttribute("ordinamento", ordering);
		
							request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
							break;
		
						case "accessori-arciere":
							products = this.retrieveProductsList("accessori-arciere", ProdottoDAO.ORDINA_PREZZOC);
		
							request.setAttribute("prodottiList", products);
							request.setAttribute("category", "Accessori Arciere");
							request.setAttribute("ordinamento", ordering);
		
							request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
							break;
		
						case "frecce":
							products = this.retrieveProductsList("frecce", ProdottoDAO.ORDINA_PREZZOC);
		
							request.setAttribute("prodottiList", products);
							request.setAttribute("category", "Frecce e Componenti");
							request.setAttribute("ordinamento", ordering);
		
							request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
							break;
		
						case "paglioni":
							products = this.retrieveProductsList("paglioni", ProdottoDAO.ORDINA_PREZZOC);
		
							request.setAttribute("prodottiList", products);
							request.setAttribute("category", "Paglioni e Bersagli");
							request.setAttribute("ordinamento", ordering);
		
							request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
							break;
					} 
				} else
					if(ordinamento.equals("prezzoD")) {
						
						String ordin = "prezzoD";
						Object ordering = (Object) ordin;

						switch (category.toLowerCase()) {
							case "archi":
								products = this.retrieveProductsList("archi", ProdottoDAO.ORDINA_PREZZOD);
			
								request.setAttribute("prodottiList", products);
								request.setAttribute("category", "Archi");
								request.setAttribute("ordinamento", ordering);
			
								request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
								break;
			
							case "accessori-arco":
								products = this.retrieveProductsList("accessori-arco", ProdottoDAO.ORDINA_PREZZOD);
			
								request.setAttribute("prodottiList", products);
								request.setAttribute("category", "Accessori Arco");
								request.setAttribute("ordinamento", ordering);
			
								request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
								break;
			
							case "accessori-arciere":
								products = this.retrieveProductsList("accessori-arciere", ProdottoDAO.ORDINA_PREZZOD);
			
								request.setAttribute("prodottiList", products);
								request.setAttribute("category", "Accessori Arciere");
								request.setAttribute("ordinamento", ordering);
			
								request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
								break;
			
							case "frecce":
								products = this.retrieveProductsList("frecce", ProdottoDAO.ORDINA_PREZZOD);
			
								request.setAttribute("prodottiList", products);
								request.setAttribute("category", "Frecce e Componenti");
								request.setAttribute("ordinamento", ordering);
			
								request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
								break;
			
							case "paglioni":
								products = this.retrieveProductsList("paglioni", ProdottoDAO.ORDINA_PREZZOD);
			
								request.setAttribute("prodottiList", products);
								request.setAttribute("category", "Paglioni e Bersagli");
								request.setAttribute("ordinamento", ordering);
			
								request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
								break;
						} 
					}
		} else {
			switch (category.toLowerCase()) {
				case "archi":
					products = this.retrieveProductsList("archi", ProdottoDAO.ORDINA_NOME);
	
					request.setAttribute("prodottiList", products);
					request.setAttribute("category", "Archi");
	
					request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
					break;
	
				case "accessori-arco":
					products = this.retrieveProductsList("accessori-arco", ProdottoDAO.ORDINA_NOME);
	
					request.setAttribute("prodottiList", products);
					request.setAttribute("category", "Accessori Arco");
	
					request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
					break;
	
				case "accessori-arciere":
					products = this.retrieveProductsList("accessori-arciere", ProdottoDAO.ORDINA_NOME);
	
					request.setAttribute("prodottiList", products);
					request.setAttribute("category", "Accessori Arciere");
	
					request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
					break;
	
				case "frecce":
					products = this.retrieveProductsList("frecce", ProdottoDAO.ORDINA_NOME);
	
					request.setAttribute("prodottiList", products);
					request.setAttribute("category", "Frecce e Componenti");
	
					request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
					break;
	
				case "paglioni":
					products = this.retrieveProductsList("paglioni", ProdottoDAO.ORDINA_NOME);
	
					request.setAttribute("prodottiList", products);
					request.setAttribute("category", "Paglioni e Bersagli");
	
					request.getRequestDispatcher("view/ProductList.jsp").forward(request, response);
					break;
			} 
		}
	}
	
	private List<ProdottoBean> retrieveProductsList(String category, int ordinamento){
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		
		switch(ordinamento) {
			case ProdottoDAO.ORDINA_NOME:
				products = ProdottoDAO.doRetrievebyCategoryOrdered(category, ProdottoDAO.ORDINA_NOME);
				break;
			case ProdottoDAO.ORDINA_PREZZOC:
				products = ProdottoDAO.doRetrievebyCategoryOrdered(category, ProdottoDAO.ORDINA_PREZZOC);
				break;
			case ProdottoDAO.ORDINA_PREZZOD:
				products = ProdottoDAO.doRetrievebyCategoryOrdered(category, ProdottoDAO.ORDINA_PREZZOD);
				break;
		}
		
		return products;
	}
}

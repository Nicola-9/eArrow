package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.ImmagineBean;
import model.bean.ProdottoBean;
import model.dao.ImmagineDAO;
import model.dao.ProdottoDAO;

/**
 * Servlet implementation class AdminModifyProductServlet
 */
@MultipartConfig
@WebServlet("/AdminModifyProductServlet")
public class AdminModifyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModifyProductServlet() {
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
		String modifyString = (String) request.getParameter("modify");
		
		boolean modify = Boolean.parseBoolean(modifyString);
		
		if(!modify) {
			String productCodeS = (String) request.getParameter("productCode");
			
			int productCode = Integer.parseInt(productCodeS);
			
			ProdottoBean p = ProdottoDAO.doRetrievebyCodeOrdered(productCode);
			
			request.setAttribute("product", p);
			
			request.getRequestDispatcher("view/AdminModifyProduct.jsp").forward(request, response);
			
		} else{
			String productCodeS = (String) request.getParameter("productCode");
			int productCode = Integer.parseInt(productCodeS);
			
			String name = (String) request.getParameter("name");
			String category = (String) request.getParameter("category");
			String tipology = (String) request.getParameter("tipology");
			String priceString = (String) request.getParameter("prezzo");
			String disponibilityString = (String) request.getParameter("disponibility");
			String quantityString = (String) request.getParameter("quantity");
			String description = (String) request.getParameter("description");
			
			System.out.println(name);

			System.out.println(priceString);
			
			
			double price  = Double.parseDouble(priceString);
			
			boolean disponibility = Boolean.parseBoolean(disponibilityString);
			
			System.out.println(disponibility);
			
			System.out.println(productCode);
			
			int quantity = Integer.parseInt(quantityString);
			
			ProdottoBean p = new ProdottoBean();
			
			p.setNome(name);
			p.setCategoria(category);
			p.setTipologia(tipology);
			p.setPrezzo(price);
			p.setDisponibilita(disponibility);
			p.setQuantita(quantity);
			p.setDescrizione(description);
			
			ProdottoDAO.updateProductByCode(p, productCode);
			
			Part filePart = request.getPart("file");

			String fileNameVerify = filePart.getSubmittedFileName();
			
			InputStream fileContent = null;
			
			if(!fileNameVerify.equals(""))
				fileContent = filePart.getInputStream();
			
			
			if(fileContent != null) {
				String fileName = name.toLowerCase();
				
				if(fileName.contains(" "))
					fileName.replace(" ", "-");
				
				fileName += ".jpg";
				
				ImmagineBean i = new ImmagineBean();
				i.setCodiceProdotto(productCode);
				
				String uri = "/image/productImage/" + fileName;
				i.setUri(uri);
				
				ImmagineDAO.updateImage(i);
				
				String path = this.getServletContext().getRealPath("image//productImage");;
				
				System.out.print(path);
				
				
				OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
				
				int read = 0;
		        final byte[] bytes = new byte[1024];
	
		        while ((read = fileContent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		        
		        out.close();
				fileContent.close();
			}
			
	        request.getRequestDispatcher("/AdminVisualizeProductServlet").forward(request, response);
		}
	}

}

package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
 * Servlet implementation class InsertProductAdminServlet
 */
@MultipartConfig
@WebServlet("/InsertProductAdminServlet")
public class InsertProductAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductAdminServlet() {
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
		
		String launch = (String) request.getParameter("launch");
		
		boolean launchB = Boolean.parseBoolean(launch);
		
		if(launchB) {
			request.getRequestDispatcher("view/InsertProductAdmin.jsp").forward(request, response);
		} else {
		
			String name = (String) request.getParameter("name");
			String category = (String) request.getParameter("category");
			String tipology = (String) request.getParameter("tipology");
			String priceString = (String) request.getParameter("price");
			String disponibilityString = (String) request.getParameter("disponibility");
			String quantityString = (String) request.getParameter("quantity");
			String description = (String) request.getParameter("description");
			
			double price = Double.parseDouble(priceString);
			boolean disponibility = Boolean.parseBoolean(disponibilityString);
			int quantity = Integer.parseInt(quantityString);
			
			ProdottoBean p = new ProdottoBean();
		
			int codice = ProdottoDAO.getMaxId() + 1;
			
			p.setCodice(codice);
			p.setNome(name);
			p.setCategoria(category);
			p.setTipologia(tipology);
			p.setPrezzo(price);
			p.setDisponibilita(disponibility);
			p.setQuantita(quantity);
			p.setDescrizione(description);
	
			ProdottoDAO.insertProduct(p);
			
			Part filePart = request.getPart("file");
			InputStream fileContent = filePart.getInputStream();
			String fileName = name.toLowerCase();
			
			if(fileName.contains(" "))
				fileName.replace(" ", "-");
			
			fileName += ".jpg";
			
			ImmagineBean i = new ImmagineBean();
			i.setCodiceProdotto(codice);
			
			String uri = "/image/productImage/" + fileName;
			i.setUri(uri);
			
			ImmagineDAO.insertImage(i);
			
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
	        
	        request.getRequestDispatcher("/AdminVisualizeProductServlet").forward(request, response);
		}
	}

}

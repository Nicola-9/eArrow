package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdottoDAO;

import org.json.JSONArray;


/**
 * Servlet implementation class SuggestionListServlet
 */
@WebServlet("/SuggestionListServlet")
public class SuggestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestionListServlet() {
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
		String input = request.getParameter("inputJ");
		
		ArrayList<String> paroleOutput = new ArrayList<String>();
		
		paroleOutput = (ArrayList<String>) ProdottoDAO.doRetrievebySubstring(input);
		
		response.setContentType("application/json");
		JSONArray array = new JSONArray();

		if(!paroleOutput.isEmpty()) {
			
			array.put(true);
			array.put(paroleOutput);
			
		}else
			array.put(false);
		
		//response.encodeURL(((HttpServletRequest)request).getRequestURL().toString());

		response.getWriter().append(array.toString());
		
	}

}

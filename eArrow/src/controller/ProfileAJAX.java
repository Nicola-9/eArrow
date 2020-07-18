package controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.IndirizzoBean;
import model.bean.UtenteBean;
import model.dao.IndirizzoDAO;
import model.dao.UtenteDao;

/**
 * Servlet implementation class ProfileAJAX
 */
@WebServlet("/ProfileAJAX")
public class ProfileAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileAJAX() {
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
		String jsonString = "";
		
		if ("POST".equalsIgnoreCase(request.getMethod())) {
		   jsonString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		}
		
		JSONObject userNewJson = null;
		UtenteBean userNew = new UtenteBean();
		IndirizzoBean addressNew = new IndirizzoBean();
		
		System.out.println("Ci sono");
		
		
		try {
			userNewJson = new JSONObject(jsonString);
			
			System.out.println(userNewJson);
			
			userNew.setId(userNewJson.getInt("id"));
			userNew.setNome(userNewJson.getString("name"));
			userNew.setCognome(userNewJson.getString("surname"));
			userNew.setEmail(userNewJson.getString("email"));
			userNew.setTelefono(userNewJson.getString("tel"));
			userNew.setPassword(userNewJson.getString("password"));
			
			addressNew.setId(userNewJson.getInt("idAddress"));
			addressNew.setCitta(userNewJson.getString("city"));
			addressNew.setVia(userNewJson.getString("via"));
			addressNew.setCivico(userNewJson.getString("civico"));
			addressNew.setCap(userNewJson.getString("cap"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		boolean updateUser = UtenteDao.updateUserById(userNew);
		boolean updateAddress = IndirizzoDAO.updateAddressById(addressNew);
		
		response.setContentType("application/json");
		JSONArray resp = new JSONArray();
		
		if(updateUser && updateAddress) {
			resp.put(true);
			resp.put(userNewJson);
		} else {
			resp.put(false);
		}
		
		response.getWriter().append(resp.toString());
	}

}

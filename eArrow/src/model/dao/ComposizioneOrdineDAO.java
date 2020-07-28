package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.ConnessioneDB;
import model.bean.OrdineBean;
import model.bean.ProdottoBean;
import util.ShoppingCart;

public class ComposizioneOrdineDAO {
	
public static boolean addProductOrder(int idOrd, int codice, int quant){
		
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.composizione_ordine (idOrdine, codiceP, quantita) values(?, ?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, idOrd);
			ps.setInt(2, codice);
			ps.setInt(3, quant);
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			else
				aggiunta = false;
		
			
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aggiunta;
	}

/*
 public static ArrayList<Integer> doRetrieveIdbyUserOrderId(int id){
	
	ArrayList<Integer> ordini = new ArrayList<Integer>();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.composizione_ordine AS o WHERE o.idOrdine = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			ordini.add(rs.getInt("codiceP"));
		}

		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return ordini;
}
*/

public static HashMap<Integer, Integer> doRetrieveIdbyUserOrderId(int id){
	
	HashMap<Integer, Integer> idList = new HashMap<Integer, Integer>();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.composizione_ordine AS o WHERE o.idOrdine = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int codice = rs.getInt("codiceP");
			int quantita = rs.getInt("quantita");
			
			idList.put(codice, quantita);
		}

		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return idList;
}


}

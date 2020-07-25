package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.ConnessioneDB;
import model.bean.CartaDiCreditoBean;
import model.bean.OrdineBean;
import model.bean.ProdottoBean;
import util.ShoppingCart;

public class OrdinaDAO {
	
public static int addOrder(int idUtent, int idPag, Date data, String stao, String tipologia){
		int id = 0;
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.ordine (id, idUtente, idPag, dataO, stato, tipologia) values(?, ?, ?, ?, ?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			id = getMaxId();
			id++;
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, id);
			ps.setInt(2, idUtent);
			ps.setInt(3, idPag);
			ps.setDate(4, data);
			ps.setString(5, stao);
			ps.setString(6, tipologia);
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if(aggiunta)
			return id;
		else
			return 0;
	}

public static int getMaxId() {
	PreparedStatement ps;
	ResultSet rs;
	int id = 0;
	
	String idSQL = "SELECT MAX(id) FROM earrow.ordine";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(idSQL);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			id = rs.getInt(1);
			System.out.println(id);
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	return id;
}

public static OrdineBean doRetrievebyUserId(int id){
	OrdineBean ordine = new OrdineBean();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.ordine AS o WHERE o.id = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {

			ordine.setId(id);
			ordine.setIdUtente(rs.getInt("idUtente"));
			ordine.setIdPagamento(rs.getInt("idPag"));
			ordine.setData(rs.getDate("dataO"));
			ordine.setStato(rs.getString("stato"));
			ordine.setTipologia(rs.getString("tipologia"));
		
		}
		else {
			return null;
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return ordine;
}


}

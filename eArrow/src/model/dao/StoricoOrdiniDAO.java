package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConnessioneDB;
import model.bean.PagamentoBean;
import model.bean.ProdottoBean;
import model.bean.StoricoOrdiniBean;

public class StoricoOrdiniDAO {
	
	
	
public static boolean addProduct(int idOrd){
		
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.storico_ordini (id, idOrdine) values(?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			int idP = getMaxId();
			idP++;
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, idP);
			ps.setInt(2, idOrd);
			
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


public static int getMaxId() {
	PreparedStatement ps;
	ResultSet rs;
	int id = 0;
	
	String idSQL = "SELECT MAX(id) FROM earrow.storico_ordini";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(idSQL);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			id = rs.getInt(1);
			System.out.println(id);
		}
		else id = 0;
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	return id;
}

public static StoricoOrdiniBean doRetrievebyId(int id){
	StoricoOrdiniBean storico = new StoricoOrdiniBean();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.storico_ordini AS s WHERE s.id = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			storico.setId(rs.getInt("id"));
			storico.setId(rs.getInt("idOrdine"));

			System.out.println(storico.toString());
		}
		else {
			return null;
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return storico;
}
	

public static ArrayList<StoricoOrdiniBean> doRetrievebyAll(int id){
	StoricoOrdiniBean storico = new StoricoOrdiniBean();
	ArrayList<StoricoOrdiniBean> storicoL = new ArrayList<StoricoOrdiniBean>();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.storico_ordini AS s WHERE s.id = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			storico.setId(rs.getInt("id"));
			storico.setId(rs.getInt("idOrdine"));
			
			storicoL.add(storico);

			System.out.println(storico.toString());
		}

		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return storicoL;
}

}

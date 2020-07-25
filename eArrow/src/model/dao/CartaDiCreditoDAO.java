package model.dao;

import model.bean.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnessioneDB;
import model.bean.CartaDiCreditoBean;

public class CartaDiCreditoDAO {
	
	public static CartaDiCreditoBean doRetrievebyUserId(int id){
		CartaDiCreditoBean carta = new CartaDiCreditoBean();
		
		PreparedStatement ps;
		ResultSet rs;
		
		String cartaSQL = "SELECT * FROM earrow.carta_credito AS c WHERE c.idUtente = ?;";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(cartaSQL);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				carta.setCodicePAN(rs.getString("codicePAN"));
				carta.setIdUtente(rs.getInt("idUtente"));
				carta.setCircuito(rs.getString("circuito"));
				System.out.println(carta.toString());
			}
			else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return carta;
	}
	
	
	
	public static CartaDiCreditoBean doRetrievebyPan(String pan){
		CartaDiCreditoBean carta = new CartaDiCreditoBean();
		
		PreparedStatement ps;
		ResultSet rs;
		
		String cartaSQL = "SELECT * FROM earrow.carta_credito AS c WHERE c.codicePAN = ?;";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(cartaSQL);
			ps.setString(1, pan);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				carta.setCodicePAN(rs.getString("codicePAN"));
				carta.setIdUtente(rs.getInt("idUtente"));
				carta.setCircuito(rs.getString("circuito"));
				System.out.println(carta.toString());
			}
			else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return carta;
	}
	
	
	public static boolean addCard(CartaDiCreditoBean carta){

		boolean aggiunta = false;
		PreparedStatement ps;
		ResultSet rs;
		
		String cartaSQL = "INSERT INTO earrow.carta_credito (codicePAN, idUtente, circuito) values(?, ?, ?);";
		
		if(carta == null) {
			return false;
		}
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			String pan = carta.getCodicePAN();
			int id = carta.getIdUtente();
			String circuito = carta.getCircuito();
			
			ps = connection.prepareStatement(cartaSQL);
			ps.setString(1, pan);
			ps.setInt(2, id);
			ps.setString(3, circuito);
	
			rs = ps.getResultSet();
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aggiunta;
	}
	
}



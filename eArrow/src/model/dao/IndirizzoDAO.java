package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConnessioneDB;
import model.bean.IndirizzoBean;
import model.bean.UtenteBean;

public class IndirizzoDAO {
	
	public static boolean insertAddress(IndirizzoBean address) {
		boolean insert = false;
		PreparedStatement ps;
		
		int id = address.getId();
		String city = address.getCitta();
		String via = address.getVia();
		String civico = address.getCivico();
		String cap = address.getCap();
		String tipologia = address.getTipologia();
		
		String insertSQL = "INSERT INTO indirizzo(id, citta, via, civico, cap, tipologia)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);

				ps.setInt(1, id);
				ps.setString(2, city);
				ps.setString(3, via);
				ps.setString(4, civico);
				ps.setString(5, cap);
				ps.setString(6, tipologia);
				
				int righe = ps.executeUpdate();
				
				connection.commit();
				
				if(righe > 0)
					insert = true;
				
			}finally {
				ConnessioneDB.releaseConnection(connection);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return insert;
	}
	
	public static int getMaxId() {
		PreparedStatement ps;
		ResultSet rs;
		int id = 0;
		
		String idSQL = "SELECT MAX(id) FROM indirizzo";
		
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
	
	public static IndirizzoBean doRetrievebyId(int id){
		IndirizzoBean address = new IndirizzoBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String userSQL = "SELECT * FROM indirizzo AS i WHERE i.id = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(userSQL);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				address.setId(rs.getInt("id"));
				address.setCitta(rs.getString("citta"));
				address.setVia(rs.getString("via"));
				address.setCap(rs.getString("cap"));
				address.setCivico(rs.getString("civico"));
				address.setTipologia(rs.getString("tipologia"));
			}
			else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return address;
	}
	
	public static boolean updateAddressById(IndirizzoBean addressNew){
		PreparedStatement ps;
		
		String userSQL = "UPDATE indirizzo SET citta = ?, via = ?, civico = ?, cap = ? WHERE id = ?";
		
		try{
			Connection connessione=null;
			try {
				connessione = ConnessioneDB.getConnection();
				
				ps = connessione.prepareStatement(userSQL);
				
				ps.setString(1, addressNew.getCitta());
				ps.setString(2, addressNew.getVia());
				ps.setString(3, addressNew.getCivico());
				ps.setString(4, addressNew.getCap());
				ps.setInt(5, addressNew.getId());
				
				ps.executeUpdate();
				connessione.commit();
				
				return true;
			}
			finally {
				ConnessioneDB.releaseConnection(connessione);	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}

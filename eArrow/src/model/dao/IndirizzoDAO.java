package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConnessioneDB;
import model.bean.IndirizzoBean;

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
}

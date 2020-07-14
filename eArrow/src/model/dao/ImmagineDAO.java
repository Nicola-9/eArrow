package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConnessioneDB;
import model.bean.ImmagineBean;

public class ImmagineDAO {

	public static ImmagineBean doRetrieveImageByProductCode(int codice) {
		ImmagineBean image = new ImmagineBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String uriImageSQL = "SELECT i.uri FROM immagine AS i WHERE i.codiceP = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(uriImageSQL);
			ps.setInt(1, codice);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String uri = rs.getString("uri");
				
				if(!uri.contains("offerte")) {
					image.setUri(uri);
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	public static ImmagineBean doRetrieveOfferImageByProductCode(int codice) {
		ImmagineBean image = new ImmagineBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String uriImageSQL = "SELECT i.uri FROM immagine AS i WHERE i.codiceP = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(uriImageSQL);
			ps.setInt(1, codice);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String uri = rs.getString("uri");
				
				if(uri.contains("offerte")) {
					image.setUri(uri);
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}

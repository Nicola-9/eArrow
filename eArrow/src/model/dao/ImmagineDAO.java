package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConnessioneDB;
import model.bean.ImmagineBean;
import model.bean.ProdottoBean;

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
	
	public static ImmagineBean doRetrieveImageDiscountByProductCode(int codice) {
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
	
	public static ArrayList<ImmagineBean> doRetrieveImagesByCode(int codice) {
		ArrayList<ImmagineBean> imgs = new ArrayList<ImmagineBean>();
		ImmagineBean image = new ImmagineBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String uriImageSQL = "SELECT i.uri FROM immagine AS i WHERE i.codiceP = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(uriImageSQL);
			ps.setInt(1, codice);
			
			rs = ps.executeQuery();
			
			image.setCodiceProdotto(codice);
			while(rs.next()) {
				
				image.setUri(rs.getString("uri"));
				imgs.add(image);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(imgs.size() > 0) {
			return imgs;
		}
		else {
			return null;
		}
	}
	
	public static boolean insertImage(ImmagineBean i) {
		boolean registerOk = false;
		PreparedStatement ps;
		
		String insertSQL = "INSERT INTO immagine(uri, codiceP)"
				+ " VALUES(?, ?)";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);
				ps.setString(1, i.getUri());
				ps.setInt(2, i.getCodiceProdotto());
				
				int righe = ps.executeUpdate();
				
				connection.commit();
				
				if(righe > 0)
					registerOk = true;
				
			}finally {
				ConnessioneDB.releaseConnection(connection);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return registerOk;
	}
	
	public static boolean updateImage(ImmagineBean i) {
		boolean registerOk = false;
		PreparedStatement ps;
		
		String insertSQL = "UPDATE immagine SET uri = ?, codiceP = ? WHERE codiceP = ?";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);
				ps.setString(1, i.getUri());
				ps.setInt(2, i.getCodiceProdotto());
				ps.setInt(3, i.getCodiceProdotto());
				
				int righe = ps.executeUpdate();
				
				connection.commit();
				
				if(righe > 0)
					registerOk = true;
				
			}finally {
				ConnessioneDB.releaseConnection(connection);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return registerOk;
	}
}

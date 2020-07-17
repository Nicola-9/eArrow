package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}

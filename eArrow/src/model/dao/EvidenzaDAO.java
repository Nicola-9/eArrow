package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnessioneDB;
import model.bean.EvidenzaBean;

public class EvidenzaDAO {
	
	public static List<EvidenzaBean> doRetrieveAll(){
		List<EvidenzaBean> evidenza = new ArrayList<EvidenzaBean>();
		PreparedStatement ps;
		ResultSet rs;
		
		String evidenzaSQL = "SELECT e.codiceP FROM evidenza AS e";
		
		try(Connection connection = ConnessioneDB.getConnection()){
		
			ps = connection.prepareStatement(evidenzaSQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				EvidenzaBean evidenzaElement = new EvidenzaBean();
				
				evidenzaElement.setCodiceProdotto(rs.getInt("codiceP"));
				
				evidenza.add(evidenzaElement);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return evidenza;
	}
}

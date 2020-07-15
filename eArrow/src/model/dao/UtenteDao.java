package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnessioneDB;
import model.bean.ProdottoBean;
import model.bean.UtenteBean;

public class UtenteDao {
	
	public static UtenteBean doRetrievebyId(int id){
		UtenteBean user = new UtenteBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String userSQL = "SELECT u.id, u.idIndirizzo, u.nome, u.cognome, u.email, u.pass, u.telefono"
							+ "FROM utente AS u WHERE u.id = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(userSQL);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setIndirizzo(rs.getString("idIndirizzo"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("pass"));
				user.setTelefono(rs.getString("telefono"));
			}
			else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static UtenteBean doRetrievebyEmailAndPassword(String email, String password){
		UtenteBean user = new UtenteBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String userSQL = "SELECT * FROM utente AS u WHERE u.email = ? and u.pass = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(userSQL);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setIndirizzo(rs.getString("idIndirizzo"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("pass"));
				user.setTelefono(rs.getString("telefono"));
			}
			else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

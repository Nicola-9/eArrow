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
		
		String userSQL = "SELECT * FROM earrow.utente AS u WHERE u.id = ?;";
		
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
				System.out.println(user.toString());
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
		
		String userSQL = "SELECT * FROM earrow.utente AS u WHERE u.email = ? AND u.pass = ?;";
		
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
	
	public static boolean registerUser(int idIndirizzo, String name, String surname, String email, String password, String tel) {
		boolean registerOk = false;
		PreparedStatement ps;
		
		String insertSQL = "INSERT INTO utente(idIndirizzo, nome, cognome, email, pass, telefono)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);
				ps.setInt(1, idIndirizzo);
				ps.setString(2, name);
				ps.setString(3, surname);
				ps.setString(4, email);
				ps.setString(5, password);
				ps.setString(6, tel);
				
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

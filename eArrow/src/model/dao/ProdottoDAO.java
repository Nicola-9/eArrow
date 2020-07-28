package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnessioneDB;
import model.bean.ProdottoBean;

public class ProdottoDAO {

	public static List<ProdottoBean> doRetrievebyCategory(String category){
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "SELECT p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita ,"
							+ "p.quantita , p.descrizione FROM"
							+ " prodotto AS p WHERE p.categoria = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto = new ProdottoBean();
				
				prodotto.setCodice(rs.getInt("codice"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilità") == 1) {
					prodotto.setDisponibilita(true);
				} else {
					prodotto.setDisponibilita(false);
				}
				
				prodotto.setQuantita(rs.getInt("quantità"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				products.add(prodotto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public static List<ProdottoBean> doRetrievebyCategoryOrdered(String category, int ordinamento){
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "SELECT p.codice, p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita,"
							+ "p.quantita, p.descrizione FROM"
							+ " prodotto AS p WHERE p.categoria = ?"
							+ ORDINAMENTI[ordinamento];
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto = new ProdottoBean();
				
				prodotto.setCodice(rs.getInt("codice"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilita") == 1) {
					prodotto.setDisponibilita(true);
				} else {
					prodotto.setDisponibilita(false);
				}
				
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				products.add(prodotto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public static List<ProdottoBean> doRetrieveAllbyCategoryOrdered(int ordinamento){
		List<ProdottoBean> products = new ArrayList<ProdottoBean>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "SELECT p.codice, p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita,"
							+ "p.quantita, p.descrizione FROM"
							+ " prodotto AS p"
							+ ORDINAMENTI[ordinamento];
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto = new ProdottoBean();
				
				prodotto.setCodice(rs.getInt("codice"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilita") == 1) {
					prodotto.setDisponibilita(true);
				} else {
					prodotto.setDisponibilita(false);
				}
				
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				products.add(prodotto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public static ProdottoBean doRetrievebyKey(int codice){
		ProdottoBean product = new ProdottoBean();
		PreparedStatement ps;
		ResultSet rs;
		
		String productSQL = "SELECT p.nome, p.descrizione FROM prodotto AS p WHERE p.codice = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, codice);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			product.setNome(rs.getString("nome"));
			product.setDescrizione(rs.getString("descrizione"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public static ProdottoBean doRetrievebyCodeOrdered(int code){
		//ProdottoBean products = new ProdottoBean();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto = new ProdottoBean();
		
		String productSQL = "SELECT p.codice, p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita,"
							+ "p.quantita, p.descrizione FROM"
							+ " prodotto AS p WHERE p.codice = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, code);
			
			rs = ps.executeQuery();
			
			rs.next();
			
				prodotto = new ProdottoBean();
				
				prodotto.setCodice(rs.getInt("codice"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilita") == 1) {
					prodotto.setDisponibilita(true);
				} else {
					prodotto.setDisponibilita(false);
				}
				
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				//products.add(prodotto);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return prodotto;
	}
	
	
	public static ArrayList<ProdottoBean> doRetrievebyRecommendedProducts(String category){
		ArrayList<ProdottoBean> products = new ArrayList<ProdottoBean>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "SELECT p.codice, p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita,"
							+ "p.quantita, p.descrizione FROM"
							+ " prodotto AS p WHERE p.categoria = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto = new ProdottoBean();
				
				prodotto.setCodice(rs.getInt("codice"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilita") == 1) {
					prodotto.setDisponibilita(true);
				} else {
					prodotto.setDisponibilita(false);
				}
				
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				products.add(prodotto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	public static List<String> doRetrievebySubstring(String sub){
		List<String> productsName = new ArrayList<String>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		sub = '%' + sub + '%';
		
		String productSQL = "SELECT p.nome FROM prodotto AS p WHERE p.nome like ?;";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setString(1, sub);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				productsName.add(rs.getString("nome"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return productsName;
	}
	

	public static List<ProdottoBean> doRetrievebySubstringObject(String sub){
		List<ProdottoBean> productsName = new ArrayList<ProdottoBean>();
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		sub = '%' + sub + '%';
		
		String productSQL = "SELECT p.codice, p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilita, "
							+ "p.quantita, p.descrizione FROM prodotto AS p WHERE p.nome like ?;";

		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);

			ps.setString(1, sub);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProdottoBean suggestedProd = new ProdottoBean();
				
				suggestedProd.setCodice(rs.getInt("codice"));
				suggestedProd.setNome(rs.getString("nome"));
				suggestedProd.setCategoria(rs.getString("categoria"));
				suggestedProd.setTipologia(rs.getString("tipologia"));
				suggestedProd.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilita") == 1) {
					suggestedProd.setDisponibilita(true);
				} else {
					suggestedProd.setDisponibilita(false);
				}
				
				suggestedProd.setQuantita(rs.getInt("quantita"));
				suggestedProd.setDescrizione(rs.getString("descrizione"));
				
				productsName.add(suggestedProd);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return productsName;

	}
	
	
	public static boolean updateProductStock(ProdottoBean prodotto,  int n){
		PreparedStatement ps;
		
		String userSQL = "UPDATE prodotto SET quantita = ? WHERE codice = ?";
		
		try{
			Connection connessione=null;
			try {
				connessione = ConnessioneDB.getConnection();
				
				ps = connessione.prepareStatement(userSQL);

				ps.setInt(1, n);
				ps.setInt(2, prodotto.getCodice());
			
				
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
	
	
	public static boolean updateDisponibilita(){
		ProdottoBean product = new ProdottoBean();
		ArrayList<Integer> codList = new ArrayList<Integer>();
		PreparedStatement ps;
		ResultSet rs;
		
		String productSQL = "SELECT p.codice FROM prodotto AS p WHERE p.quantita = 0";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				codList.add(rs.getInt("codice"));
			}
			
			updateDisp(codList);
	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static boolean updateDisp(ArrayList<Integer> codList){
		PreparedStatement ps; 
		
		String productSQLUpdate = "UPDATE prodotto SET disponibilita = 0 WHERE codice = ?";
		
		try{
			Connection connessione=null;
			try {
				connessione = ConnessioneDB.getConnection();
				
				for(int x : codList) {
				ps = connessione.prepareStatement(productSQLUpdate);

				ps.setInt(1, x);

				ps.executeUpdate();
				
				}
				
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
	
	public static boolean insertProduct(ProdottoBean p) {
		boolean registerOk = false;
		PreparedStatement ps;
		
		String insertSQL = "INSERT INTO prodotto(codice, nome, categoria, tipologia, prezzo, disponibilita, quantita, descrizione)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);
				
				ps.setInt(1, p.getCodice());
				ps.setString(2, p.getNome());
				ps.setString(3, p.getCategoria());
				ps.setString(4, p.getTipologia());
				ps.setDouble(5, p.getPrezzo());
				
				if(p.isDisponibilita())
					ps.setInt(6, 1);
				else
					ps.setInt(6, 0);
				
				ps.setInt(7, p.getQuantita());
				ps.setString(8, p.getDescrizione());
				
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
	
	public static boolean updateProductByCode(ProdottoBean p, int codice) {
		boolean updateOk = false;
		PreparedStatement ps;
		
		String insertSQL = "UPDATE prodotto SET nome = ?, categoria = ?, tipologia = ?, prezzo = ?,"
						+ " disponibilita = ?, quantita = ?, descrizione = ? WHERE codice = ?";
		
		try {
			Connection connection = null;
			
			try {
				connection = ConnessioneDB.getConnection();
				
				ps = connection.prepareStatement(insertSQL);
				
				ps.setString(1, p.getNome());
				ps.setString(2, p.getCategoria());
				ps.setString(3, p.getTipologia());
				ps.setDouble(4, p.getPrezzo());
				
				if(p.isDisponibilita())
					ps.setInt(5, 1);
				else
					ps.setInt(5, 0);
				
				ps.setInt(6, p.getQuantita());
				ps.setString(7, p.getDescrizione());
				ps.setInt(8, codice);
				
				
				ps.executeUpdate();
				
				connection.commit();
				connection.close();
				
			}finally {
				ConnessioneDB.releaseConnection(connection);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return updateOk;
	}
	
	public static int getMaxId() {
		PreparedStatement ps;
		ResultSet rs;
		int id = 0;
		
		String idSQL = "SELECT MAX(codice) FROM prodotto";
		
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
	
	
	public static final int ORDINA_NOME = 0;
	public static final int ORDINA_PREZZOC = 1;
	public static final int ORDINA_PREZZOD = 2;
	private static final String[] ORDINAMENTI = {" ORDER BY p.nome", " ORDER BY p.prezzo ASC", " ORDER BY p.prezzo DESC"};
}

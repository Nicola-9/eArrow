package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.ConnessioneDB;
import model.bean.OrdineBean;
import model.bean.ProdottoBean;
import util.ShoppingCart;

public class ComposizioneOrdineDAO {
	
	/*public static boolean addProductOrder(ShoppingCart prodotti){
		
		HashMap<ProdottoBean, Integer> products = prodotti.getProductsList();
		
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.composizione_ordine (idOrdine, codiceP, quantita) values(?, ?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			
			for(HashMap.Entry<ProdottoBean, Integer> pair : products.entrySet()){
				
				ProdottoBean p = (ProdottoBean) pair.getKey();
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, 1);
			ps.setInt(2, p.getCodice());
			ps.setInt(3, pair.getValue());
			
			rs = ps.executeQuery();
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			else
				aggiunta = false;
			}
			
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aggiunta;
	}*/
	
public static boolean addProductOrder(int idOrd, int codice, int quant){
		
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.composizione_ordine (idOrdine, codiceP, quantita) values(?, ?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, idOrd);
			ps.setInt(2, codice);
			ps.setInt(3, quant);
			
			rs = ps.executeQuery();
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			else
				aggiunta = false;
		
			
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aggiunta;
	}

public static ArrayList<OrdineBean> doRetrievebyUserOrderId(int id){
	OrdineBean ordine = new OrdineBean();
	ArrayList<OrdineBean> ordineL = new ArrayList<OrdineBean>();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.composizione_ordine AS o WHERE o.idOrdine = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {

			ordine.setId(id);
			ordine.setIdUtente(rs.getInt("idUtente"));
			ordine.setIdPagamento(rs.getInt("idPag"));
			ordine.setData(rs.getDate("dataO"));
			ordine.setStato(rs.getString("stato"));
			ordine.setTipologia(rs.getString("tipologia"));
		
			ordineL.add(ordine);
		}

		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return ordineL;
}

	


}

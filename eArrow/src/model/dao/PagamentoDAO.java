package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConnessioneDB;
import model.bean.CartaDiCreditoBean;
import model.bean.OrdineBean;
import model.bean.PagamentoBean;
import model.bean.ProdottoBean;

public class PagamentoDAO {
	
public static int addPagamento(String codicePan, String tipologia, Date data, Double i){
		int id = 0;
		boolean aggiunta = false;
		
		PreparedStatement ps;
		ResultSet rs;
		ProdottoBean prodotto;
		
		String productSQL = "INSERT INTO earrow.pagamento (id, codicePAN, tipologia, dataP, importo) values(?, ?, ?, ?, ?);";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			id = getMaxId();
			id++;
			
			ps = connection.prepareStatement(productSQL);
			ps.setInt(1, id);
			ps.setString(2, codicePan);
			ps.setString(3, tipologia);
			ps.setDate(4, data);
			ps.setDouble(5, i);
			
			if(ps.executeUpdate() > 0) 
				aggiunta = true;
			
			connection.commit();
			
			ConnessioneDB.releaseConnection(connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if(aggiunta)
			return id;
		else
			return 0;
	}


public static int getMaxId() {
	PreparedStatement ps;
	ResultSet rs;
	int id = 0;
	
	String idSQL = "SELECT MAX(id) FROM earrow.pagamento";
	
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


public static PagamentoBean doRetrievebyUserId(int id){
	PagamentoBean pagamento = new PagamentoBean();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.pagamento AS p WHERE p.id = ?;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			pagamento.setId(rs.getInt("id"));
			pagamento.setCodicePAN(rs.getString("codicePAN"));
			pagamento.setTipologia(rs.getString("tipologia"));
			pagamento.setData(rs.getDate("dataP"));
			pagamento.setImporto(rs.getDouble("importo"));

			System.out.println(pagamento.toString());
		}
		else {
			return null;
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return pagamento;
}


public static ArrayList<PagamentoBean> doRetrieveAll(){
	PagamentoBean pagamento = new PagamentoBean();
	ArrayList<PagamentoBean> listaP = new ArrayList<PagamentoBean>();
	
	PreparedStatement ps;
	ResultSet rs;
	
	String cartaSQL = "SELECT * FROM earrow.pagamento AS o WHERE o.id >= 1;";
	
	try(Connection connection = ConnessioneDB.getConnection()){
		
		ps = connection.prepareStatement(cartaSQL);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {

			pagamento.setId(rs.getInt("id"));
			pagamento.setCodicePAN(rs.getString("codicePAN"));
			pagamento.setTipologia(rs.getString("tipologia"));
			pagamento.setData(rs.getDate("dataP"));
			pagamento.setImporto(rs.getDouble("importo"));
			
			listaP.add(pagamento);
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return listaP;
}

}

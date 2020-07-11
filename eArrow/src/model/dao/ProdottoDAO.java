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
		
		String productSQL = "SELECT p.nome, p.categoria, p.tipologia, p.prezzo, p.disponibilità,"
							+ "p.quantità, p.descrizione FROM"
							+ " prodotto AS p WHERE p.categoria = ?";
		
		try(Connection connection = ConnessioneDB.getConnection()){
			
			ps = connection.prepareStatement(productSQL);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prodotto = new ProdottoBean();
				
				prodotto.setNome(rs.getString("nome"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setTipologia(rs.getString("tipologia"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				
				if(rs.getInt("disponibilità") == 1) {
					prodotto.setDisponibilità(true);
				} else {
					prodotto.setDisponibilità(false);
				}
				
				prodotto.setQuantità(rs.getInt("quantità"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				
				products.add(prodotto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}

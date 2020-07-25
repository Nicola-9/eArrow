package util;

import java.util.HashMap;

import model.bean.ProdottoBean;

public class ShoppingCart {
	
	public ShoppingCart() {
		this.productsList = new HashMap<ProdottoBean, Integer>();
	}
	
	public ShoppingCart(HashMap<ProdottoBean, Integer> productList, String sessionID) {
		this.productsList = productList;
		this.sessionID = sessionID;
	}
	
	public void addProduct(ProdottoBean p, int quantity) {
		this.productsList.put(p, quantity);
	}
	
	public void setProduct(ProdottoBean p, int quantity) {
		for(HashMap.Entry<ProdottoBean, Integer> prod : this.productsList.entrySet()) {
			if(prod.getKey().getCodice() == p.getCodice()) {
				prod.setValue(quantity);
			}
		}
	}
	
	public void deleteProduct(ProdottoBean p) {
		this.productsList.remove(p);
	}
	
	public HashMap<ProdottoBean, Integer> getProductsList(){
		return this.productsList;
	}
	
	public String getSessionID() {
		return this.sessionID;
	}
	
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	public boolean contains(ProdottoBean p) {
		if(this.productsList.containsKey(p))
			return true;
		else
			return false;
	}
	
 
	private HashMap<ProdottoBean, Integer> productsList;
	private String sessionID;
}

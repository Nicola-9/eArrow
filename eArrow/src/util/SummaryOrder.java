package util;

import java.util.HashMap;

import model.bean.ProdottoBean;

public class SummaryOrder {

	public SummaryOrder() {
		this.products = new HashMap<ProdottoBean, Integer>();
	}
	
	public SummaryOrder(HashMap<ProdottoBean, Integer> productList, String sessionID) {
		this.products = productList;
		this.sessionID = sessionID;
	}
	
	public void addProduct(ProdottoBean p, int quantity) {
		this.products.put(p, quantity);
	}
	
	public void setProduct(ProdottoBean p, int quantity) {
		for(HashMap.Entry<ProdottoBean, Integer> prod : this.products.entrySet()) {
			if(prod.getKey().getCodice() == p.getCodice()) {
				prod.setValue(quantity);
			}
		}
	}
	
	public void deleteProduct(ProdottoBean p) {
		this.products.remove(p);
	}
	
	public HashMap<ProdottoBean, Integer> getProducts(){
		return this.products;
	}
	
	public String getSessionID() {
		return this.sessionID;
	}
	
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	public boolean contains(ProdottoBean p) {
		if(this.products.containsKey(p))
			return true;
		else
			return false;
	}

	private HashMap<ProdottoBean, Integer> products;
	private String sessionID;
}

package util;

import java.util.ArrayList;

import model.bean.ProdottoBean;

public class Carrello {
	
	ArrayList<ProdottoBean> listaProdotti;
	String sessioID;
	
	public Carrello() {
		listaProdotti = new ArrayList<ProdottoBean>();
	}
	
	public Carrello(ArrayList<ProdottoBean> prodotti) {
		listaProdotti = prodotti;
	}
	
	public Carrello(ArrayList<ProdottoBean> prodotti, String id) {
		listaProdotti = prodotti;
		sessioID = id;
		}
		
	public void addProdotto(ProdottoBean p) {
		this.listaProdotti.add(p);
	}
	
	public void deleteProdotto(ProdottoBean p) {
		this.listaProdotti.remove(p);
	}
	
	public boolean containsProdotto(ProdottoBean p) {
		if(this.listaProdotti.contains(p))
			return true;
		else
			return false;
	}
	
	public ArrayList<ProdottoBean> getListaProdotti() {
		return listaProdotti;
	}
	
	public void setListaProdotti(ArrayList<ProdottoBean> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	
	public String getSessioID() {
		return sessioID;
	}
	
	public void setSessioID(String sessioID) {
		this.sessioID = sessioID;
	}
	


}

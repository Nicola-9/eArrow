package model.bean;

import java.util.Date;

public class OrdineBean {
	
	public OrdineBean() {
		
	}
	
	public OrdineBean(int id, int idUtente, int idPagamento, Date data, String stato, String tipologia) {
		this.id = id;
		this.idUtente = idUtente;
		this.idPagamento = idPagamento;
		this.data = data;
		this.stato = stato;
		this.tipologia = tipologia;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUtente() {
		return idUtente;
	}
	
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
	public int getIdPagamento() {
		return idPagamento;
	}
	
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getStato() {
		return stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	private int id;
	private int idUtente;
	private int idPagamento;
	private Date data;
	private String stato;
	private String tipologia;
}

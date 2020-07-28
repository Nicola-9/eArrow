package model.bean;

import java.util.Date;

public class PagamentoBean {
	
	public PagamentoBean() {
		
	}
	
	public PagamentoBean(int id, String codicePAN, String tipologia, Date data, double importo) {
		this.id = id;
		this.codicePAN = codicePAN;
		this.tipologia = tipologia;
		this.data = data;
		this.importo = importo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodicePAN() {
		return codicePAN;
	}

	public void setCodicePAN(String codicePAN) {
		this.codicePAN = codicePAN;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	

	@Override
	public String toString() {
		return "PagamentoBean [id=" + id + ", codicePAN=" + codicePAN + ", tipologia=" + tipologia + ", data=" + data
				+ ", importo=" + importo + "]";
	}



	private int id;
	private String codicePAN;
	private String tipologia;
	private Date data;
	private double importo;
}

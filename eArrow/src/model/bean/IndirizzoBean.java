package model.bean;

public class IndirizzoBean {
	
	public IndirizzoBean() {
		
	}
	
	public IndirizzoBean(int id, String citta, String via, String civico, String cap, String tipologia) {
		this.id = id;
		this.citta = citta;
		this.via = via;
		this.civico = civico;
		this.cap = cap;
		this.tipologia = tipologia;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setVia(String via) {
		this.via = via;
	}
	
	public String getCivico() {
		return civico;
	}
	
	public void setCivico(String civico) {
		this.civico = civico;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	private int id;
	private String citta;
	private String via;
	private String civico;
	private String cap;
	private String tipologia;
}

package model.bean;

public class CartaDiCreditoBean {
	
	public CartaDiCreditoBean() {
		
	}
	
	public CartaDiCreditoBean(String codicePAN, int idUtente, String circuito) {
		this.codicePAN = codicePAN;
		this.idUtente = idUtente;
		this.circuito = circuito;
	}
	
	public String getCodicePAN() {
		return codicePAN;
	}

	public void setCodicePAN(String codicePAN) {
		this.codicePAN = codicePAN;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	private String codicePAN;
	private int idUtente;
	private String circuito;
}

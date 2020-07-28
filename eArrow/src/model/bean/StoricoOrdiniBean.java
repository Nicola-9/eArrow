package model.bean;

public class StoricoOrdiniBean {
	
	public StoricoOrdiniBean() {
		
	}

	public StoricoOrdiniBean(int id, int idOrdine, String fattura) {
		this.id = id;
		this.idOrdine = idOrdine;
		this.fattura = fattura;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getFattura() {
		return fattura;
	}

	public void setFattura(String fattura) {
		this.fattura = fattura;
	}
	
	

	@Override
	public String toString() {
		return "StoricoOrdiniBean [id=" + id + ", idOrdine=" + idOrdine + ", fattura=" + fattura + "]";
	}



	private int id;
	private int idOrdine;
	private String fattura;
}

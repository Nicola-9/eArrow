package model.bean;

public class ComposizioneOrdineBean {
	
	public ComposizioneOrdineBean() {
		
	}
	
	public ComposizioneOrdineBean(int idOrdine, int codiceProdotto, int quantita) {
		this.idOrdine = idOrdine;
		this.codiceProdotto = codiceProdotto;
		this.quantita = quantita;
	}
	
	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	private int idOrdine;
	private int codiceProdotto;
	private int quantita;
}

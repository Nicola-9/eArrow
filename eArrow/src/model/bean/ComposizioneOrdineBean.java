package model.bean;

public class ComposizioneOrdineBean {
	
	public ComposizioneOrdineBean() {
		
	}
	
	public ComposizioneOrdineBean(int idOrdine, int codiceProdotto, int quantità) {
		this.idOrdine = idOrdine;
		this.codiceProdotto = codiceProdotto;
		this.quantità = quantità;
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

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	private int idOrdine;
	private int codiceProdotto;
	private int quantità;
}

package model.bean;

public class ComposizioneOrdineBean {
	
	public ComposizioneOrdineBean() {
		
	}
	
	public ComposizioneOrdineBean(int idOrdine, int codiceProdotto, int quantit�) {
		this.idOrdine = idOrdine;
		this.codiceProdotto = codiceProdotto;
		this.quantit� = quantit�;
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

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	private int idOrdine;
	private int codiceProdotto;
	private int quantit�;
}

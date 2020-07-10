package model.bean;

public class EvidenzaBean {
	
	public EvidenzaBean() {
		
	}
	
	public EvidenzaBean(int codiceProdotto, String nomeVetrina) {
		super();
		this.codiceProdotto = codiceProdotto;
		this.nomeVetrina = nomeVetrina;
	}
	
	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getNomeVetrina() {
		return nomeVetrina;
	}

	public void setNomeVetrina(String nomeVetrina) {
		this.nomeVetrina = nomeVetrina;
	}

	private int codiceProdotto;
	private String nomeVetrina;
}

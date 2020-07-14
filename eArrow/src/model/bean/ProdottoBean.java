package model.bean;

public class ProdottoBean {
	
	public ProdottoBean() {
		
	}

	public ProdottoBean(int codice, String nome, String categoria, String tipologia, double prezzo,
			boolean disponibilit�, int quantit�, String descrizione) {
		this.codice = codice;
		this.nome = nome;
		this.categoria = categoria;
		this.tipologia = tipologia;
		this.prezzo = prezzo;
		this.disponibilita = disponibilit�;
		this.quantita = quantit�;
		this.descrizione = descrizione;
	}
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilit�) {
		this.disponibilita = disponibilit�;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantit�) {
		this.quantita = quantit�;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	private int codice;
	private String nome;
	private String categoria;
	private String tipologia;
	private double prezzo;
	private boolean disponibilita;
	private int quantita;
	private String descrizione;
}

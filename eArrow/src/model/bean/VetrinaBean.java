package model.bean;

public class VetrinaBean {
	
	public VetrinaBean() {
		
	}
	
	public VetrinaBean(String nome, int sconto) {
		this.nome = nome;
		this.sconto = sconto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	private String nome;
	private int sconto;
}

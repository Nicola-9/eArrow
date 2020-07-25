package model.bean;

public class ImmagineBean {
	
	public ImmagineBean() {
		
	}

	public ImmagineBean(String uri, int codiceProdotto) {
		this.uri = uri;
		this.codiceProdotto = codiceProdotto;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	
	

	@Override
	public String toString() {
		return "ImmagineBean [uri=" + uri + ", codiceProdotto=" + codiceProdotto + "]";
	}



	private String uri;
	private int codiceProdotto;
}

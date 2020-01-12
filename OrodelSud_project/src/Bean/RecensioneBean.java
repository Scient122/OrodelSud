package Bean;

public class RecensioneBean {

	public RecensioneBean () {
		
	}
	
	public String getCommento() {
		return commento;
	}



	public void setCommento(String commento) {
		this.commento = commento;
	}



	public String getEmail_cliente() {
		return email_cliente;
	}



	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}



	public String getTitolo_ricetta() {
		return titolo_ricetta;
	}



	public void setTitolo_ricetta(String titolo_ricetta) {
		this.titolo_ricetta = titolo_ricetta;
	}

	private String commento, email_cliente, titolo_ricetta;
}


package JUnit;
import Bean.*;


public class RecensioneBean_Stub extends RecensioneBean{
	
public RecensioneBean_Stub() {
		
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

	private String commento="Ottima", email_cliente="marco@gmail.com", titolo_ricetta="Spaghetti";

}

package JUnit;

import Bean.AziendaBean;

public class AziendaBean_Stub extends AziendaBean{
	
	public AziendaBean_Stub () {
		super();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getNumero_civico() {
		return numero_civico;
	}
	public void setNumero_civico(String numero_civico) {
		this.numero_civico = numero_civico;
	}
	public String getNumero_di_telefono() {
		return numero_di_telefono;
	}
	public void setNumero_di_telefono(String numero_di_telefono) {
		this.numero_di_telefono = numero_di_telefono;
	}
	
	private String email="Azienda10@gmail.com",password="azienda10",nome="Azienda",via="Via Ersilio",cap="10152",citta="Napoli",numero_civico="15", numero_di_telefono="081658741";
	
}

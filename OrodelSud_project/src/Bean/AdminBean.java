package Bean;
import java.sql.Date;
import java.util.ArrayList;

public class AdminBean {

	public AdminBean () {
		
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public Date getData_di_nascita() {
		return data_di_nascita;
	}
	public void setData_di_nascita(Date data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	/*public ArrayList<String> getCarte_di_credito() {
		return carte_di_credito;
	}
	public void setCarte_di_credito(ArrayList<String> carte_di_credito) {
		this.carte_di_credito = carte_di_credito;
	}
	public void setCarte_di_credito(String carta) {
		carte_di_credito.add(carta);
	}
	public void deleteCarte_di_credito(String carta) {
		carte_di_credito.remove(carta);
	}*/

	private String email,password,nome,cognome,via,cap,citta,numero_civico, numero_di_telefono;
	private Date data_di_nascita;
	//private ArrayList<String> carte_di_credito;

}

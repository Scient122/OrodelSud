package JUnit;

import java.sql.Date;
import Bean.*;
public class ComposizioneBean_Stub extends ComposizioneBean {

	public ComposizioneBean_Stub () {
		
	}
	
	public String getCodice_prodotto() {
		return codice_prodotto;
		
	}
	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}
	public String getNumero_fattura() {
		return numero_fattura;
	}
	public void setNumero_fattura(String numero_fattura) {
		this.numero_fattura = numero_fattura;
	}
	public int getQuantita_acquistate() {
		return quantita_acquistate;
	}
	public void setQuantita_acquistate(int quantita_acquistate) {
		this.quantita_acquistate = quantita_acquistate;
	}
	public int getIva_acquisto() {
		return iva_acquisto;
	}
	public void setIva_acquisto(int iva_acquisto) {
		this.iva_acquisto = iva_acquisto;
	}
	public double getPrezzo_acquisto() {
		return prezzo_acquisto;
	}
	public void setPrezzo_acquisto(double prezzo_acquisto) {
		this.prezzo_acquisto = prezzo_acquisto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	private String codice_prodotto="1", numero_fattura="2", nome_prodotto="Pasta";
	private int quantita_acquistate=3, iva_acquisto=22;
	private double prezzo_acquisto=20;
	private Date data=Date.valueOf("2020-10-10");
}




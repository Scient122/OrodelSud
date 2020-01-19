package JUnit;

import java.sql.Blob;

import Bean.ProdottoBean;
import Servlet.Utilities;

public class ProdottoBean_Stub extends ProdottoBean {

public ProdottoBean_Stub() { 
		
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome_prodotto() {
		return nome_prodotto;
	}
	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getConservazione() {
		return conservazione;
	}
	public void setConservazione(String conservazione) {
		this.conservazione = conservazione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getQuantita_disponibili() {
		return quantita_disponibili;
	}
	public void setQuantita_disponibili(int quantita_disponibili) {
		this.quantita_disponibili = quantita_disponibili;
	}
	public double getPrezzo_base() {
		return Utilities.round(prezzo_base,2);
	}
	public void setPrezzo_base(double prezzo_base) {
		this.prezzo_base = prezzo_base;
	}
	public double getPrezzo_totale() {
		return Utilities.round(prezzo_totale, 2);
	}
	public void setPrezzo_totale(double prezzo_totale) {
		this.prezzo_totale = prezzo_totale;
	}
	public boolean isOfferta() {
		return offerta;
	}
	public void setOfferta(boolean offerta) {
		this.offerta = offerta;
	}
	
	
	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}



	private String codice="23", nome_prodotto="Belicino", descrizione="Confezione da 1kg", conservazione="2020-05-05", categoria="Formaggio"; 
	private int iva=22, quantita_disponibili=45;
	private double prezzo_base=1.5, prezzo_totale=2.4;
	private boolean offerta=false;
	private String azienda="azienda";
	private Blob immagine=null;

	
}

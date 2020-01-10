package Bean;
import java.sql.*;

import Servlet.*;


public class ProdottoBean {
	
	public ProdottoBean() {
		
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
	public Blob getImmagine() {
		return immagine;
	}
	public void setImmagine(Blob immagine) {
		this.immagine = immagine;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String Base64Image) {
		this.base64Image=Base64Image;
		
	}
	
	
	
	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}



	private String codice, nome_prodotto, descrizione, conservazione, categoria, base64Image; 
	private int iva, quantita_disponibili;
	private double prezzo_base, prezzo_totale;
	private boolean offerta;
	private Blob immagine;
	private String azienda;

}

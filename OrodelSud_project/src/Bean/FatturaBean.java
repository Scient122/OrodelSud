package Bean;

import java.sql.Date;

public class FatturaBean {

	public FatturaBean() {
		
	}
	
	public String getN_documento() {
		return n_documento;
		
	}
	public void setN_documento(String n_documento) {
		this.n_documento = n_documento;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public double getTotale_imponibile() {
		return totale_imponibile;
	}
	public void setTotale_imponibile(double totale_imponibile) {
		this.totale_imponibile = totale_imponibile;
	}
	public double getTotale_imposta() {
		return totale_imposta;
	}
	public void setTotale_imposta(double totale_imposta) {
		this.totale_imposta = totale_imposta;
	}
	public double getCosto_totale() {
		return costo_totale;
	}
	public void setCosto_totale(double costo_totale) {
		this.costo_totale = costo_totale;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private String n_documento, via, destinatario, status;
	private double totale_imponibile, totale_imposta, costo_totale;
	private Date data;
}

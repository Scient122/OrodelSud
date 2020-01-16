package JUnit;
import java.sql.Blob;

import Bean.*;

public class RicettaBean_Stub extends RicettaBean{
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProvenienza() {
		return provenienza;
	}
	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}
	
	
	
	public String getBase64Image() {
		return base64Image;
	}
	
	public void setBase64Image(String Base64Image) {
		this.base64Image=Base64Image;
		
	}
	
	private String titolo="Spaghetti",descrizione="Buoni",categoria="Primo",provenienza="Campania",base64Image;

}

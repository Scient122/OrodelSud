package JUnit;
import Bean.*;
import Gestione_catalogo.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import Bean.ProdottoBean;
import Connection.*;
import Servlet.Utilities;

public class ProdottoDAO_Stub extends ProdottoDAO{
	
	public synchronized ArrayList <ProdottoBean> Cinqueprodotti(int contatore) throws SQLException,IOException {
		System.out.println("Cinqueprodotti");
		ArrayList<ProdottoBean> prodotti= new ArrayList<ProdottoBean>();
		
		for(int i=0;i<5; ) {
			prodotti.add(new ProdottoBean_Stub());
			
			
		}
		return prodotti;
		
	}
	
	public synchronized ArrayList <ProdottoBean> Cinqueprodotti(int contatore, String azienda) throws SQLException,IOException {
		
		System.out.println("Cinqueprodotti");
ArrayList<ProdottoBean> prodotti= new ArrayList<ProdottoBean>();
		
		for(int i=0;i<5; ) {
			prodotti.add(new ProdottoBean_Stub());
	
	}
		return prodotti;
	}
	
	public synchronized int conteggio () throws SQLException {
		
		System.out.println("conteggio");
		return 3;
		}
		
		
		
	
	
	public synchronized int conteggio (String categoria) throws SQLException {
		System.out.println("conteggio");
		return 3;
	}
	
	public synchronized int conteggiofferta () throws SQLException {
		System.out.println("conteggiofferta");
		return 3;
	}
	
	
	public synchronized int conteggionome (String nome) throws SQLException {
		System.out.println("conteggionome");
		return 3;
	}
	
	public synchronized int conteggio_azienda (String azienda) throws SQLException {
		System.out.println("conteggio azienda");
		return 3;
	}
	
	public synchronized ProdottoBean unprodotto (String codice) throws SQLException, IOException {
		System.out.println("unprodotto");
		return new ProdottoBean_Stub();
		}
	
	public synchronized ArrayList<ProdottoBean> categoriaprodotto (String codice, int contatore) throws SQLException, IOException {
	
	System.out.println("categoriaprodotto");
	ArrayList<ProdottoBean> prodotti= new ArrayList<ProdottoBean>();
	
	for(int i=0;i<5; ) {
		prodotti.add(new ProdottoBean_Stub());
	}
	
	return prodotti;
	}
	
	public synchronized ArrayList<ProdottoBean> prodottofferta (int contatore) throws SQLException, IOException {
		
		System.out.println("prodottoofferta");
ArrayList<ProdottoBean> prodotti= new ArrayList<ProdottoBean>();
		
		for(int i=0;i<5; ) {
			prodotti.add(new ProdottoBean_Stub());
}
		return prodotti;
	}
	
	
	
		public synchronized ArrayList<ProdottoBean> searchbar (int contatore, String nome) throws SQLException, IOException {
			
			System.out.println("searchbar");
			ArrayList<ProdottoBean> prodotti= new ArrayList<ProdottoBean>();
			
			for(int i=0;i<5; ) {
				prodotti.add(new ProdottoBean_Stub());
			}
			return prodotti;
}
		
	public synchronized  boolean aggiornamento (String colonna, int valore, String chiave) throws SQLException {
			
		System.out.println("aggiornamento");
		return true;
		}
	
	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {
		
		System.out.println("aggiornamento");
		return true;
		}
	
	public synchronized  boolean aggiornamento (String colonna, double valore, String chiave) throws SQLException {
		
		System.out.println("aggiornamento");
		return true;
		}
	
	public synchronized void cancellazione (String nome) throws SQLException {
	
		System.out.println("cancellazione");
	}
	
	public synchronized void aggiornamento (byte[] flusso,String codice) throws SQLException {
		
		System.out.println("aggiornamento");
		
		
	}
	
	public synchronized void changeiva (int iva) throws SQLException {
		
		System.out.println("changeiva");
	}
	
		public synchronized void aggiunta (ProdottoBean prodotto) throws SQLException {
		
		System.out.println("aggiunta");
}
		
		public synchronized static int highest () throws SQLException, IOException {
			
			System.out.println("highest");
			return 3;
		}
		
		public synchronized ProdottoBean unprodottocodice (String codice) throws SQLException, IOException {
			System.out.println("unprodottocodice");
			return new ProdottoBean_Stub();
			}
		

}

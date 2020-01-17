package Gestione_catalogo;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import Bean.ProdottoBean;
import Connection.*;
import Servlet.Utilities;

public class ProdottoDAO { 
	
	public synchronized ArrayList <ProdottoBean> Cinqueprodotti(int contatore) throws SQLException,IOException {
		String query="SELECT * FROM prodotto";
		Connection connection=null;
		Statement frase = null;
		ProdottoBean prodotto = null;
		ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		ResultSet risultato = null;
		int inferiore, superiore;
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.createStatement();
			risultato = frase.executeQuery(query);
			risultato.beforeFirst();
			superiore=5*contatore;
			inferiore=superiore-4;
			risultato.absolute(inferiore-1);
			int i=0;
			
			while (i<5 && risultato.next()) {
				prodotto = new ProdottoBean();
				prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
				prodotto.setPrezzo_totale(risultato.getInt("prezzo_totale"));
				prodotto.setPrezzo_base(risultato.getInt("prezzo_base"));
				prodotto.setOfferta(risultato.getBoolean("offerta"));
				prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
				prodotto.setIva(risultato.getInt("iva"));
				prodotto.setDescrizione(risultato.getString("descrizione"));
				prodotto.setConservazione(risultato.getString("conservazione"));
				prodotto.setCodice(risultato.getString("codice"));
				prodotto.setCategoria(risultato.getString("categoria"));
				prodotto.setImmagine(risultato.getBlob("immagine"));
				prodotto.setAzienda(risultato.getString("azienda"));
				
				Blob blob=prodotto.getImmagine();
				InputStream stream=blob.getBinaryStream();
				prodotto.setBase64Image(Utilities.convertImage(stream));
				
				prodotti.add(prodotto);
				i++;
			} 
			
			return prodotti;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized ArrayList <ProdottoBean> Cinqueprodotti(int contatore, String azienda) throws SQLException,IOException {
		String query="SELECT * FROM prodotto WHERE azienda='"+azienda+"'";
		Connection connection=null;
		Statement frase = null;
		ProdottoBean prodotto = null;
		ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		ResultSet risultato = null;
		int inferiore, superiore;
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.createStatement();
			risultato = frase.executeQuery(query);
			risultato.beforeFirst();
			superiore=5*contatore;
			inferiore=superiore-4;
			risultato.absolute(inferiore-1);
			int i=0;
			
			while (i<5 && risultato.next()) {
				prodotto = new ProdottoBean();
				prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
				prodotto.setPrezzo_totale(risultato.getInt("prezzo_totale"));
				prodotto.setPrezzo_base(risultato.getInt("prezzo_base"));
				prodotto.setOfferta(risultato.getBoolean("offerta"));
				prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
				prodotto.setIva(risultato.getInt("iva"));
				prodotto.setDescrizione(risultato.getString("descrizione"));
				prodotto.setConservazione(risultato.getString("conservazione"));
				prodotto.setCodice(risultato.getString("codice"));
				prodotto.setCategoria(risultato.getString("categoria"));
				prodotto.setImmagine(risultato.getBlob("immagine"));
				prodotto.setAzienda(risultato.getString("azienda"));

				Blob blob=prodotto.getImmagine();
				InputStream stream=blob.getBinaryStream();
				prodotto.setBase64Image(Utilities.convertImage(stream));
				System.out.println("stampo nome"+prodotto.getNome_prodotto());
				prodotti.add(prodotto);
				i++;
			} 
			
			return prodotti;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized int conteggio () throws SQLException {
		String query="SELECT * FROM prodotto";
		Connection connection=null;
		Statement frase = null;
		ResultSet risultato = null;
		int i=0;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.createStatement();
			risultato = frase.executeQuery(query);
			risultato.beforeFirst();
			
			while (risultato.next()) {
				i++;
			}
			return i;
		}
		
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized int conteggio (String categoria) throws SQLException {
		String query="SELECT * FROM prodotto WHERE categoria=?";
		Connection connection=null;
		PreparedStatement frase = null;
		ResultSet risultato = null;
		int i=0;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.prepareStatement(query);
			frase.setString(1,categoria);
			risultato=frase.executeQuery();
			risultato.beforeFirst();
			
			while (risultato.next()) {
				i++;
			}
			return i;
		}
		
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized int conteggiofferta () throws SQLException {
		String query="SELECT * FROM prodotto WHERE offerta=?";
		Connection connection=null;
		PreparedStatement frase = null;
		ResultSet risultato = null;
		int i=0;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.prepareStatement(query);
			frase.setBoolean(1,true);
			risultato=frase.executeQuery();
			risultato.beforeFirst();
			
			while (risultato.next()) {
				i++;
			}
			return i;
		}
		
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	
	public synchronized int conteggionome (String nome) throws SQLException {
		String query = "SELECT * FROM prodotto where nome_prodotto like '%"+nome+"%'";
		Connection connection=null;
		Statement frase = null;
		
		ResultSet risultato = null;
		int i=0;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.prepareStatement(query);
			//frase.setString(1,nome);
			risultato=frase.executeQuery(query);
			risultato.beforeFirst();
			
			while (risultato.next()) {
				i++;
			}
			return i;
		}
		
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized int conteggio_azienda (String azienda) throws SQLException {
		String query="SELECT * FROM prodotto WHERE azienda=?";
		Connection connection=null;
		PreparedStatement frase = null;
		ResultSet risultato = null;
		int i=0;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			frase=connection.prepareStatement(query);
			frase.setString(1,azienda);
			risultato=frase.executeQuery();
			risultato.beforeFirst();
			
			while (risultato.next()) {
				i++;
			}
			return i;
		}
		
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized ProdottoBean unprodotto (String codice) throws SQLException, IOException {
		String query = "SELECT * FROM prodotto where nome_prodotto=?";
		Connection connection=null;
		PreparedStatement statement = null;
		ResultSet risultato = null;
		ProdottoBean prodotto;
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,codice);
			risultato=statement.executeQuery();

			if(risultato.first()) {
			
				prodotto=new ProdottoBean();
				prodotto.setCodice(risultato.getString("codice"));
				prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
				prodotto.setDescrizione(risultato.getString("descrizione"));
				prodotto.setConservazione(risultato.getString("conservazione"));
				prodotto.setCategoria(risultato.getString("categoria"));
				prodotto.setIva(risultato.getInt("iva"));
				prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
				prodotto.setPrezzo_base(risultato.getDouble("prezzo_base"));
				prodotto.setPrezzo_totale(risultato.getDouble("prezzo_totale"));
				prodotto.setOfferta(risultato.getBoolean("offerta"));
				prodotto.setAzienda(risultato.getString("azienda"));

				prodotto.setImmagine(risultato.getBlob("immagine"));
				Blob blob=prodotto.getImmagine();
				InputStream stream=blob.getBinaryStream();
				prodotto.setBase64Image(Utilities.convertImage(stream));
			
			return prodotto;
			}
			else
				return null;
	}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	
	public synchronized ArrayList<ProdottoBean> categoriaprodotto (String codice, int contatore) throws SQLException, IOException {
	
	ArrayList<ProdottoBean> prodotti=new ArrayList<ProdottoBean>();
	String query="SELECT * FROM prodotto WHERE categoria=?";
	PreparedStatement statement=null;
	Connection connection=null;
	int superiore, inferiore;
	
	try {
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		statement=connection.prepareStatement(query);
		statement.setString(1,codice);
		ResultSet risultato=statement.executeQuery();
		risultato.beforeFirst();
		
		
		superiore=5*contatore;
		inferiore=superiore-4;
		risultato.absolute(inferiore-1);
		int i=0;
		
		
		while(i<5 && risultato.next()) {
			ProdottoBean prodotto=new ProdottoBean();
			prodotto.setCodice(risultato.getString("codice"));
			prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
			prodotto.setDescrizione(risultato.getString("descrizione"));
			prodotto.setConservazione(risultato.getString("conservazione"));
			prodotto.setCategoria(risultato.getString("categoria"));
			prodotto.setIva(risultato.getInt("iva"));
			prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
			prodotto.setPrezzo_base(risultato.getDouble("prezzo_base"));
			prodotto.setPrezzo_totale(risultato.getDouble("prezzo_totale"));
			prodotto.setOfferta(risultato.getBoolean("offerta"));
			prodotto.setAzienda(risultato.getString("azienda"));

			prodotto.setImmagine(risultato.getBlob("immagine"));
			Blob blob=prodotto.getImmagine();
			InputStream stream=blob.getBinaryStream();
			prodotto.setBase64Image(Utilities.convertImage(stream));
			prodotti.add(prodotto);
			i++;
		}
		
		return prodotti;
	}
	
	finally {
		DriverMaagerConnectionPool.releaseConnection(connection);
	}
	}
	
	public synchronized ArrayList<ProdottoBean> prodottofferta (int contatore) throws SQLException, IOException {
		
		ArrayList<ProdottoBean> prodotti=new ArrayList<ProdottoBean>();
		String query="SELECT * FROM prodotto WHERE offerta=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int superiore, inferiore;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setBoolean(1, true);
			ResultSet risultato=statement.executeQuery();
			risultato.beforeFirst();
			
			
			superiore=5*contatore;
			inferiore=superiore-4;
			risultato.absolute(inferiore-1);
			int i=0;
			
			
			while(i<5 && risultato.next()) {
				ProdottoBean prodotto=new ProdottoBean();
				prodotto.setCodice(risultato.getString("codice"));
				prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
				prodotto.setDescrizione(risultato.getString("descrizione"));
				prodotto.setConservazione(risultato.getString("conservazione"));
				prodotto.setCategoria(risultato.getString("categoria"));
				prodotto.setIva(risultato.getInt("iva"));
				prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
				prodotto.setPrezzo_base(risultato.getDouble("prezzo_base"));
				prodotto.setPrezzo_totale(risultato.getDouble("prezzo_totale"));
				prodotto.setOfferta(risultato.getBoolean("offerta"));
				prodotto.setAzienda(risultato.getString("azienda"));

				prodotto.setImmagine(risultato.getBlob("immagine"));
				Blob blob=prodotto.getImmagine();
				InputStream stream=blob.getBinaryStream();
				prodotto.setBase64Image(Utilities.convertImage(stream));
				prodotti.add(prodotto);
				i++;
			}
			
			return prodotti;
	
	}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
}
	
	
	
		public synchronized ArrayList<ProdottoBean> searchbar (int contatore, String nome) throws SQLException, IOException {
			
			String query = "SELECT * FROM prodotto where nome_prodotto like '%"+nome+"%'";
			Connection connection=null;
			Statement statement = null;
			ResultSet risultato = null;
			ProdottoBean prodotto;
			int superiore, inferiore;
			ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
			
			try {
				connection=DriverMaagerConnectionPool.getConnection();
				connection.setAutoCommit(true);
				statement=connection.prepareStatement(query);
				//statement.setBoolean(1, true);
				//risultato=statement.executeQuery();
				risultato=statement.executeQuery(query);
				risultato.beforeFirst();
				
				
				superiore=5*contatore;
				inferiore=superiore-4;
				risultato.absolute(inferiore-1);
				int i=0;
				
				
				while(i<5 && risultato.next()) {
					prodotto=new ProdottoBean();
				
					prodotto.setCodice(risultato.getString("codice"));
					prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
					prodotto.setDescrizione(risultato.getString("descrizione"));
					prodotto.setConservazione(risultato.getString("conservazione"));
					prodotto.setCategoria(risultato.getString("categoria"));
					prodotto.setIva(risultato.getInt("iva"));
					prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
					prodotto.setPrezzo_base(risultato.getDouble("prezzo_base"));
					prodotto.setPrezzo_totale(risultato.getDouble("prezzo_totale"));
					prodotto.setOfferta(risultato.getBoolean("offerta"));
					prodotto.setImmagine(risultato.getBlob("immagine"));
					Blob blob=prodotto.getImmagine();
					InputStream stream=blob.getBinaryStream();
					prodotto.setBase64Image(Utilities.convertImage(stream));
					prodotto.setAzienda(risultato.getString("azienda"));

					prodotti.add(prodotto);
					i++;
				}
				
				return prodotti;
		
		}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
}
		
	public synchronized  boolean aggiornamento (String colonna, int valore, String chiave) throws SQLException {
			
		String query="UPDATE prodotto SET "+colonna+"= ? WHERE codice=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int restituzione;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setInt(1, valore);
			statement.setString(2, chiave);
			
			restituzione=statement.executeUpdate();
				
			if (restituzione==1) {
					return true;
				}
				return false;
			}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	
	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {
		
		String query="UPDATE prodotto SET "+colonna+"= ? WHERE codice=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int restituzione;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setString(1, valore);
			statement.setString(2, chiave);
			
			restituzione=statement.executeUpdate();
				
			if (restituzione==1) {
					return true;
				}
				return false;
			}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	
	public synchronized  boolean aggiornamento (String colonna, double valore, String chiave) throws SQLException {
		
		String query="UPDATE prodotto SET "+colonna+"= ? WHERE codice=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int restituzione;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setDouble(1, valore);
			statement.setString(2, chiave);
			
			restituzione=statement.executeUpdate();
				
			if (restituzione==1) {
					return true;
				}
				return false;
			}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	
	public synchronized void cancellazione (String nome) throws SQLException {
	
		String query = "DELETE FROM prodotto WHERE nome_prodotto=?";
		
		PreparedStatement statement=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setString(1, nome);
			statement.executeUpdate();
	}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
	
	public synchronized void aggiornamento (byte[] flusso,String codice) throws SQLException {
		
		String query="UPDATE prodotto SET immagine=? WHERE codice=?";
		PreparedStatement statement=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setBytes(1, flusso);
			statement.setString(2, codice);
			
			statement.executeUpdate();
				
		}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		
	}
	
	public synchronized void changeiva (int iva) throws SQLException {
		
		String query="UPDATE prodotto SET iva=?";
		PreparedStatement statement=null, statement1=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setInt(1, iva);
			statement.executeUpdate();
				
			String query1 = "UPDATE prodotto SET prezzo_totale=((prezzo_base*iva)/100)+prezzo_base";
			statement1=connection.prepareStatement(query1);	
			statement1.executeUpdate();

			
		}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
	}
	
		public synchronized void aggiunta (ProdottoBean prodotto) throws SQLException {
		
		String query="INSERT INTO prodotto (codice, nome_prodotto, descrizione, iva, prezzo_base, quantita_disponibili, offerta, prezzo_totale, conservazione, categoria, immagine, azienda) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);	
			
			statement.setString(1, prodotto.getCodice());
			statement.setString(2, prodotto.getNome_prodotto());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getIva());
			statement.setDouble(5, prodotto.getPrezzo_base());
			statement.setInt(6, prodotto.getQuantita_disponibili());
			statement.setBoolean(7, prodotto.isOfferta());
			statement.setDouble(8, prodotto.getPrezzo_totale());
			statement.setString(9, prodotto.getConservazione());
			statement.setString(10, prodotto.getCategoria());
			statement.setBlob(11, prodotto.getImmagine());
			statement.setString(12, prodotto.getAzienda());
			statement.executeUpdate();
		}
			
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
	
}
		
		public synchronized static int highest () throws SQLException, IOException {
			
			String query="SELECT codice FROM prodotto";
			int max=0;
			Connection connection=null;
			Statement frase = null;
			ResultSet risultato;
			try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			
			frase=connection.prepareStatement(query);
			risultato = frase.executeQuery(query);
			
			risultato.beforeFirst();
			
			while (risultato.next()) {
				if (Integer.parseInt(risultato.getString("codice"))>max) {
					max = Integer.parseInt(risultato.getString("codice"));
				}
			}
			
			return max;

			}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);

			}
		}
		
		public synchronized ProdottoBean unprodottocodice (String codice) throws SQLException, IOException {
			String query = "SELECT * FROM prodotto where codice=?";
			Connection connection=null;
			PreparedStatement statement = null;
			ResultSet risultato = null;
			ProdottoBean prodotto;
			try {
				connection=DriverMaagerConnectionPool.getConnection();
				connection.setAutoCommit(true);
				statement=connection.prepareStatement(query);
				statement.setString(1,codice);
				risultato=statement.executeQuery();

				if(risultato.first()) {
				
					prodotto=new ProdottoBean();
					prodotto.setCodice(risultato.getString("codice"));
					prodotto.setNome_prodotto(risultato.getString("nome_prodotto"));
					prodotto.setDescrizione(risultato.getString("descrizione"));
					prodotto.setConservazione(risultato.getString("conservazione"));
					prodotto.setCategoria(risultato.getString("categoria"));
					prodotto.setIva(risultato.getInt("iva"));
					prodotto.setQuantita_disponibili(risultato.getInt("quantita_disponibili"));
					prodotto.setPrezzo_base(risultato.getDouble("prezzo_base"));
					prodotto.setPrezzo_totale(risultato.getDouble("prezzo_totale"));
					prodotto.setOfferta(risultato.getBoolean("offerta"));
					prodotto.setAzienda(risultato.getString("azienda"));

					prodotto.setImmagine(risultato.getBlob("immagine"));
					Blob blob=prodotto.getImmagine();
					InputStream stream=blob.getBinaryStream();
					prodotto.setBase64Image(Utilities.convertImage(stream));
				
				return prodotto;
				}
				else
					return null;
		}
			finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
				}
			}
		
}

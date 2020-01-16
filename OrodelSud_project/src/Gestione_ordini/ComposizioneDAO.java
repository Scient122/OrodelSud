package Gestione_ordini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ComposizioneBean;
import Model.DriverMaagerConnectionPool;

public class ComposizioneDAO {

	public ComposizioneDAO() {
		
	}
	
	public synchronized boolean aggiunta (ComposizioneBean comp) throws SQLException {
		
		String query = "INSERT INTO composizione (codice_prodotto, numero_fattura, quantita_acquistate, iva_acquisto, prezzo_acquisto, data_acquisto, nome_prodotto) values (?, ?, ?, ?, ?, ?,?)";
		
		PreparedStatement statement = null;
		Connection connection = null;
	
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, comp.getCodice_prodotto());
			statement.setString(2, comp.getNumero_fattura());
			statement.setInt(3, comp.getQuantita_acquistate());
			statement.setInt(4, comp.getIva_acquisto());
			statement.setDouble(5, comp.getPrezzo_acquisto());
			statement.setDate(6, comp.getData());
			statement.setString(7, comp.getNome_prodotto());
			statement.executeUpdate();
			return true;
			
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);

		}
		
	}
	
public synchronized ArrayList<ComposizioneBean> getprodotti (String n_documento) throws SQLException, IOException {
		
		String query = "SELECT * FROM composizione WHERE numero_fattura=?";
		
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet risultato = null, risultato1=null;
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		ArrayList<ComposizioneBean> contenitore = new ArrayList<ComposizioneBean>();
		ComposizioneBean comp = null;
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, n_documento);
			risultato = statement.executeQuery();
			
			risultato.beforeFirst();
		
		while (risultato.next()) {
			comp = new ComposizioneBean();
			comp.setCodice_prodotto(risultato.getString("codice_prodotto"));
			comp.setData(risultato.getDate("data_acquisto"));
			comp.setIva_acquisto(risultato.getInt("iva_acquisto"));
			comp.setNome_prodotto(risultato.getString("nome_prodotto"));
			comp.setNumero_fattura(risultato.getString("numero_fattura"));
			comp.setPrezzo_acquisto(risultato.getDouble("prezzo_acquisto"));
			comp.setQuantita_acquistate(risultato.getInt("quantita_acquistate"));
			contenitore.add(comp);
			}
		return contenitore;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}	
	}
	
public synchronized ArrayList<ComposizioneBean> getprodottiazienda (String n_documento) throws SQLException, IOException {
	
	String query = "SELECT * FROM composizione WHERE numero_fattura=?";
	
	PreparedStatement statement = null;
	Connection connection = null;
	ResultSet risultato = null, risultato1=null;
	connection=DriverMaagerConnectionPool.getConnection();
	connection.setAutoCommit(true);
	ArrayList<ComposizioneBean> contenitore = new ArrayList<ComposizioneBean>();
	ComposizioneBean comp = null;
	try {
		statement=connection.prepareStatement(query);
		statement.setString(1, n_documento);
		risultato = statement.executeQuery();
		
		risultato.beforeFirst();
	
	while (risultato.next()) {
		comp = new ComposizioneBean();
		comp.setCodice_prodotto(risultato.getString("codice_prodotto"));
		comp.setData(risultato.getDate("data_acquisto"));
		comp.setIva_acquisto(risultato.getInt("iva_acquisto"));
		comp.setNome_prodotto(risultato.getString("nome_prodotto"));
		comp.setNumero_fattura(risultato.getString("numero_fattura"));
		comp.setPrezzo_acquisto(risultato.getDouble("prezzo_acquisto"));
		comp.setQuantita_acquistate(risultato.getInt("quantita_acquistate"));
		contenitore.add(comp);
		}
	return contenitore;
	}
	
	finally {
		DriverMaagerConnectionPool.releaseConnection(connection);
	}	
}
	
	
}

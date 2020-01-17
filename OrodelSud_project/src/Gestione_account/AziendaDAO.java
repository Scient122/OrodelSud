package Gestione_account;
import java.sql.*;
import java.util.HashMap;

import Bean.AziendaBean;
import Connection.DriverMaagerConnectionPool;

public class AziendaDAO {

	public synchronized  AziendaBean login(String email,String password) throws SQLException {

		String query="SELECT * FROM "+AZIENDA+" WHERE email=? AND pass=?";
		PreparedStatement statement=null;
		Connection connection=null;

		try {
			connection=DriverMaagerConnectionPool.getConnection();
			statement=connection.prepareStatement(query);
			statement.setString(1,email);
			statement.setString(2,password);
			ResultSet risultato=statement.executeQuery();
			if(!risultato.first())
				return null;
			else {
				AziendaBean utente=new AziendaBean();
				utente.setEmail(risultato.getString("email"));
				utente.setPassword(risultato.getString("pass"));
				utente.setNome(risultato.getString("nome"));
				utente.setVia(risultato.getString("via"));
				utente.setCap(risultato.getString("cap"));
				utente.setCitta(risultato.getString("citta"));
				utente.setNumero_civico(risultato.getString("n_civico"));
				utente.setNumero_di_telefono(risultato.getString("numero_telefono"));

				return utente;
			}

		}

		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}

	private synchronized boolean check (String email) throws SQLException {

		String email1 = email;

		Connection connection=DriverMaagerConnectionPool.getConnection();
		String query="SELECT * FROM "+AZIENDA+" WHERE email=?";
		String query1="SELECT * FROM amministratore WHERE email=?";
		String query2="SELECT * FROM cliente WHERE email=?";
		PreparedStatement statement=null;
		statement=connection.prepareStatement(query1);
		try {
			statement.setString(1,email1);
			ResultSet risultato=statement.executeQuery();

			if(risultato.first())
				return false;
			else {
				statement=connection.prepareStatement(query);
				statement.setString(1, email1);
				risultato=statement.executeQuery();
			}

			if (risultato.first())
				return false;
			else 
			{ 			
				statement=connection.prepareStatement(query2);
				statement.setString(1, email1);
				risultato=statement.executeQuery();
			};

			if(risultato.first()) 
				return false;
			else
				return true;
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}

	}

	public synchronized boolean registration(AziendaBean cliente) throws SQLException {

		boolean risultato = check(cliente.getEmail());
		String query=null;
		PreparedStatement statement=null;
		Connection connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		ResultSet result=null;
		try {
			if (risultato) {
				/*if (cliente.getNumero_di_telefono()==null) {
					query="insert into cliente (email, nome, cognome, via, cap, citta, n_civico, pass, n_punti, data_nascita) values (?,?,?,?,?,?,?,?,?,?)";
					statement=connection.prepareStatement(query);
					statement.setString(1,cliente.getEmail());
					statement.setString(2,cliente.getNome());
					statement.setString(3,cliente.getCognome());
					statement.setString(4,cliente.getVia());
					statement.setString(5,cliente.getCap());
					statement.setString(6,cliente.getCitta());
					statement.setString(7,cliente.getNumero_civico());
					statement.setString(8,cliente.getPassword());
					statement.setInt(9,0);
					statement.setDate(10,cliente.getData_di_nascita());
					int z = statement.executeUpdate();
				}*/
				query="insert into azienda values (?,?,?,?,?,?,?,?)";
				statement=connection.prepareStatement(query);
				statement=connection.prepareStatement(query);
				statement.setString(1,cliente.getEmail());
				statement.setString(2,cliente.getNome());
				statement.setString(3,cliente.getVia());
				statement.setString(4,cliente.getCap());
				statement.setString(5,cliente.getCitta());
				statement.setString(6,cliente.getNumero_civico());
				statement.setString(7,cliente.getPassword());
				statement.setString(8,cliente.getNumero_di_telefono());
				int z = statement.executeUpdate();
				return true;
			}
			else
				return false;
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}

	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {

		String query="UPDATE azienda SET "+colonna+"= ? WHERE email=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int restituzione;
		Date data;

		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);

			if (colonna.equals("data_nascita")) {

				data=Date.valueOf(valore);
				statement.setDate(1, data);

				statement.setString(2, chiave);
				restituzione=statement.executeUpdate();


				if (restituzione==1) {
					return true;
				}
			}
			else {

				statement.setString(1, valore);
				statement.setString(2, chiave);

				restituzione=statement.executeUpdate();

				if (restituzione==1) {
					return true;
				}

			}
			return false;
		}

		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}

	public synchronized  boolean aggiornamento (String colonna, int valore, String chiave) throws SQLException {

		String query="UPDATE azienda SET "+colonna+"= ? WHERE email=?";
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

	private final static String AZIENDA="azienda";
}


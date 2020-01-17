package Gestione_account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.AdminBean;
import Connection.DriverMaagerConnectionPool;

public class AdminDAO {

public synchronized  AdminBean login(String email,String password) throws SQLException {
		
		String query="SELECT * FROM "+ADMIN+" WHERE email=? AND pass=?";
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
				AdminBean admin=new AdminBean();
				admin.setEmail(risultato.getString("email"));
				admin.setPassword(risultato.getString("pass"));
				admin.setNome(risultato.getString("nome"));
				admin.setCognome(risultato.getString("cognome"));
				admin.setVia(risultato.getString("via"));
				admin.setCap(risultato.getString("cap"));
				admin.setCitta(risultato.getString("citta"));
				admin.setNumero_civico(risultato.getString("n_civico"));
				admin.setData_di_nascita(risultato.getDate("data_nascita"));
				admin.setNumero_di_telefono(risultato.getString("n_telefono"));
				return admin;
			}
			
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
		
	}

	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {
		
		String query="UPDATE amministratore SET "+colonna+"= ? WHERE email=?";
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

	private final static String ADMIN="amministratore";
	
}

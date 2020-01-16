package Gestione_ordini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.EffettuazioneBean;
import Model.DriverMaagerConnectionPool;

public class EffettuazioneDAO {
	
	public synchronized boolean aggiunta (EffettuazioneBean eff) throws SQLException {
		
		String query = "INSERT INTO effettuazione (email_cliente, numero_documento) values (?,?)";
		
		PreparedStatement statement = null;
		Connection connection = null;
	
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, eff.getEmail());
			statement.setString(2, eff.getNumero());
			
			statement.executeUpdate();
			return true;
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);

		}
		
	}

}

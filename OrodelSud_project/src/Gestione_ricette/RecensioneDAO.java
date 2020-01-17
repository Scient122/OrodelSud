package Gestione_ricette;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ProdottoBean;
import Bean.RecensioneBean;
import Connection.DriverMaagerConnectionPool;
import Servlet.Utilities;

public class RecensioneDAO {

	public synchronized ArrayList<RecensioneBean> recensioni (String titolo) throws SQLException, IOException {
		String query = "SELECT * FROM recensione WHERE titolo_ricetta=?";
		Connection connection=null;
		PreparedStatement statement = null;
		ResultSet risultato = null;
		RecensioneBean recensione = null;
		ArrayList<RecensioneBean> recensioni = new ArrayList<RecensioneBean>();

		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,titolo);
			risultato=statement.executeQuery();

			risultato.beforeFirst();
			while(risultato.next()) {
				recensione = new RecensioneBean();
				recensione.setCommento(risultato.getString("commento"));
				recensione.setEmail_cliente(risultato.getString("email_cliente"));
				recensione.setTitolo_ricetta(risultato.getString("titolo_ricetta"));
				recensioni.add(recensione);
			}
			return recensioni;

		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}


	public synchronized boolean aggiunta (RecensioneBean recensione) throws SQLException, IOException {
		String query = "INSERT INTO recensione (email_cliente, titolo_ricetta, commento) VALUES (?,?,?)";
		Connection connection=null;
		PreparedStatement statement = null;
		ResultSet risultato = null;
		try {

			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);

			statement.setString(1, recensione.getEmail_cliente());
			statement.setString(2, recensione.getTitolo_ricetta());
			statement.setString(3, recensione.getCommento());
			statement.executeUpdate();

			return true;
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}	
}
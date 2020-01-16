package Gestione_ordini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.sql.StatementEvent;

import Bean.FatturaBean;
import Model.DriverMaagerConnectionPool;

public class FatturaDAO {

	public FatturaDAO() {

	}

	public synchronized static int highest () throws SQLException, IOException {

		String query="SELECT n_documento FROM fattura";
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
				if (Integer.parseInt(risultato.getString("n_documento"))>max) {
					max = Integer.parseInt(risultato.getString("n_documento"));
				}
			}

			return max;

		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);

		}
	}

	public synchronized boolean inserimento (FatturaBean fattura) throws SQLException, IOException {

		String query = "INSERT INTO fattura (n_documento,data_fattura,totale_imponibile, totale_imposta, costo_totale, via, destinatario, status) values (?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		Connection connection = null;

		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);

		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, fattura.getN_documento());
			statement.setDate(2, fattura.getData());
			statement.setDouble(3, fattura.getTotale_imponibile());
			statement.setDouble(4, fattura.getTotale_imposta());
			statement.setDouble(5, fattura.getCosto_totale());
			statement.setString(6, fattura.getVia());
			statement.setString(7, fattura.getDestinatario());
			statement.setString(8, fattura.getStatus());
			statement.executeUpdate();
			return true;
		}
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);

		}	
	}

	public synchronized ArrayList<FatturaBean> getfatture (String email) throws SQLException, IOException {
		String query = "SELECT * FROM effettuazione WHERE email_cliente=?";

		FatturaBean fattura = null;
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet risultato = null, risultato1=null;
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		ArrayList<Integer> contenitore = new ArrayList<Integer>();
		ArrayList<FatturaBean> contenitorefattura = new ArrayList<FatturaBean>();
		String query1 = "";

		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, email);
			risultato = statement.executeQuery();


			risultato.beforeFirst();

			while (risultato.next()) {
				contenitore.add(Integer.parseInt(risultato.getString("numero_documento")));
			}

			for (Integer i : contenitore) {
				fattura =  new FatturaBean();
				query1="SELECT * FROM fattura WHERE n_documento=?";
				statement=connection.prepareStatement(query1);
				statement.setString(1, ""+i);
				risultato1= statement.executeQuery();

				risultato1.first();
				fattura.setN_documento(risultato1.getString("n_documento"));
				fattura.setData(risultato1.getDate("data_fattura"));
				fattura.setTotale_imponibile(risultato1.getDouble("totale_imponibile"));
				fattura.setTotale_imposta(risultato1.getDouble("totale_imposta"));
				fattura.setCosto_totale(risultato1.getDouble("costo_totale"));
				fattura.setVia(risultato1.getString("via"));
				fattura.setDestinatario(risultato1.getString("destinatario"));
				String stato = risultato1.getString("status");
				fattura.setStatus(risultato1.getString("status"));


				Random x = new Random();
				int n = x.nextInt(3);
				if (risultato1.getString("status").equals("Inserito metodo di pagamento")) {
					if (n==0) {
						stato = "Spedito";
						fattura.setStatus(stato);
						aggiornamentostatus("Spedito", fattura.getN_documento());
					}
				}
				else if (risultato1.getString("status").equals("Spedito")) {
					if (n==0) {
						stato = "Consegnato";
						fattura.setStatus(stato);
						aggiornamentostatus("Consegnato", fattura.getN_documento());
					}
				}
				contenitorefattura.add(fattura);
			}
			return contenitorefattura;
		}

		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}	
	}

	public synchronized  boolean aggiornamentostatus (String valore, String chiave) throws SQLException {

		String query="UPDATE fattura SET status=? WHERE n_documento=?";
		PreparedStatement statement=null;
		Connection connection=null;
		int restituzione;
		Date data;

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

		}finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}

	public synchronized ArrayList<FatturaBean> gettuttefatture (String datamin, String datamax) {

		String query = "";
		PreparedStatement pstatement = null;
		Statement statement = null;
		Connection connection = null;
		ResultSet risultato = null;
		ArrayList<FatturaBean> fatture = new ArrayList<FatturaBean>();
		FatturaBean fattura = null ;

		try {
			connection = DriverMaagerConnectionPool.getConnection();	
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (datamin.equals("") && datamax.equals("")) {
			query = "SELECT * FROM fattura";
			try {
				statement=connection.createStatement();
				risultato = statement.executeQuery(query);
				risultato.beforeFirst();
				while (risultato.next()) {
					fattura = new FatturaBean();
					fattura.setCosto_totale(risultato.getDouble("costo_totale"));
					fattura.setData(risultato.getDate("data_fattura"));
					fattura.setDestinatario(risultato.getString("destinatario"));
					fattura.setN_documento(risultato.getString("n_documento"));
					fattura.setTotale_imponibile(risultato.getDouble("totale_imponibile"));
					fattura.setTotale_imposta(risultato.getDouble("totale_imposta"));
					fattura.setVia(risultato.getString("via"));
					fattura.setStatus(risultato.getString("status"));
					fatture.add(fattura);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		if (!(datamin.equals("")) && (!(datamax.equals("")))) {
			query = "SELECT * FROM fattura WHERE data_fattura>='"+datamin+"'AND data_fattura<='"+datamax+"'";
			try {
				pstatement=connection.prepareStatement(query);
				//pstatement.setDate(1, Date.valueOf(datamin));
				//pstatement.setDate(2, Date.valueOf(datamax));
				risultato = pstatement.executeQuery(query);

				risultato.beforeFirst();
				while (risultato.next()) {
					fattura = new FatturaBean();
					fattura.setCosto_totale(risultato.getDouble("costo_totale"));
					fattura.setData(risultato.getDate("data_fattura"));
					fattura.setDestinatario(risultato.getString("destinatario"));
					fattura.setN_documento(risultato.getString("n_documento"));
					fattura.setTotale_imponibile(risultato.getDouble("totale_imponibile"));
					fattura.setTotale_imposta(risultato.getDouble("totale_imposta"));
					fattura.setVia(risultato.getString("via"));
					fatture.add(fattura);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ((datamin.equals("")) && (!(datamax.equals("")))) {
			query = "SELECT * FROM fattura WHERE data_fattura<='"+datamax+"'";
			try {
				pstatement=connection.prepareStatement(query);
				//pstatement.setString(1, datamax);
				risultato = pstatement.executeQuery(query);
				risultato.beforeFirst();
				while (risultato.next()) {
					fattura = new FatturaBean();
					fattura.setCosto_totale(risultato.getDouble("costo_totale"));
					fattura.setData(risultato.getDate("data_fattura"));
					fattura.setDestinatario(risultato.getString("destinatario"));
					fattura.setN_documento(risultato.getString("n_documento"));
					fattura.setTotale_imponibile(risultato.getDouble("totale_imponibile"));
					fattura.setTotale_imposta(risultato.getDouble("totale_imposta"));
					fattura.setVia(risultato.getString("via"));
					fatture.add(fattura);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!(datamin.equals("")) && (datamax.equals(""))) {
			query = "SELECT * FROM fattura WHERE data_fattura>='"+datamin+"'";
			try {
				pstatement=connection.prepareStatement(query);
				//pstatement.setString(1, datamin);
				risultato = pstatement.executeQuery(query);
				risultato.beforeFirst();
				while (risultato.next()) {
					fattura = new FatturaBean();
					fattura.setCosto_totale(risultato.getDouble("costo_totale"));
					fattura.setData(risultato.getDate("data_fattura"));
					fattura.setDestinatario(risultato.getString("destinatario"));
					fattura.setN_documento(risultato.getString("n_documento"));
					fattura.setTotale_imponibile(risultato.getDouble("totale_imponibile"));
					fattura.setTotale_imposta(risultato.getDouble("totale_imposta"));
					fattura.setVia(risultato.getString("via"));
					fatture.add(fattura);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}

		return fatture;
	}

	public synchronized ArrayList<FatturaBean> gettuttefatture (String datamin, String datamax, String email) throws SQLException, IOException {

		String query = "SELECT * FROM effettuazione WHERE email_cliente=?";

		FatturaBean fattura = null;
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet risultato = null, risultato1=null;
		connection=DriverMaagerConnectionPool.getConnection();
		connection.setAutoCommit(true);
		ArrayList<Integer> contenitore = new ArrayList<Integer>();
		ArrayList<FatturaBean> contenitorefattura = new ArrayList<FatturaBean>();
		String query1 = "";

		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, email);
			risultato = statement.executeQuery();


			risultato.beforeFirst();

			while (risultato.next()) {
				contenitore.add(Integer.parseInt(risultato.getString("numero_documento")));
			}

			for (Integer i : contenitore) {
				fattura =  new FatturaBean();
				if (datamin.equals("") && datamax.equals("")) {
					query1="SELECT * FROM fattura WHERE n_documento=?";
					statement=connection.prepareStatement(query1);
					statement.setString(1, ""+i);
					risultato1= statement.executeQuery();
				}
				if (!(datamin.equals("")) && (!(datamax.equals("")))) {
					query1="SELECT * FROM fattura WHERE n_documento=? AND data_fattura>='"+datamin+"' AND data_fattura<='"+datamax+"'";
					statement=connection.prepareStatement(query1);
					statement.setString(1, ""+i);
					risultato1= statement.executeQuery();
				}

				if ((!(datamin.equals("")) && (datamax.equals("")))) {
					query1="SELECT * FROM fattura WHERE n_documento=? AND data_fattura>='"+datamin+"'";
					statement=connection.prepareStatement(query1);
					statement.setString(1, ""+i);
					risultato1= statement.executeQuery();
				}

				if ((datamin.equals("")) && (!(datamax.equals("")))) {
					query1="SELECT * FROM fattura WHERE n_documento=? AND data_fattura<='"+datamax+"'";
					statement=connection.prepareStatement(query1);
					statement.setString(1, ""+i);
					risultato1= statement.executeQuery();
				}

				risultato1.first();
				fattura.setN_documento(risultato1.getString("n_documento"));
				fattura.setData(risultato1.getDate("data_fattura"));
				fattura.setTotale_imponibile(risultato1.getDouble("totale_imponibile"));
				fattura.setTotale_imposta(risultato1.getDouble("totale_imposta"));
				fattura.setCosto_totale(risultato1.getDouble("costo_totale"));
				fattura.setVia(risultato1.getString("via"));
				fattura.setDestinatario(risultato1.getString("destinatario"));
				contenitorefattura.add(fattura);
			}
			return contenitorefattura;
		}

		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}		

	}


}

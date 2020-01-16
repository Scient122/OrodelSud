package JUnit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Bean.FatturaBean;
import Gestione_ordini.*;
import Model.DriverMaagerConnectionPool;

public class FatturaDAO_Stub extends FatturaDAO{
	
	public FatturaDAO_Stub() {

	}

	public synchronized static int highest () throws SQLException, IOException {
		
		System.out.println("highest");
		return 1;

		
	}

	public synchronized boolean inserimento (FatturaBean fattura) throws SQLException, IOException {

		System.out.println("Inserimento");
		return true;
	}

	public synchronized ArrayList<FatturaBean> getfatture (String email) throws SQLException, IOException {
		System.out.println("getFatture");
		return new ArrayList<FatturaBean>();
	}

	public synchronized  boolean aggiornamentostatus (String valore, String chiave) throws SQLException {

		System.out.println("aggiornamentostatus");
		return true;
	}

	public synchronized ArrayList<FatturaBean> gettuttefatture (String datamin, String datamax) {
		
		System.out.println("gettuttefatture");
		return new ArrayList<FatturaBean>();

		
	}

	public synchronized ArrayList<FatturaBean> gettuttefatture (String datamin, String datamax, String email) throws SQLException, IOException {

		System.out.println("gettuttefatture");
		return new ArrayList<FatturaBean>();
	}

}

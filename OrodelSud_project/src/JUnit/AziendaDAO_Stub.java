package JUnit;
import Gestione_account.*;
import java.sql.*;
import java.util.HashMap;

import Bean.AziendaBean;
import Connection.DriverMaagerConnectionPool;
public class AziendaDAO_Stub extends AziendaDAO{
	
	public synchronized  AziendaBean login(String email,String password) throws SQLException {

		System.out.println("login");
		return new AziendaBean_Stub();
	}

	

	public synchronized boolean registration(AziendaBean cliente) throws SQLException {

		System.out.println("registration");
		return true;
	}

	public synchronized  boolean aggiornamento (String colonna, int valore, String chiave) throws SQLException {

		System.out.println("aggiornamento");
		return true;
	}

	
}





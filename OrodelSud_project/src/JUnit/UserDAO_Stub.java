package JUnit;
import java.sql.*;
import java.util.HashMap;

import Bean.ClienteBean;
import Model.DriverMaagerConnectionPool;
import Gestione_account.*;

public class UserDAO_Stub extends UserDAO{
	
	public synchronized  ClienteBean login(String email,String password) throws SQLException {

		System.out.println("login");
		return new ClienteBean_Stub();
	}

	

	public synchronized boolean registration(ClienteBean cliente) throws SQLException {

		System.out.println("registration");
		return true;
	}

	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {

		System.out.println("aggiornamento");
		return true;
	}

	public synchronized  boolean aggiornamento (String colonna, int valore, String chiave) throws SQLException {

		System.out.println("aggiornamento");
		return true;
	}


	public synchronized HashMap<String,String> getcreditcards (ClienteBean cliente) throws SQLException {

		System.out.println("getcreditcards");
		HashMap<String,String> carte= new HashMap<String,String>();
		carte.put("123", "Prova");
		return carte;
		}


		

	

	public synchronized void addcreditcards (String numero, String tipologia, String email) throws SQLException {
		System.out.println("addcreditcards");
		
	}

	public synchronized void deletecreditcards (String numero) throws SQLException {
		System.out.println("deletecreditcards");
	}


}

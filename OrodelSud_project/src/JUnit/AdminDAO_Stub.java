package JUnit;
import java.sql.Connection;
import Gestione_account.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.AdminBean;
import Model.DriverMaagerConnectionPool;
public class AdminDAO_Stub extends AdminDAO{
public synchronized  AdminBean login(String email,String password) throws SQLException {
		
		System.out.println("Login");
		return new AdminBean_Stub();
			
			
		}
		
		
		
	

	public synchronized  boolean aggiornamento (String colonna, String valore, String chiave) throws SQLException {
		
		System.out.println("Aggiornamento");
		return true;
	}	

	
	
}



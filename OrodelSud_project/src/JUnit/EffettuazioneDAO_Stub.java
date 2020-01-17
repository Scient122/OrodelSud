package JUnit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.EffettuazioneBean;
import Connection.DriverMaagerConnectionPool;
import Gestione_ordini.*;

public class EffettuazioneDAO_Stub extends EffettuazioneDAO{
	
public synchronized boolean aggiunta (EffettuazioneBean eff) throws SQLException {
		
		System.out.println("aggiunta");
		return true;
		
		
	}

}

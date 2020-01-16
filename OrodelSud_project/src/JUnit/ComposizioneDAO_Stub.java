package JUnit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ComposizioneBean;
import Gestione_ordini.*;
import Model.DriverMaagerConnectionPool;

public class ComposizioneDAO_Stub extends ComposizioneDAO{
	
public ComposizioneDAO_Stub() {
		
	}
	
	public synchronized boolean aggiunta (ComposizioneBean comp) throws SQLException {
		
		System.out.println("aggiunta");
		return true;
	}
	
public synchronized ArrayList<ComposizioneBean> getprodotti (String n_documento) throws SQLException, IOException {
		
		System.out.println("getprodotti");
		return new ArrayList<ComposizioneBean>();
	}
	
public synchronized ArrayList<ComposizioneBean> getprodottiazienda (String n_documento) throws SQLException, IOException {
	
	System.out.println("getprodottiazienda");
	return new ArrayList<ComposizioneBean>();
}

}

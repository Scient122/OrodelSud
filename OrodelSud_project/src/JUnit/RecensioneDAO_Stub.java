package JUnit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.RecensioneBean;
import Connection.DriverMaagerConnectionPool;
import Gestione_ricette.*;

public class RecensioneDAO_Stub extends RecensioneDAO{
	
	public synchronized ArrayList<RecensioneBean> recensioni (String titolo) throws SQLException, IOException {
		System.out.println("recensioni");
		return new ArrayList<RecensioneBean>();
	}


	public synchronized boolean aggiunta (RecensioneBean recensione) throws SQLException, IOException {
		
		System.out.println("aggiunta");
		return true;
		
	}	

}

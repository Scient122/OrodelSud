package JUnit;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.RicettaBean;
import Gestione_ricette.*;
import Model.DriverMaagerConnectionPool;
import Servlet.Utilities;

public class RicettaDAO_Stub extends RicettaDAO{
	
	public synchronized RicettaBean LastRicetta(String provenienza)throws SQLException,IOException {
		
		System.out.println("LastRicetta");
		return new RicettaBean_Stub();
}
	
public synchronized ArrayList<RicettaBean> categoria(String categoria)throws SQLException,IOException{
		System.out.println("categoria");
		return new ArrayList<RicettaBean>();
		
}


	public synchronized RicettaBean Onericetta (String titolo) throws SQLException,IOException{
		System.out.println("OneRicetta");
		return new RicettaBean_Stub();
}
	
	public synchronized ArrayList<RicettaBean> Provenienza (String provenienza) throws SQLException,IOException{
		System.out.println("Provenienza");
		return new ArrayList<RicettaBean>();
}

}

package JUnit;

import java.io.IOException;
import java.sql.SQLException;

import Bean.RecensioneBean;
import Gestione_ricette.RecensioneDAO;
import junit.framework.TestCase;

public class RecensioneDAO_Test extends TestCase{

	public RecensioneDAO_Test(String name) {
		super(name);
	}
	
	public void testRecensione() {
		
		RecensioneDAO interfaccia = new RecensioneDAO();
		RecensioneBean rec = new RecensioneBean_Stub();
		
		try {
			assertTrue(interfaccia.aggiunta(rec));
			assertNotNull(interfaccia.recensioni("Pizza di scarole"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {

		junit.textui.TestRunner.run(RecensioneDAO_Test.class);

	}	
	
}

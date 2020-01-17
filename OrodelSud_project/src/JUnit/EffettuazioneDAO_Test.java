package JUnit;

import java.sql.SQLException;

import Gestione_ordini.EffettuazioneDAO;
import junit.framework.TestCase;



public class EffettuazioneDAO_Test extends TestCase {
	
	public EffettuazioneDAO_Test (String name) {
		super(name);	
	}
	
	public void testEffettuazione() {
		
		EffettuazioneBean_Stub effett = new EffettuazioneBean_Stub();
		EffettuazioneDAO interfaccia = new EffettuazioneDAO();
		
		try {
			
			assertTrue(interfaccia.aggiunta(effett));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main (String args[]) {

		junit.textui.TestRunner.run(EffettuazioneDAO_Test.class);

	}

}

package JUnit;

import Gestione_ordini.ComposizioneDAO;
import junit.framework.TestCase;

public class ComposizioneDAO_Test extends TestCase {

	public ComposizioneDAO_Test (String name) {
		super(name);
	}
	
	public void testDAO() {
		
		ComposizioneDAO interfaccia = new ComposizioneDAO();
		ComposizioneBean_Stub comp = new ComposizioneBean_Stub();
		
		try {
			
			assertTrue(interfaccia.aggiunta(comp));
			assertNotNull(interfaccia.getprodotti("1"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main (String args[]) {

		junit.textui.TestRunner.run(ComposizioneDAO_Test.class);

	}
	
}

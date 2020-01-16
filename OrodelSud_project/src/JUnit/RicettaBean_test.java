package JUnit;
import Gestione_ricette.*;
import junit.framework.TestCase;
import Bean.*;

public class RicettaBean_test extends TestCase{
	
	public RicettaBean_test(String name) {
		super(name);
	}
	
	public void testBean() {
		RicettaBean ricetta=new RicettaBean();
		ricetta.setCategoria("Primo");
		ricetta.setDescrizione("Buono");
		ricetta.setProvenienza("Campania");
		ricetta.setTitolo("Spaghetti con colatura di alici");
		assertEquals("Primo",ricetta.getCategoria());
		assertEquals("Buono",ricetta.getDescrizione());
		assertEquals("Campania",ricetta.getProvenienza());
		assertEquals("Spaghetti con colatura di alici",ricetta.getTitolo());
	}
	
	public static void main(String args[]) {
		
		junit.textui.TestRunner.run(RicettaBean_test.class);

	}

}

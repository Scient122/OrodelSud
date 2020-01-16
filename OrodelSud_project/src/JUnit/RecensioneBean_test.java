package JUnit;
import Gestione_ricette.*;
import junit.framework.TestCase;
import Bean.*;

public class RecensioneBean_test extends TestCase{
	
	public RecensioneBean_test(String name) {
		super(name);
	}
	
	public void testBean(){
		RecensioneBean recensione= new RecensioneBean();
		recensione.setCommento("Ottima!");
		recensione.setEmail_cliente("marco@gmail.com");
		recensione.setTitolo_ricetta("Pizza");
		assertEquals("Ottima!",recensione.getCommento());
		assertEquals("marco@gmail.com",recensione.getEmail_cliente());
		assertEquals("Pizza",recensione.getTitolo_ricetta());
	}
	
public static void main(String args[]) {
		
		junit.textui.TestRunner.run(RecensioneBean_test.class);

	}


}

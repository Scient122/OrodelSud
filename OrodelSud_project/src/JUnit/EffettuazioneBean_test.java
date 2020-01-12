package JUnit;
import junit.framework.TestCase;
import Bean.*;

public class EffettuazioneBean_test extends TestCase{
	
	public EffettuazioneBean_test(Stirng name) {
		super(name);
	}
	
	public void testBean() {
		EffettuazioneBean effettuazione = new EffettuazioneBean();
		effettuazione.setEmail("marco@gmail.com");
		effettuazione.setNumero("01");
		
		assertEquals("marco@gmail.com",effettuazione.getEmail());
		assertEquals("01",effettuazione.getNumero());
	}
	
public static void main (String args[]) {
		
		junit.textui.TestRunner.run(AdminBean_Test.class);
		
	}

}

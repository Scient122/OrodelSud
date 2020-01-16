package JUnit;
import junit.framework.TestCase;
import Bean.*;

public class EffettuazioneBean_test extends TestCase{
	
	public EffettuazioneBean_test(String name) {
		super(name);
	}
	
	public void testBean() {
		EffettuazioneBean effettuazione = new EffettuazioneBean();
		effettuazione.setEmail("msorrentino5@gmail.com");
		effettuazione.setNumero("01");
		
		assertEquals("msorrentino5@gmail.com",effettuazione.getEmail());
		assertEquals("01",effettuazione.getNumero());
	}
	
public static void main (String args[]) {
		
		junit.textui.TestRunner.run(EffettuazioneBean_test.class);
		
		
	}

}

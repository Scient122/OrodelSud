package JUnit;
import junit.framework.TestCase;

import java.sql.Date;

import Bean.*;

public class ComposizioneBean_test extends TestCase {

	public ComposizioneBean_test(String name) {
		super(name);
	}
	
	public void testBean() {
		ComposizioneBean composizione= new ComposizioneBean();
		composizione.setCodice_prodotto("01");
		
		java.sql.Date data = null;
		data = Date.valueOf("1998-04-04");
		composizione.setData(data);
		composizione.setIva_acquisto(22);
		composizione.setNome_prodotto("Pasta");
		composizione.setNumero_fattura("01");
		composizione.setPrezzo_acquisto(20);
		composizione.setQuantita_acquistate(20);
		
		assertEquals("01",composizione.getCodice_prodotto());
		assertEquals(data,composizione.getData());
		assertEquals(22,composizione.getIva_acquisto());
		assertEquals("Pasta",composizione.getNome_prodotto());
		assertEquals("01", composizione.getNumero_fattura());
		assertEquals(20.0,composizione.getPrezzo_acquisto());
		assertEquals(20,composizione.getQuantita_acquistate());
	}
	
public static void main (String args[]) {
		
		junit.textui.TestRunner.run(AdminBean_Test.class);
		
	}

}

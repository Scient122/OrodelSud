package JUnit;

import Bean.AziendaBean;
import junit.framework.TestCase;

public class AziendaBean_Test extends TestCase{

	public AziendaBean_Test (String name) {
		super(name);	
	}


	public void testBean() {
		AziendaBean azienda = new AziendaBean();
		azienda.setNome("LoSpicchio");
		azienda.setVia("Via Appia");
		azienda.setCap("04026");
		azienda.setCitta("Minturno");
		azienda.setEmail("ls10@gmail.com");
		azienda.setNumero_civico("234");
		azienda.setNumero_di_telefono("3337832364");
		azienda.setPassword("lspicchio10");

		assertEquals("04026", azienda.getCap());
		assertEquals(azienda.getCitta(), "Minturno");
		assertEquals(azienda.getEmail(), "ls10@gmail.com");
		assertEquals(azienda.getNome(), "LoSpicchio");
		assertEquals(azienda.getNumero_civico(), "234");
		assertEquals(azienda.getNumero_di_telefono(), "3337832364");
		assertEquals(azienda.getPassword(), "lspicchio10");
		assertEquals(azienda.getVia(), "Via Appia");
	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(AziendaBean_Test.class);

	}
}

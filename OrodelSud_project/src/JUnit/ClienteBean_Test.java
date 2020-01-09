package JUnit;

import java.sql.Date;
import Bean.ClienteBean;
import junit.framework.TestCase;

public class ClienteBean_Test extends TestCase{

	public ClienteBean_Test (String name) {
	super(name);	
	}
	
	
	public void testBean() {
		ClienteBean cliente = new ClienteBean();
		cliente.setNome("Cliente");
		cliente.setCognome("Bean");
		cliente.setVia("Via Petrarca");
		cliente.setCap("80100");
		cliente.setCitta("Salerno");
		cliente.setEmail("Cbean1@gmail.com");
		cliente.setNumero_civico("10");
		cliente.setNumero_di_telefono("3389852364");
		cliente.setPassword("cbean10");
		
		java.sql.Date data = null;
		data = Date.valueOf("1968-08-04");
		cliente.setData_di_nascita(data);
		
		assertEquals("80100", cliente.getCap());
		assertEquals(cliente.getCitta(), "Salerno");
		assertEquals(cliente.getCognome(), "Bean");
		assertEquals(cliente.getData_di_nascita(), data);
		assertEquals(cliente.getEmail(), "Cbean1@gmail.com");
		assertEquals(cliente.getNome(), "Cliente");
		assertEquals(cliente.getNumero_civico(), "10");
		assertEquals(cliente.getNumero_di_telefono(), "3389852364");
		assertEquals(cliente.getPassword(), "cbean10");
		assertEquals(cliente.getVia(), "Via Petrarca");
	}
	
	public static void main (String args[]) {
		
		junit.textui.TestRunner.run(ClienteBean_Test.class);
		
	}
}

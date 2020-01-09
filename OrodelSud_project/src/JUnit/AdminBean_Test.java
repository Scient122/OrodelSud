package JUnit;

import java.sql.Date;
import Bean.AdminBean;
import junit.framework.TestCase;

public class AdminBean_Test extends TestCase{

	public AdminBean_Test (String name) {
	super(name);	
	}
	
	
	public void testBean() {
		AdminBean admin = new AdminBean();
		admin.setNome("Marco");
		admin.setCognome("Sorrentino");
		admin.setVia("Viale Europa");
		admin.setCap("04028");
		admin.setCitta("Napoli");
		admin.setEmail("msorrentino5@gmail.com");
		admin.setNumero_civico("5");
		admin.setNumero_di_telefono("3337852364");
		admin.setPassword("msorrentino5");
		
		java.sql.Date data = null;
		data = Date.valueOf("1998-04-04");
		admin.setData_di_nascita(data);
		
		assertEquals("04028", admin.getCap());
		assertEquals(admin.getCitta(), "Napoli");
		assertEquals(admin.getCognome(), "Sorrentino");
		assertEquals(admin.getData_di_nascita(), data);
		assertEquals(admin.getEmail(), "msorrentino5@gmail.com");
		assertEquals(admin.getNome(), "Marco");
		assertEquals(admin.getNumero_civico(), "5");
		assertEquals(admin.getNumero_di_telefono(), "3337852364");
		assertEquals(admin.getPassword(), "msorrentino5");
		assertEquals(admin.getVia(), "Viale Europa");
	}
	
	public static void main (String args[]) {
		
		junit.textui.TestRunner.run(AdminBean_Test.class);
		
	}
}

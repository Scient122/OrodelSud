package JUnit;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import Gestione_ordini.FatturaDAO;
import junit.framework.TestCase;

public class FatturaDAO_Test extends TestCase {

	public FatturaDAO_Test(String name) {
		super(name);
	}

	public void testDAO() {

		FatturaDAO interfaccia = new FatturaDAO();
		FatturaBean_Stub fattura = new FatturaBean_Stub();

		try {
			assertTrue(interfaccia.inserimento(fattura));
			assertNotNull(interfaccia.getfatture("cliente@gmail.com"));
			assertNotNull(interfaccia.gettuttefatture("2020-10-08", "2020-10-11"));
		} catch (Exception e) {
			e.printStackTrace();



		}

	}
	
	public static void main (String args[]) {

		junit.textui.TestRunner.run(FatturaDAO_Test.class);

	}
	
}

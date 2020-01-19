package JUnit;

import java.io.IOException;
import java.sql.SQLException;
import Bean.RicettaBean;
import Gestione_ricette.RicettaDAO;
import junit.framework.TestCase;

public class RicettaDAO_Test extends TestCase{

	public RicettaDAO_Test(String name) {
		super(name);
	}

	public void testRicetta() {

		RicettaDAO interfaccia = new RicettaDAO();
		RicettaBean ricetta = new RicettaBean_Stub();

		try {
			assertNotNull(interfaccia.LastRicetta(ricetta.getProvenienza()));
			assertNotNull(interfaccia.categoria(ricetta.getCategoria()));
			assertNotNull(interfaccia.Onericetta("Cannoli siciliani"));
			assertNotNull(interfaccia.Provenienza(ricetta.getProvenienza()));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(RicettaDAO_Test.class);

	}	
}

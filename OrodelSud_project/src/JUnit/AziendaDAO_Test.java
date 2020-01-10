package JUnit;

import junit.framework.TestCase;

import java.sql.SQLException;

import Gestione_account.AziendaDAO;

public class AziendaDAO_Test extends TestCase{

	public AziendaDAO_Test (String name) {
		super(name);
	}

	public void testDAO() {
		AziendaDAO interfaccia = new AziendaDAO();
		AziendaBean_Stub azienda = new AziendaBean_Stub();

		try {
			assertTrue(interfaccia.registration(azienda));
			assertNotNull(interfaccia.login(azienda.getEmail(), azienda.getPassword()));
			assertTrue(interfaccia.aggiornamento("citta", "Pozzuoli", azienda.getEmail()));




		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(AziendaDAO_Test.class);
	}
}
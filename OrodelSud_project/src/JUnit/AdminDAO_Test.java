package JUnit;

import java.util.HashMap;
import Gestione_account.AdminDAO;

import Gestione_account.UserDAO;
import junit.framework.TestCase;

public class AdminDAO_Test extends TestCase{

	public AdminDAO_Test (String name) {
		super(name);
	}

	public void testDAO() {
		AdminDAO interfaccia = new AdminDAO();

		AdminBean_Stub admin = new AdminBean_Stub();
		try {
			assertNotNull(interfaccia.login(admin.getEmail(), admin.getPassword()));
			assertTrue(interfaccia.aggiornamento("via", "Toledo", admin.getEmail()));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(AdminDAO_Test.class);

	}
}
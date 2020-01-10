package JUnit;

import java.util.HashMap;

import Gestione_account.UserDAO;
import junit.framework.TestCase;

public class UserDAO_Test extends TestCase{

	public UserDAO_Test (String name) {
		super(name);
	}

	public void testDAO() {
		UserDAO interfaccia = new UserDAO();
		String numero = "1234567891";
		ClienteBean_Stub cliente = new ClienteBean_Stub();
		try {
			assertTrue(interfaccia.registration(cliente));
			assertNotNull(interfaccia.login(cliente.getEmail(), cliente.getPassword()));
			assertTrue(interfaccia.aggiornamento("nome", "Pasquale", cliente.getEmail()));
			assertTrue(interfaccia.aggiornamento("n_punti", 40, cliente.getEmail()));
			
			interfaccia.addcreditcards(numero, "Mastercard", cliente.getEmail());
			
			HashMap <String,String> carte_credito= interfaccia.getcreditcards(cliente);
			assertTrue(carte_credito.containsKey(numero));
			
			int capienza = carte_credito.size();
			interfaccia.deletecreditcards(numero);
			assertEquals(carte_credito.size(), capienza);

		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(UserDAO_Test.class);

	}

}

package JUnit;

import junit.framework.TestCase;

public class Carrello_test extends TestCase {

	public Carrello_test (String name) {
		super(name);
	}

	public void testCarrello() {

		Carrello_Stub carrello = new Carrello_Stub();
		ProdottoBean_Stub prodotto = new ProdottoBean_Stub();
		int size = carrello.size();

		carrello.add(prodotto,1);
		assertEquals(carrello.size(), 2);

		assertNotNull(carrello.getprodotti());

		Integer size2 = carrello.getquantita(prodotto);
		int size3 = (int) size2;

		assertEquals(size3, 1);

		carrello.setquantita(prodotto,1);
		int size4 = (int) carrello.getquantita(prodotto);
		assertEquals(size4,1); 

		int size5 = (int) carrello.size();
		carrello.delete(prodotto.getNome_prodotto());
		int size6 = (int) carrello.size();

		assertEquals(size5-1, size6);
	}

	public static void main (String args[]) {

		junit.textui.TestRunner.run(Carrello_test.class);
	}
}

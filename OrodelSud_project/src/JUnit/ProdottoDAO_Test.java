package JUnit;

import Gestione_catalogo.ProdottoDAO;
import junit.framework.TestCase;

public class ProdottoDAO_Test extends TestCase {

	public ProdottoDAO_Test(String name) {
		super(name);
	}
	
	public void testDAO() {
		
		ProdottoDAO interfaccia = new ProdottoDAO();
		ProdottoBean_Stub prodotto = new ProdottoBean_Stub();
		
		try {
			interfaccia.aggiunta(prodotto); 
			assertNotNull(interfaccia.unprodotto("Vesuvio"));
			assertNotNull(interfaccia.categoriaprodotto("Vino", 1));
			assertNotNull(interfaccia.prodottofferta(1));
			assertNotNull(interfaccia.searchbar(1, "Vesuvio"));
			assertTrue(interfaccia.aggiornamento("Descrizione", "Confezione da 1kg.", prodotto.getCodice()));
			assertNotNull(interfaccia.unprodottocodice("2"));
			interfaccia.cancellazione(prodotto.getNome_prodotto());
			} catch (Exception e){e.printStackTrace();}
		
	}
	
	public static void main (String args[]) {

		junit.textui.TestRunner.run(ProdottoDAO_Test.class);

	}
	
}

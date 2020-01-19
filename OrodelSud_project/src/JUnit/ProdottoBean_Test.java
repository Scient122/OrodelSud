package JUnit;

import junit.framework.TestCase;
import Bean.*;

public class ProdottoBean_Test extends TestCase {
	public ProdottoBean_Test(String name) {
		super(name);
	}
	
	
	public void testBean() {
		ProdottoBean prodotto= new ProdottoBean();
		prodotto.setAzienda("Lo spicchio");
		prodotto.setCategoria("Pasta");
		prodotto.setCodice("01");
		prodotto.setConservazione("03-04-2020");
		prodotto.setDescrizione("Confezione di pasta");
		prodotto.setIva(22);
		prodotto.setNome_prodotto("Spaghetti");
		prodotto.setOfferta(true);
		prodotto.setPrezzo_base(20);
		prodotto.setPrezzo_totale(30);
		prodotto.setQuantita_disponibili(10);
		
		assertEquals(prodotto.getAzienda(),"Lo spicchio");
		assertEquals(prodotto.getCategoria(),"Pasta");
		assertEquals(prodotto.getCodice(),"01");
		assertEquals(prodotto.getConservazione(),"03-04-2020");
		assertEquals(prodotto.getDescrizione(),"Confezione di pasta");
		assertEquals(prodotto.getIva(),22);
		assertEquals(prodotto.getNome_prodotto(),"Spaghetti");
		assertEquals(prodotto.isOfferta(),true);
		assertEquals(prodotto.getPrezzo_base(),20.0);
		assertEquals(prodotto.getPrezzo_totale(),30.0);
		assertEquals(prodotto.getQuantita_disponibili(),10);
		
	}
	
	public static void main(String [] args) {
		junit.textui.TestRunner.run(ProdottoBean_Test.class);
		
		

	}
}

package JUnit;
import junit.framework.TestCase;

import java.sql.Date;

import Bean.*;

public class FatturaBean_test extends TestCase {
	
	public FatturaBean_test(String name) {
		super(name);
	}
	
	public void testBean() {
		FatturaBean fattura= new FatturaBean();
		fattura.setCosto_totale(20);
		
		java.sql.Date data = null;
		data = Date.valueOf("1998-04-04");
		fattura.setData(data);
		fattura.setDestinatario("Marco");
		fattura.setN_documento("01");
		fattura.setStatus("Spedito");
		fattura.setTotale_imponibile(20);
		fattura.setTotale_imposta(20);
		fattura.setVia("Viale Europa");
		
		assertEquals(20.0,fattura.getCosto_totale());
		assertEquals(data,fattura.getData());
		assertEquals("Marco",fattura.getDestinatario());
		assertEquals("01",fattura.getN_documento());
		assertEquals("Spedito",fattura.getStatus());
		assertEquals(20.0,fattura.getTotale_imponibile());
		assertEquals(20.0,fattura.getTotale_imposta());
		assertEquals("Viale Europa",fattura.getVia());
		
	}
	
	public static void main(String[] args) {
		
		junit.textui.TestRunner.run(FatturaBean_test.class);

	}

}

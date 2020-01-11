package JUnit;
import java.util.*;
import Bean.ProdottoBean;
import Gestione_catalogo.Carrello;
import junit.framework.TestCase;

public class Carrello_Stub extends Carrello {

	public Carrello_Stub() {
		ProdottoBean_Stub prodotto = new ProdottoBean_Stub();
		this.carrello.put(prodotto, 2);
	}

	public void add (ProdottoBean x, int quantita) {
		carrello.put(x, quantita);
	}

	public void delete (String titolo) {
		Set <ProdottoBean> prodotti = this.getprodotti();

		for (ProdottoBean p: prodotti) {
			if (p.getNome_prodotto().equals(titolo)) {
				carrello.remove(p);
				break;
			}
		}
	}

	public int size () {
		return carrello.size();
	}

	public Set<ProdottoBean> getprodotti () {
		return carrello.keySet();
	}

	public Integer getquantita (ProdottoBean p) {
		Integer a = carrello.get(p);
		return a;
	}

	public void setquantita (ProdottoBean p, int x) {
		carrello.put(p, x);
	}

	private HashMap <ProdottoBean, Integer> carrello = new HashMap<>();
}

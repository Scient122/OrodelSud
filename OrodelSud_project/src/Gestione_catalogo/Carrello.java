package Gestione_catalogo;
import java.util.*;

import Bean.ProdottoBean;
import Connection.*;

public class Carrello {

	public Carrello() {
		
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

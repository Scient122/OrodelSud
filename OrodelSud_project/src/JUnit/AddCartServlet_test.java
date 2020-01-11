package JUnit;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ProdottoBean;
import Gestione_catalogo.Carrello;
import Gestione_catalogo.ProdottoDAO;


@WebServlet("/AddCartServlet_test")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCartServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Carrello carrello=(Carrello) session.getAttribute("carrello");
		String titolo = request.getParameter("titolo");
		ProdottoDAO interfaccia = new ProdottoDAO_stub();
		ProdottoBean prodotto = null;
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		Set <ProdottoBean> prodotti = carrello.getprodotti();
		boolean presente = false;
		
		for(ProdottoBean p : prodotti) {
			if (p.getNome_prodotto().equals(titolo)) {
				presente=true;
				prodotto=p;
				break; 
				}
		}
		
		if (presente==false) {
		
		try {
			prodotto=interfaccia.unprodotto(titolo);
		}
		catch (Exception e) {
			response.sendError(500, "Errore");
		}		
		carrello.add(prodotto, quantita);
		
		session.setAttribute("carrello", carrello);
		}
		else {
			if (carrello.getquantita(prodotto)+quantita<=prodotto.getQuantita_disponibili()) {
				carrello.setquantita(prodotto, carrello.getquantita(prodotto)+quantita);
			}
			else {
				carrello.setquantita(prodotto, prodotto.getQuantita_disponibili());
			}
			session.setAttribute("carrello", carrello);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

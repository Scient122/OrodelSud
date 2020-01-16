package JUnit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ClienteBean;
import Bean.ComposizioneBean;
import Bean.EffettuazioneBean;
import Bean.FatturaBean;
import Bean.ProdottoBean;
import Gestione_account.UserDAO;
import Gestione_catalogo.Carrello;
import Gestione_catalogo.ProdottoDAO;
import Gestione_ordini.ComposizioneDAO;
import Gestione_ordini.EffettuazioneDAO;
import Gestione_ordini.FatturaDAO;
import Servlet.HttpSession;


@WebServlet("/ConfermaServlet_test")
public class ConfermaServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ConfermaServlet_test() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		
		FatturaBean fatturabean = new FatturaBean_Stub();
		ComposizioneBean comp = new ComposizioneBean_Stub();
		EffettuazioneBean effettuazione = new EffettuazioneBean_Stub();
		
		ProdottoDAO interfacciaprodotto = new ProdottoDAO_Stub();
		FatturaDAO interfacciafattura = new FatturaDAO_Stub();
		EffettuazioneDAO interfacciaeff = new EffettuazioneDAO_Stub();
		ComposizioneDAO interfacciacomp = new ComposizioneDAO_Stub();
		UserDAO interfacciauser = new UserDAO_Stub();
		
		Set<ProdottoBean> prodotti = carrello.getprodotti();

		double accumulatore = 0;
		double prezzototale = 0;
		int punti;
		try {
		for(ProdottoBean p:prodotti) {
			prezzototale= p.getPrezzo_totale()*carrello.getquantita(p);
			accumulatore=accumulatore+prezzototale;
			interfacciaprodotto.aggiornamento("quantita_disponibili", p.getQuantita_disponibili()-carrello.getquantita(p), p.getCodice());
	
		}
		}
		catch (Exception e) {
			response.sendError(500, "Errore"+e);
		}
		
		
		punti=(int) (accumulatore/10);
		try {
		interfacciauser.aggiornamento("n_punti", cliente.getPunti()+punti, cliente.getEmail());
		cliente.setPunti(cliente.getPunti()+punti);

		}
		catch(Exception e) {
			response.sendError(500, "Errore"+e);
		}
		
		int highest = 0;
		
		try {
			 highest =  (int) FatturaDAO.highest()+1;
			} 
		catch (SQLException e) {
			response.sendError(500, "Errore"+e);
			}
		
		fatturabean.setN_documento(""+highest);
		fatturabean.setDestinatario(cliente.getNome()+" "+ cliente.getCognome());
		fatturabean.setVia(cliente.getCitta()+ " "+cliente.getCap()+" "+cliente.getVia()+" "+ cliente.getNumero_civico());
		fatturabean.setData(new java.sql.Date(System.currentTimeMillis()));
		fatturabean.setTotale_imponibile((100*accumulatore)/122);
		fatturabean.setTotale_imposta(accumulatore-fatturabean.getTotale_imponibile());
		fatturabean.setCosto_totale(accumulatore);
		fatturabean.setStatus("Inserito metodo di pagamento");
		try {
			interfacciafattura.inserimento(fatturabean);

			} 
		catch (SQLException e) {
			response.sendError(500, "Errore"+e);
		}
		
		int scalare = (int) accumulatore;
		
		if (request.getParameter("tipologiacartaconferma").equals("Pagapunti")) {
			try {
				interfacciauser.aggiornamento("n_punti", cliente.getPunti()-scalare, cliente.getEmail());

			} catch (SQLException e) {
				e.printStackTrace();
			}
			cliente.setPunti(cliente.getPunti()-scalare);
		}
		
		effettuazione.setEmail(cliente.getEmail());
		effettuazione.setNumero(fatturabean.getN_documento());
		try {
			interfacciaeff.aggiunta(effettuazione);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(ProdottoBean p: prodotti) {
			
			comp.setCodice_prodotto(p.getCodice());
			comp.setData(new java.sql.Date(System.currentTimeMillis()));
			comp.setIva_acquisto(p.getIva());
			comp.setNome_prodotto(p.getNome_prodotto());
			comp.setNumero_fattura(fatturabean.getN_documento());
			comp.setPrezzo_acquisto(p.getPrezzo_totale());
			comp.setQuantita_acquistate(carrello.getquantita(p));
			
			try {
				interfacciacomp.aggiunta(comp);
				System.out.println("composizione");

				}
			catch (SQLException e) {
				e.printStackTrace();
				}
		}
		
		session.removeAttribute("carrello");
		response.sendRedirect("Carrello.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

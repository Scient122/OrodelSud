package JUnit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Bean.ProdottoBean;
import Gestione_catalogo.ProdottoDAO;

public class ModificaProdottoServlet_Test extends HttpServlet {

	public ModificaProdottoServlet_Test() {
		super();
	}

	public class ModificaProdottoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			ProdottoDAO interfaccia = new ProdottoDAO_Stub();
			HttpSession sessione = request.getSession();
			ProdottoBean prodotto = (ProdottoBean) sessione.getAttribute("Prodotto");

			String nome_prodotto;
			String descrizione = request.getParameter("descrizione");
			String prezzo_base = request.getParameter("prezzobase");
			String quantita_disponibili = request.getParameter("quantitadisponibili");
			String conservazione = request.getParameter("conservazione");
			String categoria = request.getParameter("categoria");
			String IVA = request.getParameter("cambioiva");

			try {
				nome_prodotto= request.getParameter("nome");
				if (!(nome_prodotto.equals(""))) {
					interfaccia.aggiornamento("nome_prodotto", nome_prodotto, prodotto.getCodice());
					prodotto.setNome_prodotto(nome_prodotto);
				}

				if (!(IVA.equals(""))) {
					interfaccia.changeiva(Integer.parseInt(IVA));
				}

				if (!(descrizione.equals(""))) {
					interfaccia.aggiornamento("descrizione", descrizione, prodotto.getCodice());
				}

				if (!(prezzo_base.equals(""))) {
					interfaccia.aggiornamento("prezzo_base", Double.parseDouble(prezzo_base), prodotto.getCodice());
					interfaccia.aggiornamento("prezzo_totale", ((prodotto.getPrezzo_base()*prodotto.getIva())/100)+prodotto.getPrezzo_base(), prodotto.getCodice());
				}

				if(request.getParameter("offerta")!=null) {
					if (prodotto.isOfferta())
						interfaccia.aggiornamento("offerta", 0, prodotto.getCodice());
					else
						interfaccia.aggiornamento("offerta", 1, prodotto.getCodice());
				}

				if (!(quantita_disponibili.equals(""))) {
					interfaccia.aggiornamento("quantita_disponibili", Integer.parseInt(quantita_disponibili), prodotto.getCodice());
				}

				if (!(conservazione.equals(""))) {
					interfaccia.aggiornamento("conservazione", conservazione, prodotto.getCodice());
				}			

				if (!(categoria.equals(""))) {
					interfaccia.aggiornamento("categoria", categoria, prodotto.getCodice());
				}

				if (request.getPart("immagine")!=null) {
					Part immagine = request.getPart("immagine");
					ByteArrayOutputStream flusso = new ByteArrayOutputStream();
					byte [] buffer=new byte[52428800]; //50mb
					int bytesRead=-1;
					bytesRead=immagine.getInputStream().read(buffer);
					flusso.write(buffer,0,bytesRead);
					byte[] imageBytes=flusso.toByteArray();
					flusso.close();
					immagine.getInputStream().close();
					interfaccia.aggiornamento(imageBytes, prodotto.getCodice());
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}	

			response.sendRedirect("OneProductServlet?admin=yes&titolo="+prodotto.getNome_prodotto());
			sessione.removeAttribute("Prodotto");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

}

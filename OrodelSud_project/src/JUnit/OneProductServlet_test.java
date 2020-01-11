package Junit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ProdottoBean;
import Gestione_catalogo.ProdottoDAO;


@WebServlet("/OneProductServlet_test")
public class OneProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OneProductServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice = request.getParameter("titolo");
		
		
		String destinazione = "";
		if (request.getParameter("admin")!=null || request.getParameter("aziendaBean")!=null) {
			destinazione="ModificaProdotto.jsp";
		}
			else {
				destinazione="Prodotto.jsp";
		}
		
		
		ProdottoBean prodotto = null;
		ProdottoDAO interfaccia = new ProdottoDAO_stub();
		try {
		prodotto=interfaccia.unprodotto(codice);
		}
		catch (Exception e) {
			response.sendError(500, "Errore nell'operazione");
		}
		
		if (prodotto!=null) {
			request.setAttribute("Prodotto", prodotto);
			RequestDispatcher view=request.getRequestDispatcher(destinazione);
			view.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

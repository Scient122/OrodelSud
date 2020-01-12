package JUnit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gestione_catalogo.ProdottoDAO;

public class CancellazioneProdottoServlet_Test extends HttpServlet{

	public CancellazioneProdottoServlet_Test() {
        super();
    }
	
	public class CancellazioneProdottoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ProdottoDAO interfaccia = new ProdottoDAO_Stub();
			String titolo = request.getParameter("titolo");
			try {
			interfaccia.cancellazione(titolo);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("ProdottoServlet?admin=yes");
			
			
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}
	
	
}

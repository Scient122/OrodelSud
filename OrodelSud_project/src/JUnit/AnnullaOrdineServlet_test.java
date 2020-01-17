package JUnit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gestione_ordini.FatturaDAO;


@WebServlet("/AnnullaOrdineServlet_test")
public class AnnullaOrdineServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public AnnullaOrdineServlet_test() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String NUMERO = request.getParameter("numero");
		FatturaDAO interfaccia = new FatturaDAO_Stub();
		
		try {
			interfaccia.aggiornamentostatus("Rifiutato", NUMERO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Areapersonale.jsp");
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gestione_catalogo.ProdottoDAO;

@WebServlet("/CancellazioneProdottoServlet")
public class CancellazioneProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancellazioneProdottoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdottoDAO interfaccia = new ProdottoDAO();
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

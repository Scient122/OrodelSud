import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClienteBean;
import Bean.RecensioneBean;
import Bean.RicettaBean;
import Gestione_ricette.RecensioneDAO;


@WebServlet("/RecensioneServlet_test")
public class RecensioneServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RecensioneServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");
		String ricetta = request.getParameter("titolo");
		String recensione = request.getParameter("textarea");
		
		RecensioneBean recensionebean = new RecensioneBean_stub();
		RecensioneDAO interfaccia = new RecensioneDAO_stub();
		recensionebean.setCommento(recensione);
		recensionebean.setEmail_cliente(cliente.getEmail());
		recensionebean.setTitolo_ricetta(ricetta);
		
		
		try {
			boolean x = interfaccia.aggiunta(recensionebean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("FinalRicettaServlet?Ricetta="+ricetta);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package JUnit;

import java.io.IOException;
import Bean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Gestione_account.*;


@WebServlet("/RegistrationServlet_test")
public class RegistrationServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public RegistrationServlet_test() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO interfaccia = new UserDAO_Stub();
		ClienteBean cliente = new ClienteBean_Stub();
		AziendaBean azienda = new AziendaBean_Stub();
		AziendaDAO interfaccia2 = new AziendaDAO_Stub();

		if (request.getParameter("datanascita")!=null) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String citta = request.getParameter("citta");
			String via = request.getParameter("via");
			String cap = request.getParameter("cap");
			String ncivico = request.getParameter("ncivico");
			String ntelefono = request.getParameter("ntelefono");


			Date nascita= null;
			nascita=Date.valueOf(request.getParameter("datanascita"));


			cliente.setEmail(email);
			cliente.setPassword(password);
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setVia(via);
			cliente.setCap(cap);
			cliente.setCitta(citta);
			cliente.setNumero_civico(ncivico);
			cliente.setData_di_nascita(nascita);
			cliente.setNumero_di_telefono(ntelefono);


			boolean ris;
			try {
				ris=interfaccia.registration(cliente);
			}
			catch (SQLException e){
				e.printStackTrace();
				return;
			}

			RequestDispatcher dispatcher;

			if (ris) {
				dispatcher=request.getRequestDispatcher("Regsucc.jsp");
				dispatcher.forward(request, response);
			}
			else {
				dispatcher=request.getRequestDispatcher("Registration.jsp");
				dispatcher.forward(request, response);
			}

		}

		else {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nome = request.getParameter("nome");
			String citta = request.getParameter("citta");
			String via = request.getParameter("via");
			String cap = request.getParameter("cap");
			String ncivico = request.getParameter("ncivico");
			String ntelefono = request.getParameter("ntelefono");

			azienda.setEmail(email);
			azienda.setPassword(password);
			azienda.setNome(nome);
			azienda.setVia(via);
			azienda.setCap(cap);
			azienda.setCitta(citta);
			azienda.setNumero_civico(ncivico);
			azienda.setNumero_di_telefono(ntelefono);

			boolean ris;
			try {
				ris=interfaccia2.registration(azienda);

			}
			catch (SQLException e){
				e.printStackTrace();
				return;
			}

			RequestDispatcher dispatcher;

			if (ris) {

				dispatcher=request.getRequestDispatcher("Regsucc.jsp");
				dispatcher.forward(request, response);
			}
			else {	
				dispatcher=request.getRequestDispatcher("Registration.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package JUnit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AdminBean;
import Bean.AziendaBean;
import Bean.ClienteBean;
import Gestione_account.AdminDAO;
import Gestione_account.AziendaDAO;
import Gestione_account.UserDAO;


@WebServlet("/LoginServlet_test")
public class LoginServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServlet_test() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		UserDAO interfaccia=new UserDAO_Stub();
		AdminDAO interfaccia1 = new AdminDAO_Stub();
		AziendaDAO interfaccia2 = new AziendaDAO_Stub();
		ClienteBean_Stub utente=null;
		AdminBean_Stub admin = null;
		AziendaBean_Stub azienda = null;
		HashMap <String, String> carte = new HashMap<String,String>();
		Set <String> numeri_carte = null;

		try {
			admin=(AdminBean_Stub) interfaccia1.login(email, password);
			azienda=(AziendaBean_Stub) interfaccia2.login(email, password);

			if (admin==null && azienda==null) {
				utente=(ClienteBean_Stub) interfaccia.login(email,password);
				if (utente!=null) {
					carte = interfaccia.getcreditcards(utente);
					numeri_carte=carte.keySet();

					for (String s: numeri_carte) {
						utente.setCarte_credito(s, carte.get(s));	
					}
				}
			}
		}
		catch(SQLException e) {
			response.sendError(500,"Login error");
			System.out.println(e);
			return;
		}

		RequestDispatcher dispatcher;

		if (admin==null) {	
			if (utente==null) {
				if (azienda==null) {
					dispatcher=request.getRequestDispatcher("LoginFailed.jsp");
					dispatcher.forward(request,response);
				}
				else {
					HttpSession session=request.getSession();
					session.setAttribute("aziendaBean",azienda);
					dispatcher=request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}

			else {
				HttpSession session=request.getSession();
				session.setAttribute("userBean",utente);
				dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			}
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("adminBean",admin);
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

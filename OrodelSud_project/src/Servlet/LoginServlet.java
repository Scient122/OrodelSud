package Servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Bean.AdminBean;
import Bean.AziendaBean;
import Bean.ClienteBean;
import Gestione_account.AdminDAO;
import Gestione_account.AziendaDAO;
import Gestione_account.UserDAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Set;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

		String email=request.getParameter("email");
		String password=request.getParameter("password");

		UserDAO interfaccia=new UserDAO();
		AdminDAO interfaccia1 = new AdminDAO();
		AziendaDAO interfaccia2 = new AziendaDAO();
		ClienteBean utente=null;
		AdminBean admin = null;
		AziendaBean azienda = null;
		HashMap <String, String> carte = new HashMap<String,String>();
		Set <String> numeri_carte = null;

		try {
			admin=interfaccia1.login(email, password);
			azienda=interfaccia2.login(email, password);

			if (admin==null && azienda==null) {
				utente=interfaccia.login(email,password);
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

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doGet(request,response);
	}

}
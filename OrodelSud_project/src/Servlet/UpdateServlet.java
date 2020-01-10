package Servlet;

import java.io.IOException;

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

import java.sql.*;
import java.sql.Date;
import java.util.*;
import Model.*;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDAO interfaccia = new AdminDAO();
		UserDAO interfaccia1 = new UserDAO();
		AziendaDAO interfaccia2 = new AziendaDAO();
		HttpSession session = request.getSession();
		AdminBean admin = (AdminBean) session.getAttribute("adminBean");
		ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");
		AziendaBean azienda = (AziendaBean) session.getAttribute("aziendaBean");
		
		if (admin!=null) { 
		
		String emailprecedente = admin.getEmail();		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String citta=request.getParameter("citta");
		String via=request.getParameter("via");
		String cap=request.getParameter("cap");
		String n_civico=request.getParameter("numero_civico");
		String n_telefono=request.getParameter("numero_di_telefono");
		String data=request.getParameter("data_di_nascita");
		try {
		
			if (!(password.equals(""))) {
				interfaccia.aggiornamento("pass", password, emailprecedente);
				admin.setPassword(password);
			}
			if (!(nome.equals(""))) {
				interfaccia.aggiornamento("nome", nome, emailprecedente);
				admin.setNome(nome);
			}
			if (!(cognome.equals(""))) {
				interfaccia.aggiornamento("cognome", cognome, emailprecedente);
				admin.setCognome(cognome);
			}
			if (!(citta.equals(""))) {
				interfaccia.aggiornamento("citta", citta, emailprecedente);
				admin.setCitta(citta);
			}
			if (!(via.equals(""))) {
				interfaccia.aggiornamento("via", via, emailprecedente);
				admin.setVia(via);
			}
			if (!(cap.equals(""))) {
				interfaccia.aggiornamento("cap", cap, emailprecedente);
				admin.setCap(cap);
			}
			if (!(n_civico.equals(""))) {
				interfaccia.aggiornamento("n_civico", n_civico, emailprecedente);
				admin.setNumero_civico(n_civico);
			}
			if (!(n_telefono.equals(""))) {
				interfaccia.aggiornamento("n_telefono", n_telefono, emailprecedente);
				admin.setNumero_di_telefono(n_telefono);
			}
			if (!(data.equals(""))) {
				interfaccia.aggiornamento("data_nascita", data, emailprecedente);
				admin.setData_di_nascita(Date.valueOf(data));
			}
			if (!(email.equals(""))) {
				interfaccia.aggiornamento("email", email, emailprecedente);
				admin.setEmail(email);
			}
			session.setAttribute("adminBean", admin);
		}
		catch (Exception e) {
			response.sendError(500, "Errore update"+e);
		}
		}
		else if (cliente!=null) {
			String emailcliente = cliente.getEmail();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String citta=request.getParameter("citta");
			String via=request.getParameter("via");
			String cap=request.getParameter("cap");
			String n_civico=request.getParameter("numero_civico");
			String n_telefono=request.getParameter("numero_di_telefono");
			String data=request.getParameter("data_di_nascita");
			
			try {
				if (!(password.equals(""))) {
					interfaccia1.aggiornamento("pass", password, emailcliente);
					cliente.setPassword(password);
				}
				if (!(nome.equals(""))) {
					interfaccia1.aggiornamento("nome", nome, emailcliente);
					cliente.setNome(nome);
				}
				if (!(cognome.equals(""))) {
					interfaccia1.aggiornamento("cognome", cognome, emailcliente);
					cliente.setCognome(cognome);
				}
				if (!(citta.equals(""))) {
					interfaccia1.aggiornamento("citta", citta, emailcliente);
					cliente.setCitta(citta);
				}
				if (!(via.equals(""))) {
					interfaccia1.aggiornamento("via", via, emailcliente);
					cliente.setVia(via);
				}
				if (!(cap.equals(""))) {
					interfaccia1.aggiornamento("cap", cap, emailcliente);
					cliente.setCap(cap);
				}
				if (!(n_civico.equals(""))) {
					interfaccia1.aggiornamento("n_civico", n_civico, emailcliente);
					cliente.setNumero_civico(n_civico);
				}
				if (!(n_telefono.equals(""))) {
					interfaccia1.aggiornamento("n_telefono", n_telefono, emailcliente);
					cliente.setNumero_di_telefono(n_telefono);
				}
				if (!(data.equals(""))) {
					interfaccia1.aggiornamento("data_nascita", data, emailcliente);
					cliente.setData_di_nascita(Date.valueOf(data));
				}
				if (!(email.equals(""))) {
					interfaccia1.aggiornamento("email", email, emailcliente);
					cliente.setEmail(email);
				}
				session.setAttribute("userBean", cliente);
			}
				
			catch (Exception e) {
				response.sendError(500, "Errore update");
			}
		}
	else {
		String emailprecedente = azienda.getEmail();	
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nome=request.getParameter("nome");
		String citta=request.getParameter("citta");
		String via=request.getParameter("via");
		String cap=request.getParameter("cap");
		String n_civico=request.getParameter("numero_civico");
		String n_telefono=request.getParameter("numero_di_telefono");
		
		try {
			
			if (!(password.equals(""))) {
				interfaccia2.aggiornamento("pass", password, emailprecedente);
				azienda.setPassword(password);
			}
			if (!(nome.equals(""))) {
				interfaccia2.aggiornamento("nome", nome, emailprecedente);
				azienda.setNome(nome);
			}
			
			if (!(citta.equals(""))) {
				interfaccia2.aggiornamento("citta", citta, emailprecedente);
				azienda.setCitta(citta);
			}
			if (!(via.equals(""))) {
				interfaccia2.aggiornamento("via", via, emailprecedente);
				azienda.setVia(via);
			}
			if (!(cap.equals(""))) {
				interfaccia2.aggiornamento("cap", cap, emailprecedente);
				azienda.setCap(cap);
			}
			if (!(n_civico.equals(""))) {
				interfaccia2.aggiornamento("n_civico", n_civico, emailprecedente);
				azienda.setNumero_civico(n_civico);
			}
			if (!(n_telefono.equals(""))) {
				interfaccia2.aggiornamento("numero_telefono", n_telefono, emailprecedente);
				azienda.setNumero_di_telefono(n_telefono);
			}
			
			if (!(email.equals(""))) {
				interfaccia2.aggiornamento("email", email, emailprecedente);
				azienda.setEmail(email);
			}
			session.setAttribute("aziendaBean", azienda);
		}
		catch (Exception e) {
			response.sendError(500, "Errore update"+e);
		}
		
	}
		response.sendRedirect("Areapersonale.jsp");
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

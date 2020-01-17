package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RecensioneBean;
import Bean.RicettaBean;
import Connection.*;
import Gestione_ricette.RecensioneDAO;
import Gestione_ricette.RicettaDAO;

@WebServlet("/FinalRicettaServlet")
public class FinalRicettaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FinalRicettaServlet() {
        super();
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ricetta = request.getParameter("Ricetta");
		RicettaDAO interfaccia = new RicettaDAO();
		RicettaBean risultato=null;
		RecensioneDAO interfaccia2 = new RecensioneDAO();
		ArrayList<RecensioneBean> recensioni = new ArrayList<RecensioneBean>();
		
		try {
		risultato=interfaccia.Onericetta(ricetta); 
		}
		catch (Exception e) {
		response.sendError(500, "Exception interfaccia");	
		}
		
		try {
			recensioni = interfaccia2.recensioni(ricetta);
		} catch (Exception e) {
			response.sendError(500, "Excepetion interfaccia2");
		}
		
		if (risultato!=null) {
			request.setAttribute("Ricetta", risultato);
			request.setAttribute("Recensioni", recensioni);
			RequestDispatcher view=request.getRequestDispatcher("Ricetta.jsp");
			view.forward(request,response);
		}
		else {
			response.sendRedirect("RicetteServlet");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

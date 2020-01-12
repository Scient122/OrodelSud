package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Bean.RicettaBean;
import Gestione_ricette.RecensioneDAO;
import Gestione_ricette.RicettaDAO;

import java.sql.*;

@WebServlet("/RicetteServlet")

public class RicetteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

		RicettaBean ricette[]=new RicettaBean[7];
		RicettaDAO interfaccia=new RicettaDAO();
		

		try {
			ricette[0]=interfaccia.LastRicetta("Abruzzo");
			ricette[1]=interfaccia.LastRicetta("Molise");
			ricette[2]=interfaccia.LastRicetta("Campania");
			ricette[3]=interfaccia.LastRicetta("Puglia");
			ricette[4]=interfaccia.LastRicetta("Basilicata");
			ricette[5]=interfaccia.LastRicetta("Calabria");
			ricette[6]=interfaccia.LastRicetta("Sicilia");
		}

		catch(SQLException e) {
			response.sendError(500,"Errore nell'operazione");
		}

		request.setAttribute("Ricette",ricette);
		RequestDispatcher view=request.getRequestDispatcher("Ricette.jsp");
		view.forward(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}

}

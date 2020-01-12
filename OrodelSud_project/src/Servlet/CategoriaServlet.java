package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Bean.RicettaBean;
import Gestione_ricette.RicettaDAO;

import java.util.*;
import java.sql.*;

@WebServlet("/CategoriaServlet")

public class CategoriaServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		String categoria=request.getParameter("Categoria");
		ArrayList<RicettaBean> ricette=null;
		RicettaDAO interfaccia=new RicettaDAO();
		try {
		ricette=interfaccia.categoria(categoria);
		}
		
		catch(Exception e) {
			response.sendError(500,"Errore nell'operazione");
		}
		
		request.setAttribute("ricette",ricette);
		RequestDispatcher view=request.getRequestDispatcher("Categoriaricetta.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		doGet(request,response);
		}

}

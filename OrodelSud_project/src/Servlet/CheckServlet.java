package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Gestione_account.AdminDAO;
import Gestione_account.AziendaDAO;
import Gestione_account.UserDAO;

import java.sql.*;

import Model.DriverMaagerConnectionPool; 

@WebServlet("/CheckServlet")

public class CheckServlet extends HttpServlet{

private static final long serialVersionUID = 1L;

private synchronized boolean check (String email) throws SQLException {
		
	String email1 = email;
	
	Connection connection=DriverMaagerConnectionPool.getConnection();
	connection.setAutoCommit(true);
	String query="SELECT * FROM azienda WHERE email=?";
	String query1="SELECT * FROM amministratore WHERE email=?";
	String query2="SELECT * FROM cliente WHERE email=?";
	PreparedStatement statement=null;
	statement=connection.prepareStatement(query1);
	try {
		statement.setString(1,email1);
		ResultSet risultato=statement.executeQuery();

		if(risultato.first())
			return false;
		else {
			statement=connection.prepareStatement(query);
			statement.setString(1, email1);
			risultato=statement.executeQuery();
		}

		if (risultato.first())
			return false;
		else 
		{ 			
			statement=connection.prepareStatement(query2);
			statement.setString(1, email1);
			risultato=statement.executeQuery();
		}

		if(risultato.first()) 
			return false;
		else
			return true;
	}
	finally {
		DriverMaagerConnectionPool.releaseConnection(connection);
	}

	
	}

public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	BufferedReader appoggio1=request.getReader();
	String appoggio=appoggio1.readLine();
	boolean ris=false;
	PrintWriter out=response.getWriter();
	try {
		ris=check(appoggio);
	}
	catch(SQLException e) {
		
	}
	
	if(ris)
		out.println("Ok");
	else
		out.println("No");
}
    
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doGet(request,response);
}
}

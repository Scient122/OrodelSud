package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ComposizioneBean;
import Bean.FatturaBean;
import Gestione_ordini.ComposizioneDAO;
import Gestione_ordini.FatturaDAO;


@WebServlet("/RicercaFatturaServlet")
public class RicercaFatturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RicercaFatturaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<FatturaBean, ArrayList<ComposizioneBean>> fattura = new HashMap<FatturaBean, ArrayList<ComposizioneBean>>();
		String email = request.getParameter("email");
		String datamin = request.getParameter("datamin");
		String datamax = request.getParameter("datamax");
		FatturaDAO interfaccia = new FatturaDAO();
		ArrayList<FatturaBean> fatture = new ArrayList<FatturaBean>();
		ComposizioneDAO interfacciacomp = new ComposizioneDAO();

		if (email.equals("")) {
			try {
				fatture = interfaccia.gettuttefatture(datamin, datamax);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				fatture = interfaccia.gettuttefatture(datamin, datamax, email);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		for(FatturaBean f : fatture) {
			try {
				fattura.put(f, interfacciacomp.getprodotti(f.getN_documento()));

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("fattura", fattura);

		RequestDispatcher view=request.getRequestDispatcher("Ordinipercriterio.jsp");
		view.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

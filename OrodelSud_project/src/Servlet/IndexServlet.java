package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ProdottoBean;
import Bean.RicettaBean;
import Gestione_catalogo.ProdottoDAO;
import Gestione_ricette.RicettaDAO;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IndexServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProdottoBean prodotto = new ProdottoBean();
		ProdottoDAO interfacciaprodotto = new ProdottoDAO();
		RicettaBean ricetta = new RicettaBean();
		RicettaDAO interfacciaricetta = new RicettaDAO();
		ArrayList<Object> oggetti = new ArrayList<Object>();
		ArrayList<ProdottoBean> array1 = new ArrayList<ProdottoBean>();
		ArrayList<ProdottoBean> array2 = new ArrayList<ProdottoBean>();
		ArrayList<ProdottoBean> array3 = new ArrayList<ProdottoBean>();

		int highest = 0;
		int i = 0, j= 0;
		try {
			highest= interfacciaprodotto.highest();
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		Random x = new Random ();
		int codice = x.nextInt(highest+1);
		
		while (i<3) {
			try {
				prodotto = interfacciaprodotto.unprodottocodice(""+x.nextInt(highest+1));
				oggetti.add(prodotto);

				i++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			
			
			prodotto = interfacciaprodotto.unprodottocodice(""+2);
			oggetti.add(prodotto);
			prodotto = interfacciaprodotto.unprodottocodice(""+1);
			oggetti.add(prodotto);
			prodotto=interfacciaprodotto.unprodottocodice(""+7);
			oggetti.add(prodotto); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		try {
			ricetta = interfacciaricetta.LastRicetta("Campania");
			oggetti.add(ricetta);
			ricetta = interfacciaricetta.LastRicetta("Calabria");
			oggetti.add(ricetta);
			ricetta = interfacciaricetta.LastRicetta("Sicilia");
			oggetti.add(ricetta);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		session.setAttribute("oggetti", oggetti);

		request.setAttribute("oggetti",oggetti);

		RequestDispatcher view=request.getRequestDispatcher("index.jsp");
		view.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

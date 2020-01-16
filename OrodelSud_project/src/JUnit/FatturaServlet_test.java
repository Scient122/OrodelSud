package JUnit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ClienteBean;
import Bean.ComposizioneBean;
import Bean.FatturaBean;
import Gestione_ordini.ComposizioneDAO;
import Gestione_ordini.FatturaDAO;
import Servlet.HttpSession;
import Servlet.RequestDispatcher;


@WebServlet("/FatturaServlet_test")
public class FatturaServlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public FatturaServlet_test() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<FatturaBean, ArrayList<ComposizioneBean>> fattura = new HashMap<FatturaBean, ArrayList<ComposizioneBean>>();
		FatturaDAO interfacciafattura = new FatturaDAO_Stub();
		ComposizioneDAO interfacciacomp = new ComposizioneDAO_Stub();
		HttpSession session = request.getSession();
		ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");
		ArrayList<FatturaBean> fatture = new ArrayList<FatturaBean>();
		
		
		try {
			fatture = interfacciafattura.getfatture(cliente.getEmail());

			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(FatturaBean f : fatture) {
			try {
				fattura.put(f, interfacciacomp.getprodotti(f.getN_documento()));

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("fattura", fattura);

		RequestDispatcher view=request.getRequestDispatcher("Ordini.jsp");
		view.forward(request,response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

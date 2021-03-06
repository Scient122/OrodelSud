package JUnit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Bean.ProdottoBean;
import Gestione_catalogo.ProdottoDAO;
@WebServlet("/SearchBarServlet_Test")

public class SearchBarServlet_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  public SearchBarServlet_Test() {
	        
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nome = request.getParameter("nome");
		ProdottoDAO interfaccia = new ProdottoDAO();
		int contatore; 
		int conteggio=0;
		String json = "";
		JSONObject jsonobject;
		JSONObject risposta = new JSONObject();
		
		if (nome==null) {
			nome=request.getParameter("titolo");
		}
		
		try {
			conteggio = interfaccia.conteggionome(nome);
			}
			catch (Exception e) {
				response.sendError(500, "Errore nell'operazione");
			}
		
		if (request.getParameter("informazioni")==null) 
			contatore=1;
		
		else {
			json = request.getParameter("informazioni");
			jsonobject=new JSONObject(json);

			if( jsonobject.getString("Messaggio").equals("Avanti")) 
				contatore = jsonobject.getInt("Contatore")+1; 
			
			else 
				contatore = jsonobject.getInt("Contatore")-1;
		}
		ArrayList <ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		try {
		prodotti = interfaccia.searchbar(contatore, nome);
		}
		catch (Exception e) {
			response.sendError(500, "Errore nell'operazione");
			}
		
		if (contatore==1) {

		if (((contatore-1)*5)+prodotti.size()==conteggio) 
			request.setAttribute("Altri", false);
		else 
			request.setAttribute("Altri", true);
			
		}
		
			risposta.put("Prodotti", prodotti);
			
			if (((contatore-1)*5)+prodotti.size()==conteggio) {
				risposta.put("Altri", false);
			}
			else 
				risposta.put("Altri", true);
			
		
				
		risposta.put("Contatore",contatore);
		
		if (contatore==1 && json.equals("")) {
			request.setAttribute("Prodotti",prodotti); 
			request.setAttribute("contatore", contatore);
			RequestDispatcher view=request.getRequestDispatcher("Searchprodotto.jsp");
			view.forward(request,response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print(risposta);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}

package JUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.*;

import Bean.AziendaBean;
import Bean.ProdottoBean;
import Gestione_catalogo.ProdottoDAO;

import java.util.*;
import Model.*;

@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ProdottoServlet() {
		super();
		
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("prodottoservlet");
		ProdottoDAO interfaccia = new ProdottoDAO_Stub();
		int contatore; 
		int conteggio=0;
		String json = "";
		JSONObject jsonobject;
		JSONObject risposta = new JSONObject();
		HttpSession session = request.getSession();
		AziendaBean azienda = (AziendaBean) session.getAttribute("aziendaBean");
		System.out.println(azienda);
		System.out.println(interfaccia);

		String destinazione="";
		if (request.getParameter("admin")!=null) {
			destinazione="AggiornaCatalogo.jsp";
		}
		else {
			destinazione="Catalogo.jsp";
		}

		try {
			if (session.getAttribute("adminBean") != null) {
				conteggio = interfaccia.conteggio();
			}
			else if (session.getAttribute("aziendaBean")!=null){
				System.out.println(azienda.getNome());
				System.out.println(interfaccia);
				conteggio = interfaccia.conteggio_azienda(azienda.getNome());
				System.out.println(azienda.getNome());
				System.out.println(conteggio);
			} else {
				conteggio = interfaccia.conteggio();
			}
		}
		catch (Exception e) {
			response.sendError(500, "Errore nell'operazione1");
			e.printStackTrace();
			return;
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
			if (session.getAttribute("adminBean") != null) {
			prodotti = interfaccia.Cinqueprodotti(contatore);
			}
			else if (session.getAttribute("aziendaBean")!=null){
				prodotti= interfaccia.Cinqueprodotti(contatore, azienda.getNome());
			}
			else {
				prodotti = interfaccia.Cinqueprodotti(contatore);
			}
		}
		catch (Exception e) {
			response.sendError(500, "Errore nell'operazione2");
			e.printStackTrace();
			return;
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
			RequestDispatcher view=request.getRequestDispatcher(destinazione);
			view.forward(request,response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print(risposta);
			out.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

public class ProdottoServlet_Test {

}

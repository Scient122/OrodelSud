package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Encoder.BinaryStream;

import Bean.AziendaBean;
import Bean.ProdottoBean;
import Connection.DriverMaagerConnectionPool;
import Gestione_catalogo.ProdottoDAO;

import javax.*;


@WebServlet("/AggiungiProdottoServlet")
@MultipartConfig

public class AggiungiProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AggiungiProdottoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome_prodotto = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo_base = request.getParameter("prezzobase");
		String quantita_disponibili = request.getParameter("quantitadisponibili");
		String conservazione = request.getParameter("conservazione");
		String categoria = request.getParameter("categoria");
		String IVA = request.getParameter("cambioiva");
	
		HttpSession session = request.getSession();
		AziendaBean azienda = (AziendaBean) session.getAttribute("aziendaBean");
		
		String nome_azienda = "";
		
		if (azienda!=null) { azienda.getNome(); }
		
		int codice;
		ProdottoDAO interfaccia = new ProdottoDAO();
		ProdottoBean prodotto = new ProdottoBean();
		try {
			codice = ProdottoDAO.highest()+1;
			prodotto.setCodice(""+codice);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		prodotto.setNome_prodotto(nome_prodotto);
		prodotto.setDescrizione(descrizione);
		prodotto.setPrezzo_base(Double.parseDouble(prezzo_base));
		prodotto.setQuantita_disponibili(Integer.parseInt(quantita_disponibili));
		prodotto.setConservazione(conservazione);
		prodotto.setCategoria(categoria);
		prodotto.setIva(Integer.parseInt(IVA));
		prodotto.setOfferta(false);
		prodotto.setPrezzo_totale(((prodotto.getPrezzo_base()*prodotto.getIva())/100)+prodotto.getPrezzo_base());
		
		if (azienda!=null) {
			prodotto.setAzienda(nome_azienda);
		}
		
		Part immagine = request.getPart("immagine");
		ByteArrayOutputStream flusso = new ByteArrayOutputStream();
		Blob blob = null;
		try {
			Connection connection = DriverMaagerConnectionPool.getConnection();
			blob = connection.createBlob(); 
			DriverMaagerConnectionPool.releaseConnection(connection);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		byte [] buffer=new byte[52428800]; //50mb
		int bytesRead=-1;
		bytesRead=immagine.getInputStream().read(buffer);
		flusso.write(buffer,0,bytesRead);
		byte[] imageBytes=flusso.toByteArray();
		flusso.close();
		immagine.getInputStream().close();
		
		try {
			blob.setBytes(1, imageBytes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prodotto.setImmagine(blob);
		
		try {
			interfaccia.aggiunta(prodotto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("ProdottoServlet?admin=yes");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

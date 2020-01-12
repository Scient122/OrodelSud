package Gestione_ricette;

import java.sql.*;
import java.io.*;
import java.util.*;

import Bean.RicettaBean;
import Model.DriverMaagerConnectionPool;
import Servlet.Utilities;
public class RicettaDAO {
	
	public synchronized RicettaBean LastRicetta(String provenienza)throws SQLException,IOException {
		String query="SELECT * FROM ricetta WHERE provenienza=?";
		PreparedStatement statement=null;
		Connection connection=null;
		RicettaBean ricetta=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,provenienza);
			ResultSet risultato=statement.executeQuery();
			
			if(risultato.first()) {
			
				risultato.last();
				ricetta=new RicettaBean();
				ricetta.setTitolo(risultato.getString("titolo"));
				ricetta.setDescrizione(risultato.getString("descrizione"));
				ricetta.setProvenienza(risultato.getString("provenienza"));
				ricetta.setCategoria(risultato.getString("categoria"));
				ricetta.setImmagine(risultato.getBlob("immagine"));
				Blob blob=ricetta.getImmagine();
				InputStream stream=blob.getBinaryStream();
				ricetta.setBase64Image(Utilities.convertImage(stream));
			
			return ricetta;
			}
			else
				return null;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
		
}
	
public synchronized ArrayList<RicettaBean> categoria(String categoria)throws SQLException,IOException{
		ArrayList<RicettaBean> ricette=new ArrayList<RicettaBean>();
		String query="SELECT * FROM ricetta WHERE categoria=?";
		PreparedStatement statement=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,categoria);
			ResultSet risultato=statement.executeQuery();
			risultato.beforeFirst();
			while(risultato.next()) {
				RicettaBean temp=new RicettaBean();
				temp.setCategoria(risultato.getString("categoria"));
				temp.setProvenienza(risultato.getString("provenienza"));
				temp.setDescrizione(risultato.getString("descrizione"));
				temp.setTitolo(risultato.getString("titolo"));
				temp.setImmagine(risultato.getBlob("immagine"));
				Blob blob=temp.getImmagine();
				InputStream stream=blob.getBinaryStream();
				temp.setBase64Image(Utilities.convertImage(stream));
				ricette.add(temp);
			}
			
			return ricette;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
		
}


	public synchronized RicettaBean Onericetta (String titolo) throws SQLException,IOException{
		String query="SELECT * FROM ricetta WHERE titolo=?";
		RicettaBean ricette = new RicettaBean();
		PreparedStatement statement=null;
		Connection connection=null;
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,titolo);
			ResultSet risultato=statement.executeQuery();
			risultato.beforeFirst();
			if (risultato.first()) {
				ricette.setCategoria(risultato.getString("categoria"));
				ricette.setProvenienza(risultato.getString("provenienza"));
				ricette.setDescrizione(risultato.getString("descrizione"));
				ricette.setTitolo(risultato.getString("titolo"));
				ricette.setImmagine(risultato.getBlob("immagine"));
				Blob blob=ricette.getImmagine();
				InputStream stream=blob.getBinaryStream();
				ricette.setBase64Image(Utilities.convertImage(stream));
				return ricette;
			}
			else {
				return null;
			}
			
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
}
	
	public synchronized ArrayList<RicettaBean> Provenienza (String provenienza) throws SQLException,IOException{
		ArrayList<RicettaBean> ricette=new ArrayList<RicettaBean>();
		String query="SELECT * FROM ricetta WHERE provenienza=?";
		PreparedStatement statement=null;
		Connection connection=null;
		
		try {
			connection=DriverMaagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			statement=connection.prepareStatement(query);
			statement.setString(1,provenienza);
			ResultSet risultato=statement.executeQuery();
			risultato.beforeFirst();
			while(risultato.next()) {
				RicettaBean temp=new RicettaBean();
				temp.setCategoria(risultato.getString("categoria"));
				temp.setProvenienza(risultato.getString("provenienza"));
				temp.setDescrizione(risultato.getString("descrizione"));
				temp.setTitolo(risultato.getString("titolo"));
				temp.setImmagine(risultato.getBlob("immagine"));
				Blob blob=temp.getImmagine();
				InputStream stream=blob.getBinaryStream();
				temp.setBase64Image(Utilities.convertImage(stream));
				ricette.add(temp);
			}
			
			return ricette;
		}
		
		finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
}
}

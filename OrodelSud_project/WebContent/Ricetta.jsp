<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<title> Ricetta </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/TotalRicetta.css">
<link rel="icon" href="Immagini/Iconlogo.png">
</head>

<body>
<jsp:include page="Header.jsp"/>


<%@page import="Model.*" %>
<%@page import="Bean.*" %>
<%@page import="java.util.*" %>
<% RicettaBean ricetta = (RicettaBean) request.getAttribute("Ricetta");
ArrayList<RecensioneBean> recensioni = (ArrayList<RecensioneBean>) request.getAttribute("Recensioni");%>

<h1 id="h1"> <%=ricetta.getTitolo()%></h1>
<br>

<div id="Ricetta">
<img src="data:image/jpg;base64,<%=ricetta.getBase64Image()%>"><br><br>

<p> Provenienza: <%=ricetta.getProvenienza() %> </p> <br>
<p> Categoria: <%=ricetta.getCategoria() %> <br> <br>
<p> <%=ricetta.getDescrizione()%> </p>
<br>
<% if (session.getAttribute("userBean")!=null) { %>
<form action="RecensioneServlet?titolo=<%=ricetta.getTitolo()%>" method="POST"> 
<textarea rows="4" cols="50" placeholder="Inserisci qui la tua recensione!" required name="textarea"></textarea>
<input type="submit" id="bottonerecensione" style="background-color:#E9967A; margin-top:20px; width:80px; height:50px; border-radius:10px; margin-left:10px;" value="Invia!" name="recensionebutton">
</form>
<% } %>
<br> <br> <p> Ti potrebbero interessare queste altre ricensioni: </p>
<% for (RecensioneBean r: recensioni) { %>
<br>
<p> - <%= r.getCommento() %> </p> 

<% } %>
<br> <br> 

</div>
<jsp:include page="Footer.jsp"/>

</body>
</html>
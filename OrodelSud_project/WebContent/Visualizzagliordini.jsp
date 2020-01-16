<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Comfortaa&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Courgette&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Electrolize&display=swap" rel="stylesheet">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Ordini.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> I tuoi ordini </title>
</head>

<body>
<jsp:include page="Header.jsp"/> 
<%@page import="Model.*" %>
<%@page import="java.util.*" %>

<%
	Bean.AdminBean admin= null;
Bean.ClienteBean cliente = null;
if((session.getAttribute("adminBean")!=null)) {
	admin = (Bean.AdminBean) session.getAttribute("adminBean"); 
}  
else {
	 cliente = (Bean.ClienteBean) session.getAttribute("userBean");
}
%>

<aside id="asidepersonale"> 
<ul id="ulaside"> 

<% if(session.getAttribute("userBean")!=null) { %>
<li id="ituoirdini"> <a href="FatturaServlet"> I tuoi ordini </a> </li>
<% } %>
<% if(session.getAttribute("adminBean")!=null) { %>
<li id="pannellodicontrollo"> Pannello di controllo
<div id="menucontrollopannello"> 
<ul> 
	<li> <a href="ProdottoServlet?admin=yes"> Aggiorna il catalogo </a> </li>
	<li> <a href="Visualizzagliordini.jsp"> Visualizza gli ordini </a> </li>
	<li> <a href="Nuovoprodotto.jsp"> Aggiungi un nuovo prodotto </a> </li>
</ul>
</div> 
</li>
<% } %>
<% if(session.getAttribute("userBean")!=null) { %>
<li id="metodipagemento"> <a href="Pagamento.jsp"> Metodi di pagamento</a> </li>
<% } %>
<li id="logout"><a href="LogoutServlet"> Logout </a> </li>
</ul>
</aside>

<div id="divricercapannello"> 
<h1 id="titoloareapersonale"> Ricerca degli ordini </h1>
<br> <br>

<div id="divdiricerca"> 
<form action="RicercaFatturaServlet" method="POST">
<p> 
Inserisci l'email del cliente: <input type="email" name="email"> </p> <br>

<p> Inserisci il range della data: <input type="date" name="datamin"> &nbsp; <input type="date" name="datamax"> </p> <br><br> <br><br> <br> <br>

<button id="bottoneconfermaordini" type="submit"> Conferma </button> <br> <br>

<p id="NBinfo"> N.B. Nel caso in cui non venisse inserita alcuna e-mail, verranno visualizzati gli ordini di TUTTI i clienti.
Non vi &egrave; obbligatoriet&agrave; nell'inserire il range entro il quale ricercare gli ordini del/dei cliente/i. </p>
</form>
</div>
<br> <br>

</div>
<jsp:include page="Footer.jsp"/> 

</body>
</html>
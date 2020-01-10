<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

<link href='https://fonts.googleapis.com/css?family=Fugaz One' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Cutive Mono' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Aclonica' rel='stylesheet'>
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Stile.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> OroDelSud </title>
</head>

<body>

<%@page import="Model.*"%>

<%
String appoggio="";
Bean.ClienteBean cliente = null;
Bean.AdminBean admin = null;
Bean.AziendaBean azienda = null;
if (session.getAttribute("adminBean")!=null) {
	admin = (Bean.AdminBean) session.getAttribute("adminBean");
	appoggio=admin.getNome();
}
else 
	if (session.getAttribute("userBean")!=null) {
		cliente=(Bean.ClienteBean) session.getAttribute("userBean");
		appoggio = cliente.getNome();
	}
	else if (session.getAttribute("aziendaBean")!=null) {
		azienda = (Bean.AziendaBean) session.getAttribute("aziendaBean");
		appoggio = azienda.getNome();
	}
else {
	appoggio = "Accedi";
}
%>



<header>

 <a href="index.jsp"> 
<img id="logo" src="Immagini/Logogialloritagliato.png" alt="Logo del sito">
</a>
  
<nav>

<form id="foform" action="SearchbarServlet" method="POST">    
<input id="barra_ricerca" type="text" name="nome" placeholder="Cosa stai cercando?">
<button type="submit" id="bricerca"> 
<img id="lente" src="Immagini/Lente100.png">
&nbsp;  
</button>  
</form>

<div id="mySidenav" class="sidenav">
<form id="foform1" action="SearchbarServlet" method="POST">    
<input id="barra_ricerca" type="text" name="nome" placeholder="Cosa stai cercando?">
<button type="submit" id="bricerca"> 
<img id="lente" src="Immagini/Lente100.png">
&nbsp;  
</button>  
</form>
  
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="Carrello.jsp">Carrello</a>
  <a href="ProdottoServlet">Catalogo</a>
  <a href="Aboutus.jsp">Chi siamo</a>
  <a href="Login.jsp"> <%=appoggio%></a>
	
	<% 
	if(session.getAttribute("adminBean")==null&&session.getAttribute("userBean")==null&&session.getAttribute("aziendaBean")==null){
	%>
  
  <a href="Registrationtype.jsp">Registrazione</a>
  <% } %>
  <a href="RicetteServlet">Ricette</a>

</div>

<span id="Myspan" onclick="openNav()">

<input id="trerighe" type="image" src="Immagini/Menusidebar2.png">
<label id="labelmenu"> Menù </label>
</span>

<span id="sopra">

<ul id="ul3s"> 

<% if(session.getAttribute("adminBean")==null&&session.getAttribute("userBean")==null&&session.getAttribute("aziendaBean")==null){
	
%>
<li> <button class="bottonisopra" id="Registration" onclick="window.location.href='Registrationtype.jsp'"> 
<input id="registrazione" type="image" src="Immagini/Registrazione.png"> 
Registrazione 
<% } %>

</button> 
</li>
<li> <button class="bottonisopra" id="Login" onclick="Redirect(this)">
<input id="accedi" type="image" src="Immagini/User.png">
<%=appoggio%>
</button></li>
<li> <button class="bottonisopra" id="Carrello" onclick="document.location='Carrello.jsp'"> 
<input id="carrello" type="image" src="Immagini/Carrellotagliato.png"> 
Carrello 
</button> </li>
</ul>

</span>

<span id="sotto">

<ul id="ul3sotto">

<li> 
<% if (session.getAttribute("aziendaBean")== null) { %>
<button class="bottonisopra" id="Catalogo" onclick="document.location='ProdottoServlet'">
<input id="catalogo" type="image" src="Immagini/Catalogo.png">
<% } else { %>
<button class="bottonisopra" id="Catalogo" onclick="document.location='ProdottoServlet?admin=yes'">
<input id="catalogo" type="image" src="Immagini/Catalogo.png">
<% } %>
Catalogo

<div id="tendina">
	<ul>
		<li> <a href="CategoriaProdottoServlet?categoria=Pasta"> Pasta </a></li>
		<li> <a href="CategoriaProdottoServlet?categoria=Latticino"> Latticini </a> </li>
		<li> <a href="CategoriaProdottoServlet?categoria=Olio"> Olio </a></li> 
		<li> <a href="CategoriaProdottoServlet?categoria=Vino"> Vino </a> </li>
		<li> <a href="CategoriaProdottoServlet?categoria=Sottovuoto"> Sottovuoto </a> </li>
		<li> <a href="CategoriaProdottoServlet?categoria=Formaggio"> Formaggio </a> </li>
		<li> <a href="ProdottoOffertaServlet"> Offerte </a> </li>
	</ul>
</div>

</button> 
</li>
&nbsp;&nbsp;&nbsp;
<li> 
<button class="bottonisopra" id="Ricette" onclick="document.location='RicetteServlet'">
<input id="ricette" type="image" src="Immagini/Ricette.png">
Ricette 

<div id="tendina">
	<ul>
		<li><a href="CategoriaServlet?Categoria=Primo">Primi</a></li>
		<li><a href="CategoriaServlet?Categoria=Secondo">Secondi</a></li>
		<li><a href="CategoriaServlet?Categoria=Dolce">Dolci</a></li>
	</ul>
</div>
</button>

</li>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<li> 
<button class="bottonisopra" id="Aboutus" onclick="Redirect(this)">
<input id="aboutus" type="image" src="Immagini/Aboutus.jpg">
Chi siamo</button> 
</li>
</ul>

</span>

</nav>
</header>

<script> 

function Redirect(a) {
	document.location=a.id+'.jsp';
}

function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
  }

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
}

</script>
</body>
</html>
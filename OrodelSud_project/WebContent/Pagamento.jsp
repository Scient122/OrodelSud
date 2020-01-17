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
<link rel="stylesheet" href="Css/Pagamento.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Metodi di pagamento </title>
</head>
<body>
<jsp:include page="Header.jsp"/> 
<%@page import="Connection.*" %>
<%@page import="java.util.*" %>

<%
	Bean.ClienteBean cliente = null;
Bean.AdminBean admin;

if ((session.getAttribute("adminBean")==null) && (session.getAttribute("userBean")==null))
	response.sendRedirect("Login.jsp");
%>

<%
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
<li id="metodipagemento"> <a href="Pagamento.jsp"> Metodi di pagamento</a> </li>
<li id="logout"><a href="LogoutServlet"> Logout </a> </li>
</ul>
</aside>

<div id="divgeneralepannello"> 
<h1 id="titoloareapersonale"> I tuoi metodi di pagamento </h1>
<br> <br>


<% 
HashMap<String,String> carte;
Set <String> numeri_carte;
if(cliente!=null) {
carte = cliente.getCarte_credito(); 
numeri_carte = carte.keySet();
for (String s: numeri_carte) { %>
<div class="divcartecredito">
<span>- Tipologia carta di credito: <%=carte.get(s) %></span>
<span>- Numero carta di credito: <%= s %></span>
<button class="bottonetrash" onclick="deletecards($(this))"> <img src="Immagini/Trash.png"> </button> 
<br> <br><br> <br><br> <br>
</div>

<% }  }%>

<form method="post" action="AddCreditCardServlet" id="formareapersonale" onchange="control()">
<span class="modifcaspan" id="spancartacredito">- Inserisci il numero della carta: </span> 
<input class="modifcaspan" id="inputcartacredito" name="carta" type="text" onblur="allNumbers(this)"> <span id="cartacredito"></span> <br>
<span class="modifcaspan"> 
- Scegli la tipologia:
<input type="radio" name="credito" checked="checked" value="Visa"> Visa
<input type="radio" name="credito" value="Mastercard"> Mastercard
<input type="radio" name="credito" value="Postepay"> Postepay  <br> </span> <br> <br><br> 


<div id="divbottoniareapersonale"> 
<button class="modificabutton" id="modificadati" type="button" onclick="showdiv()"> Aggiungi </button> 
<button class="modificabutton" id="confermabottonearea" type="submit">Conferma</button>

</div>
</form>
</div>



<jsp:include page="Footer.jsp"/> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>


<script>

function allNumbers(uname){
	
	var numbers= /^[0-9]+$/;
	var prova;
	if(uname.value.match(numbers)){
		prova=document.getElementById("cartacredito");
		prova.innerHTML="";
		return true;
	}
	
	else{
		prova=document.getElementById("cartacredito");
		prova.innerHTML="Errore";
		uname.focus();  
		return false;
	}
}

</script>

<script>

function deletecards(button) {
	var parola = button.prev().html();
	var numero = parola.substring(27);

	document.location="DeleteCreditCardsServlet?numero_carta="+numero;
}

</script>

<script>

function showdiv() {
	$(".modifcaspan").show();
	$("#modificadati").hide();
	return false;
}
</script>

<script>

function control(){
	var elementi=document.getElementsByTagName("input");
	var bottone=document.getElementById("confermabottonearea");
		if(allNumbers(document.getElementById("inputcartacredito"))) {
			bottone.style.display="inline"; 
		}
	else{
		bottone.style.display="none";
	}
}
</script>

</body>
</html>
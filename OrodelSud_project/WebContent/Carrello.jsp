<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

<link href="https://fonts.googleapis.com/css?family=Anonymous+Pro&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Reem+Kufi&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Karma&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap" rel="stylesheet">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Carrello.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Il tuo carrello </title>
</head>
<body>

<% String destinazione;
if ((session.getAttribute("adminBean")==null) && (session.getAttribute("userBean")==null))
		destinazione = "Login.jsp";
	else
		destinazione="Conferma.jsp";
%>

<jsp:include page="Header.jsp"/>

<script>
function ridimensiona (img) {
  	
	var image = document.getElementsByClassName('immaginedivcarrello');
		
	if(img.height > 500) {
		img.style.height = '360px';
	}
}
	
</script>

<%@page import="Bean.*" %>
<%@page import="Model.*" %>
<%@page import="java.util.*" %>

<%Gestione_catalogo.Carrello carrello=(Gestione_catalogo.Carrello) session.getAttribute("carrello");
double somma = 0;
if (carrello == null || carrello.size()==0) { %>
	

<h1 id="h1"> Il tuo carrello è vuoto! Riempilo <a href="ProdottoServlet"> QUI </a> </h1>
<img id="immaginecarrellocarrello" src="Immagini/Carrellotagliato.png">

<% } 

 else {
Set <ProdottoBean> prodotti= carrello.getprodotti();
for (ProdottoBean p :prodotti) { %>
		
	<div class="divisori"> 
		<p class="nomeprodottocarrello"><%=p.getNome_prodotto()%></p><br>
		<img class="immaginedivcarrello" src="data:image/jpg;base64,<%=p.getBase64Image()%>" onload="ridimensiona (this)">
		<p class="prezzosingolo"> Prezzo di un singolo prodotto: <%=p.getPrezzo_totale()%>&euro;</p>
		<p class="prezzototale"> Prezzo totale: <%=String.format("%.2f", p.getPrezzo_totale()*carrello.getquantita(p)) %>&euro; </p>
		<button class="bottonetrash" onclick="cancella($(this))"> <img src="Immagini/Trash.png"> </button> 
		<p>- Clicca qui se vuoi cambiare la quantit&agrave;: <input type="number" onchange="ricalcolo($(this))" onkeydown="return false" name="quantita" id="inputnumber" min="1" max="<%=p.getQuantita_disponibili()%>" value="<%=carrello.getquantita(p)%>"> <br></p>
		<br><br>
		<% somma = somma + (p.getPrezzo_totale()*carrello.getquantita(p));  %>
	</div>
		
<% } %>



<div id="divbottoneacquista"> 
	<p>- Prezzo totale: <%=String.format("%.2f", somma) %>&euro; 
	<button class="bottoneacquista" onclick="document.location='<%=destinazione%>'"> Acquista </button> </p>
</div>
 <% }%>
 
<jsp:include page="Footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

<script>

function ricalcolo(input) {
	var value = parseInt(input.val());
	
	var stringaprezzo = input.parent().prev().prev().prev().html();
	var prezzo = stringaprezzo.substring(31,37);
	var prezzosingolo = parseFloat(prezzo);
		
	var prezzototale = value*prezzosingolo;
	
	input.parent().prev().prev().html("Prezzo totale: "+prezzototale.toFixed(2)+"&euro;");
	
	
	var x = $(".prezzototale");
	var tot = 0;
	var i = 0;
	
	for (i=0; i<x.length; i++) {
		tot = tot + parseFloat(x.eq(i).html().substring(15,20)); 	
		}
	$("#divbottoneacquista p").html("- Prezzo totale: "+tot.toFixed(2)+"&euro;	<button class='bottoneacquista'> Acquista </button>");
	}	
</script>


<script>
function cancella(input) {
	
	var titolo = input.prev().prev().prev().prev().prev().html();
	$.ajax({type:'POST',
		url:'DeleteItemServlet',
		data:{
			'titolo':titolo
			 }
	});
	location.reload(true);
}
</script>
</body>
</html>
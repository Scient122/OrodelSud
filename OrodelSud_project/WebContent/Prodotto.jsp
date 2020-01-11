<%@page import="Bean.ProdottoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Comfortaa&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Prodotto.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Prodotto </title>

</head>
<body>
<jsp:include page="Header.jsp"/>

<script>
function ridimensiona (img) {
  	
	var image = document.getElementsByClassName('immagineprodottoclasse');
		
	if(img.height > 300) {
		img.style.height = '270px';
	}
	
	if (img.width > 300) {
		img.style.width ='240px';
	}
	
}
</script>




<aside id="cataside"> 

<ul id="ulaside"> 

<li id="latticini"> <a href="CategoriaProdottoServlet?categoria=Latticino"> Latticini</a> </li>
<li id="formaggi"> <a href="CategoriaProdottoServlet?categoria=Formaggio">Formaggi</a> </li>
<li id="sottovuoto"><a href="CategoriaProdottoServlet?categoria=Sottovuoto"> Sottovuoto</a> </li>
<li id="pasta"><a href="CategoriaProdottoServlet?categoria=Pasta"> Pasta</a> </li>
<li id="olio"><a href="CategoriaProdottoServlet?categoria=Olio"> Olio</a> </li>
<li id="vino"> <a href="CategoriaProdottoServlet?categoria=Vino">Vino</a> </li>
<li id="specialoffers"><a href="ProdottoOffertaServlet"> Offerte </a></li>

</ul>

</aside>

<%@page import="Model.*" %>
<% Bean.ProdottoBean prodotto = (Bean.ProdottoBean) request.getAttribute("Prodotto");%>
<%if (session.getAttribute("carrello")==null) {
	Gestione_catalogo.Carrello carrello = new Gestione_catalogo.Carrello();
	session.setAttribute("carrello", carrello);
} %>


<div id="Informazioni">
<h1 id="h1"><%=prodotto.getNome_prodotto()%></h1>
<br>
	
<img id="immagineprodotto" class="immagineprodottoclasse" onload="ridimensiona(this)" src="data:image/jpg;base64, <%=prodotto.getBase64Image()%>">
<br><br>
<p> - Prezzo base (esclusa IVA): <%=prodotto.getPrezzo_base() %>&euro; </p> <br>
<p> - Prezzo totale (inclusa IVA): <%=prodotto.getPrezzo_totale() %>&euro; </p> <br> 
<p> - Descrizione: <%=prodotto.getDescrizione() %> <br> </p> <br> 
<p> - Quantit&agrave; disponibili: <%=prodotto.getQuantita_disponibili() %> </p> <br> 
<p> - Conservazione: <%=prodotto.getConservazione() %> </p> <br>
<p> - Produttore: <%=prodotto.getAzienda() %> </p> <br> 
<form method="Post" action="ANCORANONLOSAPPIAMO" id="Quantita">
<% if (session.getAttribute("aziendaBean")== null && session.getAttribute("adminBean")==null) { %>
<p> - Seleziona le quantit&agrave;: <input type="number" onkeydown="return false" placeholder="" name="quantita" id="inputnumber" min="1" max="<%=prodotto.getQuantita_disponibili()%>"> <br>  </p>
<% } %>
</form>
<br>
<% if (session.getAttribute("aziendaBean")== null && session.getAttribute("adminBean")==null)  { %>
<a> <button id="aggiungicarrello" onclick="animazione();aggiungi()" > <img src="Immagini/CarrelloProdotto.png"> Aggiungi al carrello </button></a>
<% } %>

</div>
<jsp:include page="Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

<script>

function animazione () {
	var width = $(window).width();
	var height = $(window).height();
	
	
	if(width>630) {
	$("#Informazioni button").animate({width: '500px'});
	$("#Informazioni button").html("<img src='Immagini/CarrelloProdotto.png'>");
	$("#Informazioni button img").animate({left: "+=430"}, 2000, "swing", ShowText);
	}
	else {
		$("#Informazioni button").animate({width: '280px'});
		$("#Informazioni button").html("<img src='Immagini/CarrelloProdotto.png'>");
		$("#Informazioni button img").animate({left: "+=210"}, 2000, "swing", ShowText);
	}
	
	$("#Informazioni button").css("width", "50px");
	$("#Informazioni button").css("height", "70px");
	
	$("#Informazioni button img").css("height", "50%");
	$("#Informazioni button img").css("width", "10%");
}
</script>

<script> 
function ShowText() {
	$("#Informazioni button img").hide(1000);
	
	setTimeout(function() 
			  {
				$("#Informazioni button").html("Aggiunto con successo!");
			  }, 1300);
	
	setTimeout(function() {
		$("#Informazioni button").html("<img src='Immagini/CarrelloProdotto.png'> Aggiungi di nuovo al carrello");
		$("#Informazioni button").css("background-color","#f0c14b");
		$("#Informazioni button").css("border","0px white");
		$("#Informazioni button").css("border-radius","10%");
		$("#Informazioni button").css("font-family","'Righteous', cursive");
		$("#Informazioni button").css("font-size","130%");
		$("#Informazioni button").css("padding-top","0.5%");
		$("#Informazioni button").css("display","block");
		$("#Informazioni button").css("margin","auto");
		$("#Informazioni button").css("width","270px");
		$("#Informazioni button img").css("position","relative");
		
		$("#Informazioni button img").css("float","left");
		$("#Informazioni button img").css("height", "40px");
		$("#Informazioni button img").css("width", "50px");
		
	}, 2300);
}
</script>

<script>

function aggiungi() {
	$.ajax({type:'POST',
		url:'AddCartServlet',
		data:{
			'quantita': document.getElementById("inputnumber").value,
			'titolo': document.getElementById("h1").innerHTML
		}
		});
}

</script>
</body>
</html>
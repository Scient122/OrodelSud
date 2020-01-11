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
<link href="https://fonts.googleapis.com/css?family=Inconsolata&display=swap" rel="stylesheet">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Catalogo.css">
<link rel="icon" href="Immagini/Iconlogo.png">
<title> Prodotti per categoria </title>
</head>

<body>
<%@page import="Model.*" %>
<%@page import="java.util.*" %>
<%@page import="Bean.*" %>

<%if (session.getAttribute("carrello")==null) {
	Gestione_catalogo.Carrello carrello = new Gestione_catalogo.Carrello();
	session.setAttribute("carrello", carrello);
} %>
<input type="hidden" name="count" value="1">
<input type="hidden" name="categoria" value=<%=request.getParameter("categoria") %>>
<script> var collezione =1 </script>
<%
int contatore= (int) request.getAttribute("contatore"); 
ArrayList<ProdottoBean> prodotti = (ArrayList<ProdottoBean>) request.getAttribute("Prodotti");
%>


<jsp:include page="Header.jsp"/> 

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

<div id="Contenitore"> 

<% for (int i=0; i<prodotti.size(); i++) {
%>

<div id="Prodotto">

<hr>

<h1 id="h1"><%=prodotti.get(i).getNome_prodotto()%></h1>
<br>

<p id="informazioni"> 

<img src="data:image/jpg;base64,<%=prodotti.get(i).getBase64Image()%>">

<p id="infotesto" class="infotesti">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: <%= prodotti.get(i).getPrezzo_base()%>&euro; <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: <%= prodotti.get(i).getQuantita_disponibili() %>
</p>
</p>

<!-- <a href="OneProductServlet?codice=<%=prodotti.get(i).getCodice()%>">  -->
<button id="prodottobottone" onclick="caricamento($(this))" > Visualizza prodotto 
<img src="Immagini/Arrowtagliata.png"> </button> <!--  </a> --> 
<br> <br> <br> <br>

</div>
<%  } %>
</div>

<div id="divbottoni"> 


<% boolean Altri = (boolean) request.getAttribute("Altri"); 
if(Altri==true) { %>

<a>
<button id="prodottobottone" class="avanti" onclick="Avanti(this, parseInt(document.getElementsByName('count')[0].value), collezione)"> Avanti 
<img src="Immagini/Arrowtagliata.png"> </button></a> 
<% } %>




<a>
<button id="prodottobottone" class="indietro" onclick="indietro(this, parseInt(document.getElementsByName('count')[0].value), collezione)">
<img id="left" src="Immagini/Arrowleft.png"> Indietro
 </button></a> 


</div>

<jsp:include page="Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

<script> 

function Avanti (button, contatore, collezione) {
	var json={"Messaggio":"Avanti","Contatore":contatore};
	document.getElementsByName("count")[0].value = parseInt(document.getElementsByName("count")[0].value)+1;
	json = JSON.stringify(json);
	$.ajax({type:'POST',
			url:'CategoriaProdottoServlet?categoria='+document.getElementsByName("categoria")[0].value,
			data:{
				'informazioni':json
				 },
			success: function (data,status) {
				var risposta=JSON.parse(data);
				var prodotti=risposta.Prodotti;
				collezione=risposta.Prodotti;
				var i=0;
				var j=0;
				showing(risposta.Contatore, risposta.Altri);
				
				
				while (i<5 && i<prodotti.length) {
					$("h1").eq(i).html(prodotti[i].nome_prodotto);
					$(".infotesti").eq(i).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: "+prodotti[i].prezzo_base+"&euro;"+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: "+prodotti[i].quantita_disponibili);
					$("#informazioni img").eq(i).attr("src", "data:image/jpg;base64,"+prodotti[i].base64Image);
					i++;
				}
				while(i<5) {
					$("#Contenitore div").eq(i).hide();
					i++;
				}
					
					
			}
		});
	}
</script>
<script>
function showing (contatore, altri) {
	if (altri==false) 
		$(".avanti").hide(0);
	else
		$(".avanti").show(0);
	
	if (contatore==1) 
		$(".indietro").hide(0);
		else
			$(".indietro").show(0);
	}
</script>
	
<script>
	function indietro (button, contatore, collezione) {
		var json={"Messaggio":"Indietro","Contatore":contatore};
		document.getElementsByName("count")[0].value = parseInt(document.getElementsByName("count")[0].value)-1;
		json = JSON.stringify(json);
		$.ajax({type:'POST',
			url:'CategoriaProdottoServlet?categoria='+document.getElementsByName("categoria")[0].value,
				data:{
					'informazioni':json
					 },
				success: function (data,status) {
					var risposta=JSON.parse(data);
					var prodotti=risposta.Prodotti;
					collezione=risposta.Prodotti;
					var i=0;
					var j=0;
					showing(risposta.Contatore, risposta.Altri);
					
					while (j<5) {
						$("#Contenitore div").eq(j).show(0);
						j++;
					}
					
					while (i<5 && i<prodotti.length) {
						$("h1").eq(i).html(prodotti[i].nome_prodotto);
						$(".infotesti").eq(i).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: "+prodotti[i].prezzo_base+"&euro;"+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: "+prodotti[i].quantita_disponibili);
						$("#informazioni img").eq(i).attr("src", "data:image/jpg;base64,"+prodotti[i].base64Image);
						i++;
					}
					
					while(i<5) {
						$("#Contenitore div").eq(i).hide();
						i++;
					}
}
		});
		}
</script>

<script>

$("#Prodotto button").click(function () {
	
	document.location='OneProductServlet?titolo='+$(this).prev().prev().prev().prev().prev().html();
	
});

</script>

</body>

</html>
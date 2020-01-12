<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Ricette.css">
<link href='https://fonts.googleapis.com/css?family=Aclonica' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Advent Pro' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Galada' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=GFS Didot' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Happy Monkey' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Niramit' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Overpass Mono' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Oregano' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Love Ya Like A Sister' rel='stylesheet'>
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Ricette </title>
</head>
<body>
<%@page import="Model.*" %>
<%@page import="Bean.*" %>
<% RicettaBean ricette[] = (RicettaBean[]) request.getAttribute("Ricette");%>

<jsp:include page="Header.jsp"/>


<h1 id="h1"> Mi raccomando, sii moderato!</h1>

<div id="Esplora">
<p id="Explore"> Esplora: 
<a href="CategoriaServlet?Categoria=Primo">| Primi |</a> 
<a href="CategoriaServlet?Categoria=Secondo"> | Secondi |</a>
<a href="CategoriaServlet?Categoria=Dolce"> | Dolci |</a>
</p>
</div>

<div id="Generale"> 

<img id="imgAbruzzo" src="Immagini/Abruzzo.png"> 
<span class="titolo dispari" onmouseover="showdisplay('#Abruzzo')"> Ricette abruzzesi </span>
<div id="Abruzzo" onmouseleave="hidedisplay(this)">


<img src="data:image/jpg;base64,<%=ricette[0].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[0].getTitolo()%> </h2>
<p class="descrizione"> 
<%int posAbruzzo=ricette[0].getDescrizione().indexOf("Procedimento");
String appoggio= ricette[0].getDescrizione().substring(0, posAbruzzo);%>
<%=appoggio%>
</p>
 <a href="FinalRicettaServlet?Ricetta=<%=ricette[0].getTitolo()%>">
<button id="abruzzesi"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[0].getProvenienza()%>"> 
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgMolise" src="Immagini/Molise.png">
<span class="titolo pari" onmouseover="showdisplay('#Molise')"> Ricette molisane </span>
<div id="Molise" onmouseleave="hidedisplay(this)"> 


<img src="data:image/jpg;base64,<%=ricette[1].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[1].getTitolo()%> </h2>
<p class="descrizione"> 
<%int posMolise=ricette[1].getDescrizione().indexOf("Procedimento");
String appoggio1=ricette[1].getDescrizione().substring(0, posMolise);%>
<%=appoggio1%>
</p>


 <a href="FinalRicettaServlet?Ricetta=<%=ricette[1].getTitolo()%>">
<button id="molisane"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[1].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgCampania" src="Immagini/Campania.png"> 
<span class="titolo dispari" onmouseover="showdisplay('#Campania')" > Ricette campane </span>
<div id="Campania" onmouseleave="hidedisplay(this)"> 

<img src="data:image/jpg;base64,<%=ricette[2].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[2].getTitolo()%> </h2>
<p class="descrizione">
<%int posCampania=ricette[2].getDescrizione().indexOf("Procedimento");
String appoggio2= ricette[2].getDescrizione().substring(0, posCampania);%>
<%=appoggio2%>
</p>

 <a href="FinalRicettaServlet?Ricetta=<%=ricette[2].getTitolo()%>">
<button id="campane"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[2].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgPuglia" src="Immagini/Puglia.png"> 
<span class="titolo pari" onmouseover="showdisplay('#Puglia')"> Ricette pugliesi </span>
<div id="Puglia" onmouseleave="hidedisplay(this)"> 

<img src="data:image/jpg;base64,<%=ricette[3].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[3].getTitolo()%> </h2>
<p class="descrizione"> 
<%int posPuglia=ricette[3].getDescrizione().indexOf("Procedimento");
String appoggio3= ricette[3].getDescrizione().substring(0, posPuglia);%>
<%=appoggio3%>
</p>

 <a href="FinalRicettaServlet?Ricetta=<%=ricette[3].getTitolo()%>">
<button id="pugliesi"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[3].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgBasilicata" src="Immagini/Basilicata.png"> 
<span class="titolo dispari" onmouseover="showdisplay('#Basilicata')"> Ricette lucane </span>
<div id="Basilicata" onmouseleave="hidedisplay(this)" > 

<img src="data:image/jpg;base64,<%=ricette[4].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[4].getTitolo()%> </h2>

<p class="descrizione"> 
<%int posBasilicata=ricette[4].getDescrizione().indexOf("Procedimento");
String appoggio4= ricette[4].getDescrizione().substring(0, posBasilicata);%>
<%=appoggio4%>
</p>

 <a href="FinalRicettaServlet?Ricetta=<%=ricette[4].getTitolo()%>">
<button id="lucane"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[4].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgCalabria" src="Immagini/Calabria.png"> 
<span class="titolo pari" onmouseover="showdisplay('#Calabria')"> Ricette calabresi </span>
<div id="Calabria" onmouseleave="hidedisplay(this)"> 

<img src="data:image/jpg;base64,<%=ricette[5].getBase64Image()%>"><br><br>

<h2 class="nomericetta"> <%=ricette[5].getTitolo()%> </h2>

<p class="descrizione"> 
<%int posCalabria=ricette[5].getDescrizione().indexOf("Procedimento");
String appoggio5= ricette[5].getDescrizione().substring(0, posCalabria);%>
<%=appoggio5%>
</p>

 <a href="FinalRicettaServlet?Ricetta=<%=ricette[5].getTitolo()%>">
<button id="calabresi"> Continua la lettura
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[5].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a>
</div>

<br> <br> <br> <br> <br>

<img id="imgSicilia" src="Immagini/Sicilia.png"> 
<span class="titolo dispari" onmouseover="showdisplay('#Sicilia')"> Ricette siciliane </span>
<div id="Sicilia" onmouseleave="hidedisplay(this)"> 

<img src="data:image/jpg;base64,<%=ricette[6].getBase64Image()%>"> <br><br>

<h2 class="nomericetta"> <%=ricette[6].getTitolo()%> </h2>


<p class="descrizione">
<%int posSicilia=ricette[6].getDescrizione().indexOf("Procedimento");
String appoggio6= ricette[6].getDescrizione().substring(0, posSicilia);%>
<%=appoggio6%>
</p>

 <a href="FinalRicettaServlet?Ricetta=<%=ricette[6].getTitolo()%>">
<button id="siciliane"> Continua la lettura 
<img src="Immagini/Arrow.png"> </button> </a>
<br> <br> 
<a href="ProvServlet?Provenienza=<%=ricette[6].getProvenienza()%>">
<button id="molisane"> Vedi altre ricette 
<img src="Immagini/Arrow.png"> </button> </a> <br> <br> <br>
</div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> 

<script>

function showdisplay(nome) {
	$(nome).show(250);
}

function hidedisplay(param) {
	$("#"+param.id).hide(500);
}
</script>


</body>
</html>
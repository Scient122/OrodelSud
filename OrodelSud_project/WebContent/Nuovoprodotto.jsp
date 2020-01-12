<%@page import="Bean.AziendaBean"%>
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
<link rel="stylesheet" href="Css/NuovoProdotto.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Aggiunta di un prodotto </title>
</head>

<body>
<jsp:include page="Header.jsp"/> 
<%@page import="Model.*" %>
<%@page import="java.util.*" %>

<%if ((session.getAttribute("adminBean")==null) && (session.getAttribute("aziendaBean")==null))
	response.sendRedirect("Login.jsp");
%>
<%
	if((session.getAttribute("adminBean")!=null)) {
	Bean.AdminBean admin = (Bean.AdminBean) session.getAttribute("adminBean"); 
}
if (session.getAttribute("aziendaBean")!=null) {
	Bean.AziendaBean azienda = (Bean.AziendaBean) session.getAttribute("aziendaBean");
}
%>

<div id="divgeneralepannello">
<h1 id="titoloareapersonale"> Aggiungi un nuovo prodotto! </h1>
<br> <br>

<form method="post" action="AggiungiProdottoServlet" id="formareapersonale" onchange="control()" enctype="multipart/form-data"> 
<span>- Nome prodotto: </span><br>
<span class="modifcaspan" id="spanemail"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" id="inputnome" name="nome" type="text" onblur="allLetter(this)"> <span id="nome"></span>
<br> <br>

<span>- Descrizione: </span> <br>
<span class="modifcaspan"> Inserisci i nuovi dati </span> <br>
<textarea class="inputtextarea" rows="5" cols="60" name="descrizione"></textarea><span id="descrizione"></span>
<br> <br>

<span>- Prezzo base: </span><br>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="prezzobase" type="number" step="0.1" onblur="allNumbers(this)"> <span id="prezzobase"></span>
<br> <br>

<span>- Quantit&agrave; disponibili: </span><br>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="quantitadisponibili" type="number" onblur="allNumbers(this)"> <span id="quantitadisponibili"></span>
<br> <br>

<span>- Iva: </span> <br>
<span class="modificaspan"> Inserisci i nuovi dati </span>
<input class="inputtextarea" name="cambioiva" type="number"> <span id="quantitadisponibili"></span>
<br> <br>

<span>- Conservazione: </span><br>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="conservazione" type="text"> <span id="conservazione"></span>
<br> <br>

<span>- Categoria: </span> <br>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="categoria" type="text" onblur="allLetter(this)"> <span id="categoria"></span>
<br> <br>

<span>- Immagine: </span> <br>
<span class="modifcaspan"> Inserisci una nuova immagine </span> 
<input class="inputtextarea" name="immagine" type="file" accept="image/jpg, image/png, image/jpeg"> <span id="immagine"></span>
<br> <br>

<br> <br>
<div id="divbottoniareapersonale"> 
<button class="modificabutton" id="modificadati" type="button" onclick="showdiv()"> Modifica i tuoi dati </button> 
<button class="modificabutton" id="pulsantechedeveuscire" onclick="document.location='AggiungiProdottoServlet'">Conferma</button>
</div>
<br> <br>
</form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>


<script>

function showdiv() {
	$(".inputtextarea").show();
	$(".modifcaspan").show();
	return false;
}
</script>

<script> 

function allLetter(uname)  {   
var letters = /^[A-Za-z]+$/; 
var prova;

if(uname.value.match(letters) && (uname.value!=""))  
{  
	prova=document.getElementById(uname.name);
	prova.innerHTML="";
return true;  

}  

else  
{  
	prova=document.getElementById(uname.name);
	prova.innerHTML="Errore";
	
uname.focus();  
return false;  
}  
}
</script> 
<script>
function allNumbers(uname){
	var numbers= /^[-+]?\d+(.\d+)?$/;
	var prova;
	if(uname.value.match(numbers) && (uname.value!="")){
		prova=document.getElementById(uname.name);
		prova.innerHTML="";
		return true;
	}
	
	else{
		
		prova=document.getElementById(uname.name);
		prova.innerHTML="Errore";
		uname.focus();  
		return false;
	}
}
</script>
<script>
function control(){
	var elementi=document.getElementsByTagName("input");
	var bottone=document.getElementById("pulsantechedeveuscire");
	

		if(allLetter(elementi[8])&&allNumbers(elementi[9])&&allNumbers(elementi[10])&&allLetter(elementi[13])) {
			$("#pulsantechedeveuscire").show();
		}
	else{
		$("#pulsantechedeveuscire").hide();
	}
}
</script>

</body>
</html>
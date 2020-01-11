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
<link rel="stylesheet" href="Css/Areapersonale.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Area personale </title>
</head>
<body>
<jsp:include page="Header.jsp"/> 

<%if ((session.getAttribute("adminBean")==null) && (session.getAttribute("userBean")==null) && (session.getAttribute("aziendaBean")==null))
	response.sendRedirect("Login.jsp");	
%>

<%
	if((session.getAttribute("adminBean")!=null)) {
	Bean.AdminBean admin = (Bean.AdminBean) session.getAttribute("adminBean"); 
}
else if (session.getAttribute("clienteBean")!=null){
	Bean.ClienteBean cliente = (Bean.ClienteBean) session.getAttribute("userBean");
} else {
	Bean.AziendaBean azienda = (Bean.AziendaBean) session.getAttribute("aziendaBean");
}
%>
<% if (session.getAttribute("aziendaBean")!= null) {  %>
<input type="hidden" name="accesso" value="azienda" id="accesso">
<% } %>
<aside id="asidepersonale"> 
<ul id="ulaside"> 
<% if(session.getAttribute("userBean")!=null && session.getAttribute("aziendaBean")==null) { %>
<li id="ituoirdini"> <a href="FatturaServlet"> I tuoi ordini </a> </li>
<% } %>
<% if(session.getAttribute("adminBean")!=null || session.getAttribute("aziendaBean")!=null){ %>
<li id="pannellodicontrollo"> Pannello di controllo
<div id="menucontrollopannello"> 
<ul> 
	<li> <a href="ProdottoServlet?admin=yes"> Aggiorna il catalogo </a> </li>
	<% if (session.getAttribute("aziendaBean")==null) { %>
	<li> <a href="Visualizzagliordini.jsp"> Visualizza gli ordini </a> </li>
	<% } %>
	<li> <a href="Nuovoprodotto.jsp"> Aggiungi un nuovo prodotto </a> </li>
</ul>
</div> 
</li>
<% } %>
<% if (session.getAttribute("userBean")!=null) { %>
<li id="metodipagemento"> <a href="Pagamento.jsp"> Metodi di pagamento</a> </li>
<% } %>
<li id="logout"><a href="LogoutServlet"> Logout </a> </li>
</ul>
</aside>

<div id="divgeneralepannello"> 
<h1 id="titoloareapersonale"> Benvenuto nella tua area personale! </h1>
<br> <br>

<form method="post" action="UpdateServlet" id="formareapersonale" onchange="control()"> 
<span>- Email: ${userBean.email} ${adminBean.email} ${aziendaBean.email}</span>
<span class="modifcaspan" id="spanemail"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" id="inputemail" name="email" type="email" onblur="ValidateEmail(this)"> <span id="email"></span>
<br> <br>

<span>- Password: <button class="modificabutton" id="mostrabutton" onclick="mostrapassword($(this))"> Mostra </button> </span> 
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="password" type="password" onblur="pass(this)"><span id="password"></span>
<br> <br>

<span>- Nome: ${userBean.nome} ${adminBean.nome} ${aziendaBean.nome}</span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="nome" type="text" onblur="allLetter(this)"> <span id="nome"></span>
<br> <br>
<% if (session.getAttribute("aziendaBean") == null) { %>
<span>- Cognome: ${userBean.cognome} ${adminBean.cognome} </span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="cognome" type="text" onblur="allLetter(this)"> <span id="cognome"></span>
<br> <br>
<% } %>
<span>- Citt&agrave;: ${userBean.citta} ${adminBean.citta} ${aziendaBean.citta}</span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="citta" type="text" onblur="allLetter(this)"> <span id="citta"></span>
<br> <br>

<span>- Via: ${userBean.via} ${adminBean.via} ${aziendaBean.via}</span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="via" type="text" onblur="allLetter(this)"> <span id="via"></span>
<br> <br>

<span>- Cap: ${userBean.cap} ${adminBean.cap} ${aziendaBean.cap}</span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="cap" type="text" onblur="allNumbers(this)"> <span id="cap"></span>
<br> <br>

<span>- Numero civico: ${userBean.numero_civico} ${adminBean.numero_civico} ${aziendaBean.numero_civico}</span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="numero_civico" type="text" onblur="allNumbers(this)"> <span id="numero_civico"></span>
<br> <br>
<% if (session.getAttribute("aziendaBean") ==null) { %>
<span>- Data di nascita: ${userBean.data_di_nascita} ${adminBean.data_di_nascita} </span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="data_di_nascita" type="date"> <span id="data_di_nascita"></span>
<br> <br>
<% } %>
<span>- Numero di telefono: ${userBean.numero_di_telefono} ${adminBean.numero_di_telefono} ${aziendaBean.numero_di_telefono} </span>
<span class="modifcaspan"> Inserisci i nuovi dati </span> 
<input class="inputtextarea" name="numero_di_telefono" type="tel" onblur="telephone(this)"> <span id="ntelefono"></span>
<br> <br>

<% if (session.getAttribute("userBean") != null) { %>
<span>- Punti ottenuti: ${userBean.punti} </span> 
<br> <br>
<% } %>

<div id="divbottoniareapersonale"> 
<button class="modificabutton" id="modificadati" type="button" onclick="showdiv()"> Modifica i tuoi dati </button> 
<button class="modificabutton" id="confermabottonearea">Conferma</button>
</div>
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
function mostrapassword(button) {
	button.parent().html("- Password: ${adminBean.password}${userBean.password}${aziendaBean.password}");	
}

</script>


<script>

function ValidateEmail(uemail) {
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
var prova = document.getElementById("email");
if(uemail.value.match(mailformat)|| uemail.value=="") {
	prova.innerHTML="";
	check(uemail.value);
		return true;
	
}

else
{
email.innerHTML="Errore";
uemail.focus();
return false;
}
}

function allLetter(uname)  
{   
var letters = /^[A-Za-z]+$/; 
var prova;
if(uname.value.match(letters) || (uname.value==""))  
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

function allNumbers(uname){
	
	var numbers= /^[0-9]+$/;
	var prova;
	if(uname.value.match(numbers) || (uname.value=="")){
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

function telephone(uname){
	
	var corto= /^\d{10}$/;
	var lungo= /^\(([0-9]{3})\)?[-. ] ([0-9]{3})?[-. ]([0-9]{4})$/;
	var prova;
	if(uname.value.match(corto)||uname.value.match(lungo)||uname.value==""){
		prova=document.getElementById("ntelefono");
		prova.innerHTML="";
		return true;
	}
	
	else{
		
		prova=document.getElementById("ntelefono");
		prova.innerHTML="Errore";
		uname.focus();  
		return false;
	}
}

</script>

<script>
function pass(uname){
	var prova=document.getElementById(uname.name);
	var espressione= /[0-9]/g;
	if((uname.value.match(espressione)&&uname.value.length>5)|| uname.value=="") {
		prova.innerHTML="";
		return true;
	}
	
	else if(uname.value.length<6){
		prova.innerHTML="Troppo corta!";
		return false;	
	}
	else{
		prova.style.fontSize="55%;";
		prova.innerHTML="Usare un numero!";
		return false;
	}

}

</script>

<script>

function control(){
	var elementi=document.getElementsByTagName("input");
	var accesso=document.getElementById("accesso");
	var bottone=document.getElementById("confermabottonearea");
		if (accesso == null) {
		if (ValidateEmail(elementi[8])&&pass(elementi[9])&&allLetter(elementi[10])&&allLetter(elementi[11])&&allLetter(elementi[12])&&allLetter(elementi[13])&&allNumbers(elementi[14])&&allNumbers(elementi[15])&&telephone(elementi[17])) {
			bottone.style.display="inline";
		}
	else{
		bottone.style.display="none";
	}
		} else {
			
			if(ValidateEmail(elementi[9])&&pass(elementi[10])&&allLetter(elementi[11])&&allLetter(elementi[12])&&allLetter(elementi[13])&&allNumbers(elementi[14])&&allNumbers(elementi[15])&&telephone(elementi[16])) {
				bottone.style.display="inline"; 
			}
		else{
			bottone.style.display="none";
		}
}
}
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

<script>
function check(email){
	$.post("CheckServlet",email,function(data,status,ris){

		if(data.charAt(0)=='N'&&data.charAt(1)=='o'){
			document.getElementById("email").innerHTML="Già usata!";
			document.getElementById("confermabottonearea").style.display="none";
		}
		else
			document.getElementById("email").innerHTML="";	
	})

}
</script>

<jsp:include page="Footer.jsp"/> 

</body>
</html>
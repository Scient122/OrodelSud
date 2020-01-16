<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Registrazione </title>
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Registrazione.css">
<link rel="icon" href="Immagini/Iconlogo.png">

</head>
<body>

<%
if(session.getAttribute("userBean")!=null||session.getAttribute("adminBean")!=null||session.getAttribute("aziendaBean")!=null)
 response.sendRedirect("LoginSucessfull.jsp");
%>

 
<div id="benvenuto">
<a href="index.jsp"> 
<img src="Immagini/Logoazzurrotagliato.png">
</a>
<h2 id="h2"> Benvenuto, crea un account</h2>
</div>

<form action="RegistrationServlet" method="post" id="foform" onchange="control()">
<label for="scritte"> Email: </label>
<span id="email" class="span"> </span> 
<input id="scritte" type="email" name="email" placeholder="Email" maxlength="30" required onblur="ValidateEmail(this)">
<br> 
<label> Password: </label> 
<span id="password" class="span"> </span>
<input id="scritte" type="password" name="password" placeholder="Password" maxlength="40" required onblur="pass(this)">
<br> 
<label> Nome: </label> 
<span id="nome" class="span"> </span>
<input id="scritte" type="text" name="nome" placeholder="Nome" maxlength="20" required onblur="allLetter(this)">
<br> 
<label> Cognome: </label> 
<span id="cognome" class="span"> </span>
<input id="scritte" type="text" name="cognome" placeholder="Cognome" maxlength="20" required onblur="allLetter(this)">
<br> 
<label> Città: </label>
<span id="citta" class="span"></span>
<input id="scritte" type="text" name="citta" placeholder="Città" maxlength="30" required onblur="allLetter(this)">
<br>
<label> Via: </label> 
<span id="via" class="span"> </span>
<input id="scritte" type="text" name="via" placeholder="Via" maxlength="30" required onblur="allLetter(this)">
<br> 
<label> Cap: </label>
<span id="cap" class="span"> </span> 
<input id="scritte" type="text" name="cap" placeholder="Cap" maxlength="10" required onblur="allNumbers(this)">
<span id="cap" class="span"> </span>
<br> 
<label> Numero civico: </label> 
<span id="ncivico" class="span"></span>
<input id="scritte" type="text" name="ncivico" placeholder="#civico" maxlength="5" required onblur="allNumbers(this)">
<br> 
<label> Data di nascita: </label> 
<span id="datanascita" class="span"></span>
<input id="scritte" type="date" name="datanascita" placeholder="Data di nascita" required>
<br> 
<label> Numero di telefono: </label> 
<span id="ntelefono" class="span"></span>
<input id="scritte" type="text" name="ntelefono" placeholder="Numero di telefono" maxlength="10" onblur="telephone(this)" required>
<br> 
<div id="pulsanti">
<input id="bottone" type="submit" value="Iscriviti">
<input id="bottone1" type="reset" value="Azzera">
</div>
</form>

<script>

function ValidateEmail(uemail) {
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
var prova = document.getElementById("email");
if(uemail.value.match(mailformat)&&uemail.value!="") {
	prova.innerHTML="";
	check(uemail.value);
		return true;
	
}
else if(uemail.value==""){
	prova.innerHTML="Campo obbligatorio!";
	return false;
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
if(uname.value.match(letters)&&uname.value!="")  
{  
	prova=document.getElementById(uname.name);
	prova.innerHTML="";
return true;  

}  

else if(uname.value==""){
	
	prova=document.getElementById(uname.name);
	prova.innerHTML="Campo obbligatorio!";
	return false;
	
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
	if(uname.value.match(numbers)&&uname.value!=""){
		prova=document.getElementById(uname.name);
		prova.innerHTML="";
		return true;
	}
	
	else if(uname.value==""){
		prova=document.getElementById(uname.name);
		prova.innerHTML="Campo obbligatorio!"
		return false;
	}
	else{
		
		prova=document.getElementById(uname.name);
		prova.innerHTML="Errore";
		return false;
	}
}

function telephone(uname){
	
	var corto= /^\d{10}$/;
	var lungo= /^\(([0-9]{3})\)?[-. ] ([0-9]{3})?[-. ]([0-9]{4})$/;
	var prova;
	if(uname.value.match(corto)||uname.value.match(lungo)){
		prova=document.getElementById(uname.name);
		prova.innerHTML="";
		return true;
	}
	
	else{
		
		prova=document.getElementById(uname.name);
		prova.innerHTML="Errore";
		return false;
	}
}

</script>
<script>
function pass(uname){
	var prova=document.getElementById(uname.name);
	var espressione= /[0-9]/g;
	if(uname.value.match(espressione)&&uname.value.length>5){
		prova.innerHTML="";
		return true;
	}
	
	else if(uname.value.length==0){
		prova.innerHTML="Campo obbligatorio!";
		return false;
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

function control(){
	
	var elementi=document.getElementsByTagName("input");
	var bottone=document.getElementById("bottone");
	if(ValidateEmail(elementi[0])&&pass(elementi[1])&&allLetter(elementi[2])&&allLetter(elementi[3])&&allLetter(elementi[4])&&allLetter(elementi[5])&&allNumbers(elementi[6])&&allNumbers(elementi[7])&&telephone(elementi[9])&&elementi[8].value!="")
		bottone.style.display="inline";
	else
		bottone.style.display="none";
		
	
	
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script>
function check(email){
	$.post("CheckServlet",email,function(data,status,ris){
		
		if(data.charAt(0)=='N'&&data.charAt(1)=='o'){
			document.getElementById("email").innerHTML="Già usata!";
			document.getElementById("bottone").style.display="none";
		}
		else
			document.getElementById("email").innerHTML="";	
	})
}

</script>
</body>
</html>
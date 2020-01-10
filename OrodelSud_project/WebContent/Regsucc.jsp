<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Regsucc.css">
<link href='https://fonts.googleapis.com/css?family=Charm' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Calligraffitti' rel='stylesheet'>
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Registrazione completata! </title>
</head>
<body>

<div id="ddiv">
<p id="uno"> Registrazione effettuata con successo! </p> <br> <br> <br>
<button type="submit" id="index" class="bottone" onclick="Redirect(this)"> Torna alla home </button>
<button type="submit" id="Login" class="bottone" onclick="Redirect(this)"> Accedi alla pagina </button>
</div>

<div>
<a href="index.jsp"> 
<img id="logo" src="Immagini/Logoazzurrotagliato.png" alt="Logo del sito">
</a>
</div>
<script>
function Redirect(a) {
	document.location=a.id+'.jsp';
}
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Lfailed.css">
<link rel="icon" href="Immagini/Iconlogo.png">
<link href='https://fonts.googleapis.com/css?family=Cutive Mono' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Acme' rel='stylesheet'>

<title>Errore nel log-in!</title>
</head>
<body>

<jsp:include page="Header.jsp" />

<div id="ddiv">
<p align="center" id="Err">Errore nel log-in!</p> <br>
<p id="testo"> Ci dispiace, c'è stato un errore durante il suo tentativo di accesso. <br> 
La invitiamo a riprovare. </p>
<button type="submit" id="index" onclick="Redirect(this)"> Torna alla home </button>
</div>

<script>
function Redirect(a) {
	document.location=a.id+'.jsp';
}
</script>

</body>
</html>
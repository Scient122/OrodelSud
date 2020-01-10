<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Css/Reset.css">
<link href='https://fonts.googleapis.com/css?family=Arizonia' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Autour One' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=BioRhyme' rel='stylesheet'>
<link rel="stylesheet" href="Css/Login.css">
<link rel="icon" href="Immagini/Iconlogo.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

<title>Accedi alla nostra pagina!</title>
</head>
<body>

<%
if(session.getAttribute("userBean")!=null || session.getAttribute("adminBean")!=null || session.getAttribute("aziendaBean")!=null)
	response.sendRedirect("Areapersonale.jsp");
%>



<div id="login" align="center">
<a href="Index.jsp">
<img id="immagine" src="Immagini/Logoazzurrotagliato.png"> <br><br><br><br><br>
</a>
<h1 id="h1">Login</h1>
<br><br>
<form action="LoginServlet" method="post">

<label>E-mail</label> <br>
<input class="input" type="email" name="email" placeholder="Inserisci la tua e-mail" required>
<br><br><br><br>
<label>Password</label> <br>
<input class="input" type="password" name="password" placeholder="Inserisci la tua password" required>
<br> <br> <br>

<input id="bottone" type="submit" value="Accedi">

</form>
</div>


</body>
</html>
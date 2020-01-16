<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Registrazione </title>
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Registrationtype.css">
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
<h2 id="h2"> Benvenuto! Scegli la tipologia di account:</h2>

<div id="divtype">
 <button class="bottonetype" > <a href="RegistrationAzienda.jsp"> Azienda </a> </button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button class="bottonetype" ><a href="Registration.jsp"> Cliente </a> </button> 
</div>

</div>

</body>
</html>
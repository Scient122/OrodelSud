<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Advent Pro' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Galada' rel='stylesheet'>
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Categoriaricetta.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Ricette per categoria </title>
</head>
<body>
<%@page import="Model.*" %>
<%@page import="Bean.*" %>
<%@page import="java.util.*" %>
<% ArrayList<RicettaBean> ricette = (ArrayList<RicettaBean>) request.getAttribute("ricette");%>

<jsp:include page="Header.jsp"/>

<% for (int i=0; i<ricette.size(); i++) {
%>

<div id="Ricetta">

<h1 id="h1"> <%=ricette.get(i).getTitolo()%></h1>
<br>
<img src="data:image/jpg;base64,<%=ricette.get(i).getBase64Image()%>"><br><br>

<p> <%int pos=ricette.get(i).getDescrizione().indexOf("Procedimento");
String appoggio= ricette.get(i).getDescrizione().substring(0, pos);%>
<%=appoggio%></p>

<a href="FinalRicettaServlet?Ricetta=<%=ricette.get(i).getTitolo()%>"> 
<button> Continua a leggere <img src="Immagini/Arrow.png"></button> </a>

<br> <br> <br> <br>
</div>

<% } %> 


<jsp:include page="Footer.jsp"/>

</body>
</html>
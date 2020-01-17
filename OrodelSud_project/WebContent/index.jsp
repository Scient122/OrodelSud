<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Doppio+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Merienda+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Hammersmith+One&display=swap" rel="stylesheet">

<link rel="icon" href="Immagini/Iconlogo.png">
<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Index.css">

<meta charset="ISO-8859-1">
<title> OroDelSud </title>
</head>
<body>

<%@page import="Connection.*" %>
<%@page import="Bean.*" %>
<%@page import="java.util.*" %>
  
<% 
if (session.getAttribute("oggetti")==null) {
	response.sendRedirect("IndexServlet");
	return;
}
ArrayList<Object> oggetti = (ArrayList<Object>) session.getAttribute("oggetti");
RicettaBean ricetta1 = null;
RicettaBean ricetta2 = null;
RicettaBean ricetta3 = null;
ricetta1 = new RicettaBean();
ricetta2 = new RicettaBean();
ricetta3 = new RicettaBean();
ricetta1 = (RicettaBean) oggetti.get(6);
ricetta2 = (RicettaBean) oggetti.get(7);
ricetta3 = (RicettaBean) oggetti.get(8);
ProdottoBean prodotto1 = null;
ProdottoBean prodotto2 = null;
ProdottoBean prodotto3 = null;
prodotto1 = new ProdottoBean();
prodotto2 = new ProdottoBean();
prodotto3 = new ProdottoBean();
prodotto1 = (ProdottoBean) oggetti.get(3);
prodotto2 = (ProdottoBean) oggetti.get(4);
prodotto3 = (ProdottoBean) oggetti.get(5);

%>

<jsp:include page="Header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>



<div id="Contenitoreindex">

	<aside id="asideindexsx"> 
	
		<p id="titoloasidesx"> Visita le nostre ricette! </p> <br> <br>
	
		<div> 
			<p> <%=ricetta1.getTitolo()%> </p> <br>
			<img src="data:image/jpg;base64,<%=ricetta1.getBase64Image()%>"><br><br>
		</div>
		
		<div> 
			<p> <%=ricetta2.getTitolo()%> </p> <br>
			<img src="data:image/jpg;base64,<%=ricetta2.getBase64Image()%>"><br><br>
		</div>
		
		<div>
			<p> <%=ricetta3.getTitolo()%> </p> <br>
			<img src="data:image/jpg;base64,<%=ricetta3.getBase64Image()%>"><br><br>
		</div>
	 
	</aside>

<div id="indexcentrale"> 
	<p id="titoloindex"> Benvenuto in OrodelSud! </p>
	<img id="immaginecentrale" src="Immagini/ImmagineIndex.png">
</div>


<div id="asideindexdx">

	<p id="titoloasidesx"> Visita i nostri prodotti in offerta! </p> <br> <br>
	
	<div> 
	<p> <%=prodotto1.getNome_prodotto()%> </p> <br>
	<img src="data:image/jpg;base64,<%=prodotto1.getBase64Image()%>"><br><br>
	</div>
	
	<div> 
	<p> <%=prodotto2.getNome_prodotto()%> </p> <br>
	<img src="data:image/jpg;base64,<%=prodotto2.getBase64Image()%>"><br><br>
	</div>
	
	<div>
	<p> <%=prodotto3.getNome_prodotto()%> </p> <br>
	<img src="data:image/jpg;base64,<%=prodotto3.getBase64Image()%>"><br><br>
	</div>

</div>
</div>

<script> 
		$("#immaginecentrale, #titoloindex").hide();
		$("#immaginecentrale, #titoloindex").fadeIn(2000);
		$("#immaginecentrale").animate({width: '80%', height: '80%'}, {duration: 1000, queue: false });
		$("#titoloindex").animate({fontSize: '200%'}, {duration: 1000, queue: false});

</script>

<jsp:include page="Footer.jsp"/>


</body>
</html>
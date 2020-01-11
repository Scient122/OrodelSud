<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">


<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/Conferma.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> Conferma </title>
</head>
<body onload="check()">
<jsp:include page="Header.jsp"/>

<%@page import="Model.*" %>
<%@page import="Bean.*" %>
<%@page import="java.util.*" %>

<%
Gestione_catalogo.Carrello carrello = (Gestione_catalogo.Carrello) session.getAttribute("carrello");
if ((session.getAttribute("adminBean")==null) && (session.getAttribute("userBean")==null))
	response.sendRedirect("Login.jsp");
else if (carrello==null)
	response.sendRedirect("ProdottoServlet");
else if (carrello.size()==0) 
	response.sendRedirect("ProdottoServlet");

Bean.ClienteBean cliente = (Bean.ClienteBean) session.getAttribute("userBean");

if (cliente.getCarte_credito().size()==0) {
%>
	<p id="nientecarte"> Non possiedi carte di credito. Aggiungine una per acquistare andando all&apos;<a href="Pagamento.jsp">area personale</a>! </p>
<%
}
%>

<div id="megacontenitore">

<div id="informazioniconfermadiv">
 
<span>
Acquirente: <%=cliente.getNome()%> <%=cliente.getCognome()%><br>
Indirizzo: <%=cliente.getCitta()%> <%=cliente.getCap()%> <%=cliente.getVia()%> <%=cliente.getNumero_civico()%>
</span>
<br> <br> <br>
<span>
Scegli il metodo di pagamento: <br> <br> 
<form method="post" action="ConfermaServlet">
<ul>
<% HashMap <String, String> carte = cliente.getCarte_credito(); 
Set <String> numeri = carte.keySet();
for(String s: numeri) { %>
<div>
<li>
- Numero carta: <%=s%> <br>
- Tipologia carta: <%=carte.get(s) %> 
<input type="radio" value="Utilizza" name="tipologiacartaconferma"> <br>
</li> <br> <br>
</div>
<% } %>
<% 
double ptotale = 0;
Set <ProdottoBean> prodotti= carrello.getprodotti();
for (ProdottoBean p :prodotti) {
	ptotale=ptotale+p.getPrezzo_totale()*carrello.getquantita(p);
}
if (cliente.getPunti()>= ptotale) { %>
<li> Seleziona se desideri pagare con i punti:
<input type="radio" value="Pagapunti" name="tipologiacartaconferma"> <br> </li>
<% }
else { %>
<p> Non possiedi abbastanza punti con cui pagare. </p>
<% } %>
</ul>
<br>
<button type="submit" class="bottoneacquista"> Acquista </button>
<br>
</form>
</span>
</div>

</div>


<jsp:include page="Footer.jsp"/>

<script>

function check (){
	var elemento = document.getElementsByName("tipologiacartaconferma");
	elemento[0].checked = true;
}

</script>

</body>
</html>
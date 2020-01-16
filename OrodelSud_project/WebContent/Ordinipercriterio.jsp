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
<link rel="stylesheet" href="Css/Ordini.css">
<link rel="icon" href="Immagini/Iconlogo.png">

<title> I tuoi ordini </title>
</head>

<body>
<jsp:include page="Header.jsp"/> 
<%@page import="Model.*" %>
<%@page import="Bean.*" %>
<%@page import="java.util.*" %>


<%
	HashMap<FatturaBean, ArrayList<ComposizioneBean>> fattura = (HashMap<FatturaBean, ArrayList<ComposizioneBean>>) request.getAttribute("fattura");
Set<FatturaBean> fatture = fattura.keySet();
Bean.ClienteBean cliente = null;
Bean.AdminBean admin;
if ((session.getAttribute("adminBean")==null))
	response.sendRedirect("Login.jsp");
%>

<%
	if((session.getAttribute("adminBean")!=null)) {
	admin = (Bean.AdminBean) session.getAttribute("adminBean"); 
}  
else {
	 cliente = (Bean.ClienteBean) session.getAttribute("userBean");
}
%>



<div id="divgeneralepannello"> 
<h1 id="titoloareapersonale"> Ricerca degli ordini </h1>
<br> <br>


<br> <br>
<div id="divfatturegigante">
<% for (FatturaBean f: fatture) { %> 

<div class="divdelletabelle">  
<table class="tabellafattura"> 

<tr> 
	<td>Intestazione fattura: <br>
	Generalit&agrave;: <%=f.getDestinatario()%> <br>
	Indirizzo: <%=f.getVia()%> <br>
	</td>
	<td>
	Luogo di destinazione: <br>
	Generalit&agrave;: <%=f.getDestinatario()%> <br>
	Indirizzo: <%=f.getVia()%> <br>
	</td>
	<td> </td>
	<td> </td>
	<td> <img src="Immagini/Logoazzurrotagliato.png"> </td>
	
<tr>
	<td>Numero fattura: <br>
	<%=f.getN_documento()%>
	</td>
	<td>Data fattura: <br>
	<%=f.getData()%>
	</td>
	<td>Modalit&agrave; di pagamento: <br>
	120 giorni fine mese
	</td>
	<td> Stato ordine: <br> <%=f.getStatus()%></td>
	<td> </td>
</tr>

<tr> 
	<td class="tdgrassetto bordodiverso"> Descrizione 
	</td>
	<td class="tdgrassetto bordodiverso"> Quantit&agrave;
	</td>
	<td class="tdgrassetto"> Costo imponibile unitario
	</td>
	<td class="tdgrassetto"> Importo IVA 
	</td>
	<td class="tdgrassetto"> Aliquota IVA 
	</td>
</tr>

<% for(ComposizioneBean comp : fattura.get(f)) { %>

<tr> 
	<td class="bordodiverso"> 
	<%=comp.getNome_prodotto()%>
	</td>
	<td class="bordodiverso"> 
	<%=comp.getQuantita_acquistate()%>
	</td>
	<td> 
	<%=String.format("%.2f", (comp.getPrezzo_acquisto()*100)/122)%>
	</td>
	<td> 
	<%=String.format("%.2f", comp.getPrezzo_acquisto()-(comp.getPrezzo_acquisto()*100)/122)%>
	</td>
	<td> 
	<%=comp.getIva_acquisto()%>
	</td>
</tr>	
<% } %>
<tr>
	<td> </td>
	<td> </td>
	<td>Totale imponibile: <%=String.format("%.2f", f.getTotale_imponibile())%>&euro;</td>
	<td>Totale imposta: <%=String.format("%.2f",f.getTotale_imposta())%>&euro;</td>
	<td>Totale fattura: <%=String.format("%.2f",f.getCosto_totale())%>&euro;</td>
</tr>
</table> <br> <br> <br> <br>
</div>

<%  } %> <br> <br>
</div>

</div>
</body>
</html>
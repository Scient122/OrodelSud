<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="width=device-width, user-scalable=no,
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Comfortaa&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Inconsolata&display=swap" rel="stylesheet">
<link rel="icon" href="Immagini/Iconlogo.png">

<link rel="stylesheet" href="Css/Reset.css">
<link rel="stylesheet" href="Css/AggiornaCatalogo.css">
<title> Pannello di controllo </title>
</head>

<body>
<%@page import="Connection.*" %>
<%@page import="java.util.*" %>
<% if ((session.getAttribute("adminBean")==null) && (session.getAttribute("aziendaBean")==null))
	response.sendRedirect("Login.jsp");%>

<div id="contenitoreaggiornacatalogo">


<%@page import="Bean.*" %>
<%@page import="java.util.*" %>
<%if (session.getAttribute("carrello")==null) {
	Gestione_catalogo.Carrello carrello = new Gestione_catalogo.Carrello();
	session.setAttribute("carrello", carrello);
} %>
<input type="hidden" name="count" value="1">
<script> var collezione =1 </script>
<%
int contatore= (int) request.getAttribute("contatore"); 
ArrayList<ProdottoBean> prodotti = (ArrayList<ProdottoBean>) request.getAttribute("Prodotti");
%>


<jsp:include page="Header.jsp"/> 

<div id="Contenitore"> 

<% for (int i=0; i<prodotti.size(); i++) {
%>

<div id="Prodotto">

<hr>

<h1 id="h1"><%=prodotti.get(i).getNome_prodotto()%></h1>
<br>

<p id="informazioni"> 

<img src="data:image/jpg;base64,<%=prodotti.get(i).getBase64Image()%>">

<p id="infotesto" class="infotesti">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: <%= prodotti.get(i).getPrezzo_base()%>&euro; <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: <%= prodotti.get(i).getQuantita_disponibili() %>
</p>
</p>
<button class="bottonechecancella"> <img id="immaginetrash" src="Immagini/Trash.png"> </button>
<button class="bottonechemodifica"> <img id="immaginegear" src="Immagini/Gear.png"> </button>

<br> <br> <br> <br>

</div>
<%  } %>
</div>

<div id="divbottoni"> 


<% boolean Altri = (boolean) request.getAttribute("Altri"); 
if(Altri==true) { %>

<a>
<button id="prodottobottone" class="avanti" onclick="Avanti(this, parseInt(document.getElementsByName('count')[0].value), collezione)"> Avanti 
<img src="Immagini/Arrowtagliata.png"> </button></a> 
<% } %>




<a>
<button id="prodottobottone" class="indietro" onclick="indietro(this, parseInt(document.getElementsByName('count')[0].value), collezione)">
<img id="left" src="Immagini/Arrowleft.png"> Indietro
 </button></a> 

<br>
</div>
<br>
</div>
<jsp:include page="Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>

<script> 

function Avanti (button, contatore, collezione) {
	var json={"Messaggio":"Avanti","Contatore":contatore};
	document.getElementsByName("count")[0].value = parseInt(document.getElementsByName("count")[0].value)+1;
	json = JSON.stringify(json);
	$.ajax({type:'POST',
			url:'ProdottoServlet',
			data:{
				'informazioni':json
				 },
			success: function (data,status) {
				var risposta=JSON.parse(data);
				var prodotti=risposta.Prodotti;
				collezione=risposta.Prodotti;
				var i=0;
				var j=0;
				showing(risposta.Contatore, risposta.Altri);
				
				
				while (i<5 && i<prodotti.length) {
					$("h1").eq(i).html(prodotti[i].nome_prodotto);
					$(".infotesti").eq(i).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: "+prodotti[i].prezzo_base+"&euro;"+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: "+prodotti[i].quantita_disponibili);
					$("#informazioni img").eq(i).attr("src", "data:image/jpg;base64,"+prodotti[i].base64Image);
					i++;
				}
				while(i<5) {
					$("#Contenitore div").eq(i).hide();
					i++;
				}
					
					
			}
		});
	}
</script>
<script>
function showing (contatore, altri) {
	if (altri==false) 
		$(".avanti").hide(0);
	else
		$(".avanti").show(0);
	
	if (contatore==1) 
		$(".indietro").hide(0);
		else
			$(".indietro").show(0);
	}
</script>
	
<script>
	function indietro (button, contatore, collezione) {
		var json={"Messaggio":"Indietro","Contatore":contatore};
		document.getElementsByName("count")[0].value = parseInt(document.getElementsByName("count")[0].value)-1;
		json = JSON.stringify(json);
		$.ajax({type:'POST',
				url:'ProdottoServlet',
				data:{
					'informazioni':json
					 },
				success: function (data,status) {
					var risposta=JSON.parse(data);
					var prodotti=risposta.Prodotti;
					collezione=risposta.Prodotti;
					var i=0;
					var j=0;
					showing(risposta.Contatore, risposta.Altri);
					
					while (j<5) {
						$("#Contenitore div").eq(j).show(0);
						j++;
					}
					
					while (i<5 && i<prodotti.length) {
						$("h1").eq(i).html(prodotti[i].nome_prodotto);
						$(".infotesti").eq(i).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prezzo: "+prodotti[i].prezzo_base+"&euro;"+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantit&agrave; disponibili: "+prodotti[i].quantita_disponibili);
						$("#informazioni img").eq(i).attr("src", "data:image/jpg;base64,"+prodotti[i].base64Image);
						i++;
					}
					
					while(i<5) {
						$("#Contenitore div").eq(i).hide();
						i++;
					}
}
		});
		}
</script>

<script>

$(".bottonechecancella").click(function () {
	document.location='CancellazioneProdottoServlet?titolo='+$(this).prev().prev().prev().prev().prev().html();
});

$(".bottonechemodifica").click(function () {
	document.location='OneProductServlet?admin=yes&titolo='+$(this).prev().prev().prev().prev().prev().prev().html();
});

</script>

</body>

</html>
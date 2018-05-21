%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<link rel="icon" type="image/png" href="images/icono.png"/>
<title>Mis Pensamientos - ThinkingPlace</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
		body{
background: images/fondo.jpg no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
#titulo{
	font-family: "Franklin Gothic Heavy";
	text-align:center;
	color:white;
}
      
      #content{width:80%;position:float;overflow:scroll;background-color:rgba(45, 59, 121, 0.5);
		}
		#grid{overflow:hidden;
		}
		#contenedor{width:100%;margin-top:51px;position:relative;
		}
      
      
</style>

</head>
<body class="w3-theme-l5" onLoad="dimensiones()" background="images/fondo.jpg" >

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a style="width:30%" class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="${cargaMisP }" style="width:70%"  class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large"><i class="fa fa-home w3-margin-right"></i>ThinkingPlace</a>
  <a href="${cargaMisP }" class="w3-bar-item  w3-hide-small w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>ThinkingPlace</a>
  <a href="PensamientosFiltrados.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Filtrar"><i class="fa fa-globe"></i></a>
  <a href="misChatsServlet" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Chat"><i class="fa fa-envelope"></i></a>
  <form action="LogoutServlet" title="Logout"><button type="submit" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white">Logout</button></form>
 </div>
</div>


<!-- Navbar on small screens -->
<div id="navDemo" style="margin-top:5px" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="PensamientosFiltrados.jsp" class="w3-bar-item w3-button w3-padding-large">Filtrar</a>
  <a href="misChatsServlet" class="w3-bar-item w3-button w3-padding-large">Chat</a>
  <form action="LogoutServlet" title="Logout"><button type="submit" class="w3-bar-item w3-button w3-padding-large w3-button">Logout</button></form>  
</div>

<!-- Contenedor principal para paginas grandes max-width:1400px-->
<div class="w3-container w3-content " id="contenedor" style="height:700px;" >  

  <!-- The Grid -->
  <div class="w3-row" id="grid" style="height:700px;">
    <!-- Left Column -->
    <div class="w3-col m3" style="width:10%;">
      <!--  -->
      <p></p>
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->   
<div class="w3-col m3" id="content" style="height:700px;">

    	<h2 class="w3-hide-small" id="titulo">Hola, ${user.email }</h2>
    	<h4 style="text-align:center"class="w3-hide-medium w3-hide-large">Hola, ${user.email }</h4>
    	<h3 id="titulo">Chats activos:</p>
		
<c:forEach items="${todasConversaciones }" var="conversacion">
<c:set var="converUserId" scope= "session" value = "${conversacion.user.ID}"/>
	<c:choose>
		<c:when test="${ converUserId == user.ID || conversacion.token == user.token }">
			<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
				<p>Conversación asociada al pensamiento:</p>
				<p>${conversacion.nombre }</p>
				<form action="ChatServlet">
					<input type="hidden" name="conversacionId" value="${conversacion.id}" />
					<input type="hidden" name="tokenUser" value="${user.token}" />
					<p><button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i>  Ir al chat</button></p>
				</form>
		    </div>
		</c:when>
	</c:choose>
</c:forEach>
    <!-- End Middle Column -->
    </div>
    
    <div class="w3-col m3" style="width:10%;">
    <!-- Right Column -->
    <p></p>
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>



<!-- Footer -->
<footer class="w3-container w3-theme-d3 " style="height:50px;">
  <h5 class="w3-hide-small">ThinkingPlace - 2018. Proyecto para la asignatura ISST, Pensamiento Colectivo Geolocalizado.</h5>
  <h5 class="w3-hide-large w3-hide-medium">ThinkingPlace - 2018. </h5>
</footer>


<script type="text/javascript">

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(setPosition, getError);
        console.log("hola");
    } else { 
    	alert("ERROR\nPor favor, acepte el uso de la geolocalización y recarge la página");
    }

    
    function dimensiones(){
    	var a = screen.height-193;
    	document.getElementById("grid").setAttribute("style", "height:"+a+"px;");
    	document.getElementById("contenedor").setAttribute("style", "height:"+a+"px;");
    	document.getElementById("content").setAttribute("style", "height:"+a+"px;");
    }
    
    
//Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>


</body>
</html>
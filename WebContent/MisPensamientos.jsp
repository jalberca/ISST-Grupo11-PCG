<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<title>Mis Pensamientos - ThinkingPlace</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html,body,h1,h2,h3,h5 {font-family: "Open Sans", sans-serif}
body{
	background: images/fondo.jpg no-repeat center center fixed;
	-webkit-background-size: 100% 100%;
	-moz-background-size: 100% 100%;
	background-size: 100% 100%;
}
#titulo{
	font-family: "Franklin Gothic Heavy";
}
#content{
	width:80%;
	position:float;
	overflow:scroll;
	background-color:rgba(45, 59, 121, 0.5);
	
}

#grid{
	overflow:hidden;
}

#contenedor{
	width:100%;
	margin-top:51px;
	position:relative;
}
      
      
</style>


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
<div id="navDemo" style="margin-top:51px" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="${cargaMisP }" class="w3-bar-item w3-button w3-padding-large">Filtrar</a>
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


    	<h2 class="w3-hide-small"id="titulo" style="text-align:center;color:white;"><strong>Hola, ${user.email }</strong></h2>
    	<h4 style="text-align:center"class="w3-hide-medium w3-hide-large">Hola, ${user.email }</h4>
    	<h3></h3>
		<div class="w3-row-padding">
	    	<div class="w3-col m12" >
	         		<div class="w3-card w3-round w3-white">
		           		<div class="w3-container w3-padding">
			            	<h6 class="w3-opacity">¿Tienes algo que contar? Pulsa aquí para publicar un nuevo pensamiento</h6>
			            	<form action="NuevoPensamientoServlet">
			              		<input type="hidden" id="estado" name="status" value="">			              		<input type="hidden" id="latitud" name="latitud" value="">
				              	<input type="hidden" id="longitud" name="longitud" value="">
				           		<input type="hidden" name="email" value="${user.email }">
								<textarea type="text" name="text" placeholder="¿Qué estás pensando?" style="font-size:16px; width:90%;height:100px;"></textarea>
								<p><button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i>  Publicar</button></p>
							</form>
		           		</div>
	         		</div>
	        </div>
		</div>


		<h4 id="titulo"style="text-align:center;color:white;"><strong>Tus pensamientos son:</strong></h4>

		<c:forEach items="${user.misPensamientos }" var="pensamiento">
			<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
		    	<span class="w3-right w3-opacity">${pensamiento.date }</span>
		        <p>${pensamiento.text }</p>
		       	<div style="margin-bottom:10px">Positivos: ${pensamiento.votosPositivo } Negativos: ${pensamiento.votosNegativo }</div>
			</div>
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
var estado = document.getElementById("estado");
var lat = document.getElementById("latitud");
var log = document.getElementById("longitud");

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
    
    
function setPosition(position, error) {
	console.log("wey: " + position.coords.latitude);
	
    lat.value = position.coords.latitude;
    log.value = position.coords.longitude;
    estado.value = 0;
    console.log(lat);
    console.log(lat.value);
    console.log(estado.value);
}

function getError(error){
	switch(error.code) {
    case error.PERMISSION_DENIED:
    	estado.value=1;
        break;
    case error.POSITION_UNAVAILABLE:
    	status.value=2;
        break;
    case error.TIMEOUT:
    	status.value="2";
        break;
    case error.UNKNOWN_ERROR:
    	status.value=2;
        break;
	}
	alert("ERROR\nPor favor, inténtelo de nuevo más tarde");
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	String sala = (String) application.getAttribute("sala");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<title>Chat - ThinkingPlace</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-orange.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}

</style>

<script type="text/javascript">
	function load() {
		document.getElementById("msg").focus();
	}
</script>

<body class="w3-theme-l5" onLoad="load()">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="MisPensamientos.jsp" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>ThinkingPlace</a>
  <a href="PensamientosFiltrados.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Filtrar"><i class="fa fa-globe"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Ajustes"><i class="fa fa-user"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Chat"><i class="fa fa-envelope"></i></a>
  
  <a href="Login.jsp" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="Logout">Logout</a>
 </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Menu</a>
  <a href="filter.html" class="w3-bar-item w3-button w3-padding-large">Filtrar</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Ajustes</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Chat</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Notificaciones</a>
  <a href="login.html" class="w3-bar-item w3-button w3-padding-large">Logout</a>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!--  -->
      
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7" id="content">
    <div id="sala"><%=sala%></div>
    
    <form action="ChatServlet" method="post" style="text-align:center">
    	<input type="text" name="msg" style="width: 244px" id="msg"/>
    	<input type="submit" value="Enviar" style="width: 60px" />
    </form>
    


    <!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
    
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  



<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <h5>ThinkingPlace - 2018. Proyecto para la asignatura ISST, Pensamiento Colectivo Geolocalizado.</h5>
</footer>

<footer class="w3-container w3-theme-d5">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
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
</script>


</body>
</html>
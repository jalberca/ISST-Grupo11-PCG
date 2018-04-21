<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<title>ThinkingPlace</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-orange.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
</style>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="index.html" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>ThinkingPlace</a>
  <a href="filter.html" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Filtrar"><i class="fa fa-globe"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Ajustes"><i class="fa fa-user"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Chat"><i class="fa fa-envelope"></i></a>
  
  <a href="login.html" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="Logout">Logout</a>
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

!-- Page Container -->
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
	<div class="w3-row-padding">
	        <div class="w3-col m12">
	          <div class="w3-card w3-round w3-white">
	            <div class="w3-container w3-padding">

					<form action="NuevoPensamientoServlet">
						<input type="text" name="text" placeholder="¿Qué estás pensando?">
						<button type="submit">Publicar</button>
					</form>
					
					Mapa Google Maps
					
	            </div>
	          </div>
	        </div>
	      </div>
	      
	<!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
    
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
</body>
</html>
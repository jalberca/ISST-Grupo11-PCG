<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html style="height: 100%;">
<head>
	<link rel="icon" type="image/png" href="images/icono.png"/>
	<title>Todos los pensamientos - ThinkingPlace</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="styles/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
		#content{
	position:float;
	overflow:scroll;
	
}

#grid{
	overflow:hidden;
}

#contenedor{
	position:relative;
}
	</style>
</head>
<body class="w3-theme-l5" onLoad="dimensiones()" style="height: 100%;">


<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a style="width:50%" class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="VistaAdmin.jsp" style="width:40%"  class="w3-bar-item w3-button w3-padding-large w3-hide-small" title="Administrar Pensamientos">Administrar Pensamientos</a>
  <a href="VistaAdmin.jsp" style="width:50%" class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large" title="Administrar Pensamientos"><i class="fa fa-home w3-margin-right"></i></a>					
  <a href="AdminUsuarios.jsp" style="width:40%"  class="w3-bar-item w3-button w3-padding-large w3-hide-small" title="Administrar Usuarios">Administrar Usuarios</a>
  <form action="LogoutServlet" title="Logout"><button type="submit" style="width:20%" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white">Logout</button></form> </div>
</div>


<!-- Navbar on small screens -->
<div id="navDemo" style="margin-top:40px" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="AdminUsuarios.jsp"  class="w3-bar-item w3-button w3-padding-large" title="Administrar Usuarios">Administrar Usuarios</a>
  <form action="LogoutServlet" class="w3-bar-item w3-button w3-padding-large" title="Logout"><button type="submit" class="w3-button">Logout</button></form> </div>
</div>



<!-- Page Container -->
<div class="w3-container w3-content" id="contenedor" style="max-width:1400px;margin-top:4%; height: 100%;">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!--  -->
      
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7" id="content" style="height:500px">
    <h2>Hola, Administrador</h2>
    <h3></h3>



<p>Aquí están todos los pensamientos publicados hasta el momento: </p>

<c:forEach items="${pensamientos }" var="pensamiento">
	<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
        <span class="w3-right w3-opacity">${pensamiento.date }</span>
        <p>${pensamiento.text }</p>
       <div>Positivos: ${pensamiento.votosPositivo } Negativos: ${pensamiento.votosNegativo }</div>
       <form action="BanearPensamientoServlet">
       	<input type="hidden" name="id" value="${pensamiento.id }">
       	 <button type="submit" style = "float: right" class="w3-button w3-theme"><i class="fa fa-pencil"></i> ELIMINAR PENSAMIENTO</button>
       </form></p>
      </div>
</c:forEach>


    <!-- End Middle Column -->
    </div>
    
    
    
    
    <!-- Right Column -->
    
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
function dimensiones(){
 		var a = window.innerHeight;
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
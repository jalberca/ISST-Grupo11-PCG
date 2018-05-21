<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html style="width:100%">
<head>
<link rel="icon" type="image/png" href="images/icono.png"/>

<title>Pensamientos Filtrados - ThinkingPlace</title>
<link rel="icon" type="image/png" href="/imágenes/icono.jpeg" />

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
 footer {
             position:relative ;
             clear: both;          
        }
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map,map1 {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      .map{
        height: 100%;
        margin-top:10px; 
        width:90%; 
        text-align:center;
        padding: 200px; 
      }
      .map1 {
        height: 100%;
        margin-top:10px; 
        width:90%; 
        text-align:center;
        padding: 200px; 
      }
      .controls {
        margin-top: 10px;
        border: 1px solid transparent;
        border-radius: 2px 0 0 2px;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        height: 32px;
        outline: none;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
      }
      #pac-input,pac-input1 {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        padding: 0 11px 0 13px;
        text-overflow: ellipsis;
        width: 300px;
      }
      #pac-input:focus {
        border-color: #4d90fe;
      }
      .pac-container {
        font-family: Roboto;
      }
      #type-selector {
        color: #fff;
        background-color: #4d90fe;
        padding: 5px 11px 0px 11px;
      }
      #type-selector label {
        font-family: Roboto;
        font-size: 13px;
        font-weight: 300;
      }
      #target {
        width: 345px;
      }
      #izq{
      position:float;
      overflow:scroll;
      width:50%;
      }
      body{
		background: images/fondo.jpg no-repeat center center fixed;
		-webkit-background-size:100% 100%;
		-moz-background-size: 100% 100%;
		background-size: 100% 100%;
		}
</style>
</head>
<body class="w3-theme-l5" onload="dimensiones()" background="images/fondo.jpg" style="width:100%" >
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
  <a href="PensamientosFiltrados.jsp" class="w3-bar-item w3-button w3-padding-large">Filtrar</a>
  <a href="misChatsServlet" class="w3-bar-item w3-button w3-padding-large">Chat</a>
  <form action="LogoutServlet" title="Logout"><button type="submit" class="w3-bar-item w3-button w3-padding-large w3-button">Logout</button></form>  
</div>


<!-- Contenedor principal para paginas grandes max-width:1400px-->
<div class="w3-container " id="contenedor" style="position:relative;margin-left:2%;margin-right:2%;margin-bottom:2%;margin-top:51px;">  


    <!-- Left Column -->
    <h2 style="text-align:left;font-family:Franklin Gothic Heavy" class="w3-hide-small">Los pensamientos de esta zona son:</h2>
    <div class="w3-col m3" id="izq" style="height:10px;">
      

<div class="w3-container w3-content w3-hide-small"  style="">



	<c:forEach items="${pensamientos}" var="pensamiento">
		<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
	        <span class="w3-right w3-opacity">${pensamiento.date }</span>
	        <p>${pensamiento.text }</p>
	        <div>
	        <table>
	        <tr>
	        <form action="VotarPositivo">
	        	<input type="hidden" name="cargar" value="${cargar }">
	        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
	        	<button type="submit" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  (${pensamiento.votosPositivo })</button>
	        </form>
	        <form action="VotarNegativo">
	        	<input type="hidden" name="cargar" value="${cargar }">
	        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
	        	<button type="submit" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-down"></i>   (${pensamiento.votosNegativo })</button>
	        </form>
	        
	        <form action="ReportarServlet">
	        	<input type="hidden" name="cargar" value="${cargar }">
	        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
	        	<button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-ban"></i>  Report</button>
	        </form>
	        <form action="ContactarUsuarioServlet">
	        	<input type="hidden" name="pensamientoId" value="${pensamiento.id }">
	        	<input type="hidden" name="userToken" value="${user.token }">
	        	<button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-commenting"></i>  Contactar</button>
	        </form>

			<a href="#" class="w3-button w3-theme-d1 w3-margin-bottom" onclick="mostrar1(this, ${pensamiento.id }); return false" /> <i class="fa fa-comments-o"></i> Comentarios </a>

	        </tr>
	        </table>
	        </div>

	        <div id="${pensamiento.id}" style="display:none">
	        <form action="NuevoComentarioServlet">
	        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
	          		<input type="hidden" id="estado" name="status" value="">
	          		<input type="hidden" id="latitud" name="latitud" value="">
	           		<input type="hidden" id="longitud" name="longitud" value="">
	           		<input type="hidden" name="email" value="${user.email }">
					<textarea type="text" name="text" placeholder="¿Qué opinas de este pensamiento?" style="font-size:16px; width:90%;height:100px;"></textarea>
					<p><button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i>  Comentar</button></p>
				</form>
            <c:forEach items="${comentarios}" var="comentario">
                <c:set var = "pensid" scope = "session" value = "${pensamiento.id}"/>
            <c:set var="comentpens" value="${comentario.pensamiento}"/>

            	<c:choose>
    				<c:when test="${pensid == comentpens }">
						<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
		       				<span class="w3-right w3-opacity">${comentario.date }</span>
		       				<p>${comentario.text }</p>
		       			
		       			</div>
		        	</c:when>
    				<c:otherwise>
    				</c:otherwise>
				</c:choose>

           	</c:forEach>
           	</div>
	      </div>
	</c:forEach>
	</div>






    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m3" >

    
    <!-- End Middle Column -->
    </div>
    
    <div class="w3-col m3" id="der" style="width:50%;"> <!-- OJO CUIDADO, PARA PAGINAS GRANDES, ESTE STYLE TIENE QUE TENER UN WIDTH DE 50% PARA PEQUEÑAS, TIENE QUE SER DEL 100%-->
    <!-- Right Column -->
    
    
    
    <div style="margin-top:4%; width:100%;height:100%;float:center; ">
	<form class="w3-card w3-round w3-white w3-hide-small" action="PensamientosFiltradosServlet" style="width:90%;text-align: center;margin-right:10px; margin-top:10px;">
  		<table align="center" >
  			<tr><th>Latitud:</th><th><input id="lat" type="text" name="latitud" placeholder="Latitud(grados)" style="margin-top:10px;"></th></tr>
  			<tr><th>Longitud:</th><th><input id="long" type="text" name="longitud" placeholder="Longitud(grados)"></th></tr>
  			<tr><th>Código Postal:</th><th><input id="cp" type="number" name="CP" placeholder="Código Postal"></th></tr>
  			<tr><th>Radio:</th><th><input type="text" name="radio" placeholder="Radio (metros)"></th></tr>
  		</table>
  		<button type="submit" style="margin-top:10px;margin-bottom:10px" onclick='return escribir()'>Filtrar</button>  
	</form>
	
	<!-- Formulario para paginas pequeñas -->
	<form class="w3-card w3-round w3-white w3-hide-medium w3-hide-large" action="PensamientosFiltradosServlet" style="text-align: center;">
	  		<table align="center" >
	  			<tr><th>Latitud:</th></tr>
	  			<tr><th><input id="lat1" type="text" name="latitud" placeholder="Latitud(grados)" style="margin-top:10px;"><th></tr>
	  			<tr><th>Longitud:</th></tr>
	  			<tr><th><input id="long1" type="text" name="longitud" placeholder="Longitud(grados)"></th></tr>
				<tr><th>Código Postal:</th></tr>
  				<tr><th><input id="cp1" type="number" name="CP" placeholder="Código Postal"></th></tr>
  				<tr><th>Radio:</th></tr>
  				<tr><th><input type="text1" name="radio" placeholder="Radio (metros)"></th></tr>
  			</table>
  			<button type="submit" style="margin-top:10px;margin-bottom:10px" onclick='return escribir()'>Filtrar</button>  
		</form>


<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa -->
	<input   id="pac-input" class="controls" type="text" placeholder="Search Box">
 	<div  id="map" class="map"  ></div>
 	<div   id="location" class="location"></div>
<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa -->
<!-- Mapa --> 	
	
	
	
	<div id="peq"class="w3-hide-medium w3-hide-large" style="margin-left:5%;margin-rigth:5%; width:90%;" >
	<h3 style="text-align:center;font-family:Franklin Gothic Heavy">Los pensamientos de esta zona son:</h3>

	<c:forEach items="${pensamientos}" var="pensamiento">
		<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
	        <span class="w3-right w3-opacity">${pensamiento.date }</span>
	        <p>${pensamiento.text }</p>
	        <div>
	        	<table>
	        		<tr>
				        <form action="VotarPositivo">
				        	<input type="hidden" name="cargar" value="${cargar }">
				        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
				        	<button type="submit" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> </button>
				        </form>
				        <form action="VotarNegativo">
				        	<input type="hidden" name="cargar" value="${cargar }">
				        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
				        	<button type="submit" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-down"></i></button>
				        </form>
				        
				        <form action="ReportarServlet">
				        	<input type="hidden" name="cargar" value="${cargar }">
				        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
				        	<button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-ban"></i></button>
				        </form>
				        <form action="ContactarUsuarioServlet">
	        				<input type="hidden" name="pensamientoId" value="${pensamiento.id }">
	        				<input type="hidden" name="userToken" value="${user.token }">
	        				<button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-commenting"></i></button>
	        			</form>

						<a href="#" class="w3-button w3-theme-d1 w3-margin-bottom" onclick="mostrar(this, ${pensamiento.id +9000}); return false" /><i class="fa fa-comments-o"></i></a>
	        		</tr>
	        	</table>
	        </div>

	        <div id="${pensamiento.id+9000}" style="display:none">
		        <form action="NuevoComentarioServlet">
		        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
		          		<input type="hidden" id="estado" name="status" value="">
		          		<input type="hidden" id="latitud" name="latitud" value="">
		           		<input type="hidden" id="longitud" name="longitud" value="">
		           		<input type="hidden" name="email" value="${user.email }">
						<textarea type="text" name="text" placeholder="¿Qué opinas de este pensamiento?" style="font-size:16px; width:90%;height:100px;"></textarea>
						<p><button type="submit" class="w3-button w3-theme">Comentar </button></p>
				</form>
	            <c:forEach items="${comentarios}" var="comentario">
	                <c:set var = "pensid" scope = "session" value = "${pensamiento.id}"/>
	            <c:set var="comentpens" value="${comentario.pensamiento}"/>
	            	<c:choose>
	    				<c:when test="${pensid == comentpens }">
							<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
			       				<span class="w3-right w3-opacity">${comentario.date }</span>
			       				<p>${comentario.text }</p>
			       			
			       			</div>
			        	</c:when>
	    				<c:otherwise>
	    				</c:otherwise>
					</c:choose>
	
	           	</c:forEach>
           	</div>
	      </div>
	</c:forEach>
	
	
	
	
	
	
	
	
    <!-- End Right Column -->
    </div>

  
<!-- End Page Container -->
</div>

</div>
















<!-- Footer -->
<footer class="w3-container w3-theme-d3 " style="height:50px;">
  <h5 class="w3-hide-small">ThinkingPlace - 2018. Proyecto para la asignatura ISST, Pensamiento Colectivo Geolocalizado.</h5>
  <h5 class="w3-hide-large w3-hide-medium">ThinkingPlace - 2018. </h5>
</footer>

     <script>
     

     function dimensiones(){
    	 if(window.innerWidth>596){
      		var a = document.getElementById('der').offsetHeight;
      		document.getElementById("izq").setAttribute("style", "height:"+a+"px;");
      		document.getElementById("der").setAttribute("style", "width:50%;");
      	}else{
      		document.getElementById("der").setAttribute("style", "width:100%;");
     	 	return;
      	}
    	 
    	 
    	 
     	/*var a = document.getElementById('der').offsetHeight;
     	document.getElementById("izq").setAttribute("style", "height:"+a+"px;");*/
     
     	
     	
     	

     }

     function sleep(milliseconds) {
    	  var start = new Date().getTime();
    	  for (var i = 0; i < 1e7; i++) {
    	    if ((new Date().getTime() - start) > milliseconds){
    	      break;
    	    }
    	  }
    	}

     
     function mostrar(enla, etiq) {
    	  obj = document.getElementById(etiq);
    	  obj.style.display = (obj.style.display == 'block') ? 'none' : 'block';
    	}
     function mostrar1(enla, etiq) {
   	  obj = document.getElementById(etiq);
   	  obj.style.display = (obj.style.display == 'block') ? 'none' : 'block';
   	  enla.innerHTML = (enla.innerHTML == '<i class="fa fa-comments-o"></i> Cerrar comentarios') ? '<i class="fa fa-comments-o"></i> Comentarios' : '<i class="fa fa-comments-o"></i> Cerrar comentarios';
   	}
     
     
	function escribir(){
		if((document.getElementById('lat').value === null || document.getElementById('long').value === null) && document.getElementById('cp').value !== null){
			var ajax_url ='http://maps.googleapis.com/maps/api/geocode/json?address='+ document.getElementById('cp').value +'&region=ES&sensor=false';
      	  	var ajax_request = new XMLHttpRequest();
      	  	ajax_request.open( "GET", ajax_url1, false);
      	  	ajax_request.send();
      	  	sleep(2000);
      	  	var JSON1 =  JSON.parse(ajax_request.response);
      	  	if(JSON1.error_message){
      	  		return;
      	  	}
      	  	console.log(JSON);
      	  document.getElementById('lat').value  = JSON1.results[0].geometry.location.lat;
      	 document.getElementById('long').value  = JSON1.results[0].geometry.location.lng;
		}
		
		if((document.getElementById('lat1').value === null || document.getElementById('long1').value === null) && document.getElementById('cp1').value !== null){
			var ajax_url ='http://maps.googleapis.com/maps/api/geocode/json?address='+ document.getElementById('cp1').value +'&region=ES&sensor=false';
      	  	var ajax_request = new XMLHttpRequest();
      	  	ajax_request.open( "GET", ajax_url1, false);
      	  	ajax_request.send();
      	  	sleep(2000);
      	  	var JSON1 =  JSON.parse(ajax_request.response);
      	  	if(JSON1.error_message){
      	  		return;
      	  	}
      	  	console.log(JSON);
      	  document.getElementById('lat1').value  = JSON1.results[0].geometry.location.lat;
      	 document.getElementById('long1').value  = JSON1.results[0].geometry.location.lng;

		}
	}
     
     
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
      // This example adds a search box to a map, using the Google Place Autocomplete
      // feature. People can enter geographical searches. The search box will return a
      // pick list containing a mix of places and predicted search terms.
      // This example requires the Places library. Include the libraries=places
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">
     var markers = []; 
     function initAutocomplete() {
        
    	 var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 40.4167, lng:  -3.70325},
          zoom: 13,
          mapTypeId: 'roadmap'
        });
    	 
    	

    	 <c:forEach items="${pensamientos}" var="pensamiento">
			var position = {lat:${pensamiento.latitud}+Math.random()*Math.pow(10,-4),lng:${pensamiento.longitud}+Math.random()*Math.pow(10,-4)};
			var texto = "${pensamiento.text}";
			console.log(position);

			var marcador = new google.maps.Marker({
			  	  position: position,
			   	  map: map,
		  		});
			console.log(texto);
		    var infowindow = new google.maps.InfoWindow();  
			google.maps.event.addListener(marcador,'click', (function(marcador,texto,infowindow){ 
			    return function() {
			        infowindow.setContent(texto);
			        infowindow.open(map,marcador);
			    };
			})(marcador,texto,infowindow)); 			
		</c:forEach>
		
		
		
        // Create the search box and link it to the UI element.
        var input = document.getElementById('pac-input');
        var searchBox = new google.maps.places.SearchBox(input);
        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
        // Bias the SearchBox results towards current map's viewport.
        map.addListener('bounds_changed', function() {
          searchBox.setBounds(map.getBounds());
        });
        
        // Listen for the event fired when the user selects a prediction and retrieve
        // more details for that place.
        searchBox.addListener('places_changed', function() {
          var places = searchBox.getPlaces();
          if (places.length == 0) {
            return;
          }
          // Clear out the old markers.
          markers.forEach(function(marker) {
            marker.setMap(null);
          });
          markers = [];
          // For each place, get the icon, name and location.
          var bounds = new google.maps.LatLngBounds();
          places.forEach(function(place) {
            if (!place.geometry) {
              console.log("Returned place contains no geometry");
              return;
            }
            var icon = {
              url: place.icon,
              size: new google.maps.Size(71, 71),
              origin: new google.maps.Point(0, 0),
              anchor: new google.maps.Point(17, 34),
              scaledSize: new google.maps.Size(25, 25)
            };
            // Create a marker for each place.
            markers.push(new google.maps.Marker({
              map: map,
              icon: icon,
              title: place.name,
              position: place.geometry.location
            }));
          markers.forEach(function(marker) {
			var ajax_url ='http://maps.googleapis.com/maps/api/geocode/json?latlng='+marker.getPosition().lat()+','+marker.getPosition().lng()+'&sensor=true_or_false';
        	  var ajax_request = new XMLHttpRequest();
        	  ajax_request.open( "GET", ajax_url, false);
        	  ajax_request.send();
        	  sleep(1500);
        	  var JSON2 =  JSON.parse(ajax_request.response);
          		document.getElementById('cp').value = JSON2.results[0].address_components[6].long_name;
          		document.getElementById('cp1').value = JSON2.results[0].address_components[6].long_name;
        	  if(JSON2.error_message){
        	  		return;
        	  }
          	document.getElementById('cp').value = JSON2.results[0].address_components[6].long_name;
       	  document.getElementById('lat').value = marker.getPosition().lat();
          document.getElementById('long').value = marker.getPosition().lng();
      	document.getElementById('cp1').value = JSON2.results[0].address_components[6].long_name;
     	  document.getElementById('lat1').value = marker.getPosition().lat();
        document.getElementById('long1').value = marker.getPosition().lng();
            //CÓDIGO PARA IMPRIMIR LA LATITUD Y LONGITUD - MÉTODO PARA SUMARLE LA DISTANCIA QUE ELIJA EL USUARIO Y TENER UN RADIO CIRCULAR ALREDEDOR
          });
            if (place.geometry.viewport) {
              // Only geocodes have viewport.
              bounds.union(place.geometry.viewport);
            } else {
              bounds.extend(place.geometry.location);
            }
          });
          map.fitBounds(bounds);
        });
        map.addListener('click', function(e) {  
        	for (var i=0; i<markers.length; i++) {
      		  markers[i].setMap(null);
      	  }      
        	console.log("Markers");
        	console.log(markers.length);
            placeMarkerAndPanTo(e.latLng, map);
            
          });
        
      }
		 
        var infoWindow = new google.maps.InfoWindow({map: map});
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      
      
      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
      }
      
      function placeMarkerAndPanTo(latLng, map) {
    	  var marker = new google.maps.Marker({
    	    position: latLng,
    	    map: map
    	  });    	  
    	  markers.push(marker)
    	  var ajax_url ='http://maps.googleapis.com/maps/api/geocode/json?latlng='+marker.getPosition().lat()+','+marker.getPosition().lng()+'&sensor=true_or_false';
        	  var ajax_request = new XMLHttpRequest();
        	  ajax_request.open( "GET", ajax_url, false);
        	  ajax_request.send();
        	  sleep(200);
          var JSON1 =  JSON.parse(ajax_request.response);
          if(JSON1.error_message){
    	  		return;
    	  	}
          console.log(JSON1);
          document.getElementById('cp').value = JSON1.results[0].address_components[6].long_name;
          document.getElementById('lat').value = marker.getPosition().lat();
          document.getElementById('long').value = marker.getPosition().lng();
          document.getElementById('cp1').value = JSON1.results[0].address_components[6].long_name;
          document.getElementById('lat1').value = marker.getPosition().lat();
          document.getElementById('long1').value = marker.getPosition().lng();
    	  map.panTo(latLng);
    	}

      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDY-KHF4-ZwYtyt3JOm2FRsJn8OK0KAVaY&libraries=places&callback=initAutocomplete"
      async defer></script>

<br>
 
<script>
// Accordion
function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme-d1";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme-d1", "");
    }
}
// Used to toggle the menu on smaller screens when clicking on the menu button
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
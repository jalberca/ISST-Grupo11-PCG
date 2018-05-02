<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<title>Pensamientos Filtrados - ThinkingPlace</title>
<link rel="icon" type="image/png" href="/imágenes/mifavicon.png" />

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-orange.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}

      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      .map {
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
      #pac-input {
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
</style>
<body class="w3-theme-l5" onload="posicionActual();">


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
  <a href="MisPensamientos.jsp" class="w3-bar-item w3-button w3-padding-large">Menu</a>
  <a href="PensamientosFiltrados.jsp" class="w3-bar-item w3-button w3-padding-large">Filtrar</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Ajustes</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Chat</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Notificaciones</a>
  <a href="Login.jsp" class="w3-bar-item w3-button w3-padding-large">Logout</a>
</div>

<!-- Page" Container -->
<div class="w3-container w3-content" style="margin-top:4%;width:50%;height:800px;float:left;" >
<h2 style="text-align:center;">Los pensamientos de esta zona son:</h2>

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

	        </tr>
	        </table>
	        </div>
	        <form action="NuevoComentarioServlet">
	        	<input type="hidden" name="pensamientoID" value="${pensamiento.id }">
	          		<input type="hidden" id="estado" name="status" value="">
	          		<input type="hidden" id="latitud" name="latitud" value="">
	           		<input type="hidden" id="longitud" name="longitud" value="">
	           		<input type="hidden" name="email" value="${user.email }">
					<textarea type="text" name="text" placeholder="¿Qué opinas de este pensamiento?" style="font-size:16px; width:500px;height:100px;"></textarea>
					<p><button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i>  Comentar</button></p>
				</form>
            <c:forEach items="${comentarios}" var="comentario">
                <c:set var = "pensid" scope = "session" value = "${pensamiento.id}"/>
            <c:set var="comentpens" value="${comentario.pensamiento}"/>
<%-- 			<c:out value="${pensid}"/><p>
				<c:out value="${comentpens}"/><p> --%>
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
	</c:forEach>


</div>

<div style="margin-top:4%; width:50%;height:100%;float:right; ">
<form class="w3-card w3-round w3-white" action="PensamientosFiltradosServlet" style="width:90%;text-align: center;margin-right:10px; margin-top:10px;">
  <table align="center" >
  <tr>  
  <th>Latitud:</th><th><input id="lat" type="text" name="latitud" placeholder="Latitud(grados)" style="margin-top:10px;"></th>
  </tr>
  <tr>
  <th>Longitud:</th><th><input id="long" type="text" name="longitud" placeholder="Longitud(grados)"></th>
  </tr>
  <tr>
  <th>Código Postal:</th><th><input id="cp" type="number" name="CP" placeholder="Código Postal"></th>
  </tr>
  <tr>
  <th>Radio:</th><th><input type="text" name="radio" placeholder="Radio (metros)"></th>
  </tr>
  </table>
  <button type="submit" style="margin-top:10px;margin-bottom:10px" onclick='return escribir()'>Filtrar</button>  
</form>

<input id="pac-input" class="controls" type="text" placeholder="Search Box">
<div id="map" class="map"  ></div>
<div id="location" class="location"></div>

</div>
     <script>
        
     
     
	function escribir(){
		if((document.getElementById('lat').value === null || document.getElementById('long').value === null) && document.getElementById('cp').value !== null){
			var ajax_url ='http://maps.googleapis.com/maps/api/geocode/json?address='+ document.getElementById('cp').value +'&region=ES&sensor=false';
      	  	var ajax_request = new XMLHttpRequest();
      	  	ajax_request.open( "GET", ajax_url1, false);
      	  	ajax_request.send();
      	  	var JSON1 =  JSON.parse(ajax_request.response);
      	  document.getElementById('lat').value  = JSON1.results[0].geometry.location.lat;
      	 document.getElementById('long').value  = JSON1.results[0].geometry.location.lng;
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
        	  var JSON2 =  JSON.parse(ajax_request.response);
          	document.getElementById('cp').value = JSON2.results[0].address_components[6].long_name;
       	  document.getElementById('lat').value = marker.getPosition().lat();
          document.getElementById('long').value = marker.getPosition().lng();
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
         var JSON1 =  JSON.parse(ajax_request.response);
          document.getElementById('cp').value = JSON1.results[0].address_components[6].long_name;
          document.getElementById('lat').value = marker.getPosition().lat();
          document.getElementById('long').value = marker.getPosition().lng();
    	  map.panTo(latLng);
    	}
      
      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCNbFI-znN_Obo0ENJTRZkyn-vycXJwoZ0&libraries=places&callback=initAutocomplete"
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
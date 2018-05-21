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
<meta http-equiv="refresh" content="5;${cargaChat}"/>
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    
    <!-- Middle Column -->
    <div class="w3-col m12 w3-padding" id="content">
    <div id="sala"><%=sala%></div>
    
    
  <div class="panel-Body w3-light-gray" id="messageBody" style="overflow-y:auto; height:450px">
<c:forEach items="${mensajes}" var="mensaje">
                <c:set var = "conversid" scope = "session" value = "${conversacionId}"/>
            <c:set var="mensjconv" value="${mensaje.conversacion}"/>
<%-- 			<c:out value="${conversid}"/><p>
				<c:out value="${mensjconv}"/><p> --%>
            	<c:choose>
    				<c:when test="${conversid == mensjconv }">
    					<c:set var="msjToken" value="${mensaje.token}" />
    					<c:set var="usrToken" value="${user.token}" />
    	<%-- 			<c:out value="${msjToken}"/><p>
						<c:out value="${usrToken}"/><p> --%>
						<c:choose>
							<c:when test="${msjToken == usrToken }" >
							<div class="w3-container" style="clear:left">
								<div class="w3-container w3-card w3-green w3-round w3-margin w3-padding w3-right">
		       						<span class="w3-right w3-opacity">${mensaje.date }</span>
		       						<span class="w3-right w3-margin-right">${mensaje.text }</span><br>
		       					</div>
		       				</div>
		        			</c:when>
    						<c:otherwise>
    						<div class="w3-container" style="clear:right">
								<div class="w3-container w3-card w3-white w3-round w3-margin w3-padding w3-left">
		       						<span class="w3-left w3-opacity">${mensaje.date }</span>
		       						<span class="w3-left w3-margin-left">${mensaje.text }</span><br>
		       					</div>
		       				</div>
    						</c:otherwise>
    						</c:choose>
    						</c:when>
				</c:choose>

           	</c:forEach>
</div>
<form action="ChatServlet" style="text-align:center">
<div><p>
    	<input class="w3-input w3-border w3-round-large w3-left" type="text" name="msg" id="msg" style="width:1000px"/>
    	<input type="hidden" name="conversacionId" value = "${conversacionId}"/>
    	<input type="hidden" name="userToken" value = "${user.token}"/>
    	<button type="submit" class="w3-btn w3-circle w3-teal w3-left"><i class="fa fa-send"></i></button>
</p></div>
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


<script type="text/javascript">
var messageBody = document.getElementById("messageBody");
messageBody.scrollTop = messageBody.scrollHeight - messageBody.clientHeight;


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
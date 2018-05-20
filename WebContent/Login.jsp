
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>Login - ThinkingPlace</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="styles/login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="styles/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="styles/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="styles/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="styles/login/css/main.css">
<!--===============================================================================================-->

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="953660495183-475gp5akjru219a9fltitorfcnssvhns.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <style>
    body{
	background: images/fondo.jpg no-repeat center center fixed;
	-webkit-background-size: 100% 100%;
	-moz-background-size: 100% 100%;
	background-size: 100% 100%;
}
    </style>

</head>
<body  background="images/fondo.jpg">
  
	
	<div class="limiter">
		<div class="container-login100" style="height:100%;">
			<div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30" style="background-color:rgb(255, 255, 255,0.7);">
						<div>
						<div style="font-size:30px; text-align:center; font-weight:bold">Login</div>
						<div> </div>
						<img src="images/thinkingplace.png" style="width:350px; height:250px"/>
						</div>
					
					<div class="text-center w-full p-t-42 p-b-22">
						<span class="txt1">
							<p style="color:black;">Autentiquese con Google:</p>
						</span>
					<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" style="text-align:center; margin-left:110px"></div>

						<span class="txt1" id="texto" style="color:black;">
						
						</span>
							<form action="LoginOAuth">
								<input type="hidden" name="email" id="Email" value="">
								<input type="hidden" name="token" id="Token" value="">
								<button type="submit" style="background-color: orange; border: none; color: white; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; margin: 4px 2px; cursor: pointer ">Login</button>
							 </form>
				</div>
			</div>
		</div>
	</div>
<script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());
        
		var email = document.getElementById("Email");
		var token = document.getElementById("Token");
		var texto = document.getElementById("texto");
		texto.innerHTML = "¿Eres "+ profile.getName()+"? pulsa el botón";
		email.value=profile.getEmail();
		token.value=profile.getId();
		
        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      };
    </script>
</body>
</html>
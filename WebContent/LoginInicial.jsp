<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN - BETA 0.1</h1>
<h2>Acceder a cuenta existente</h2>
<form action="LoginPrueba">
	<input type="text" name="email" placeholder="Email">
	<input type="text" name="token" placeholder="Token">
	<button type="submit">Login</button>
</form>

<h2>Crear una cuenta</h2>
<form action="CreateUserServlet">
<input type="text" name="email" placeholder="Email" />
<input type="text" name="token" placeholder="Token" />
<button type="submit"> Crear usuario</button>
</form>

</body>
</html>
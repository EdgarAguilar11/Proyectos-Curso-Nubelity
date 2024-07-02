<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hola mundo</title>
</head>
<body>
	<h2>Hola mundo!</h2>
<!-- 	el codigo a continuacion es una excepción de código en java -->
	<% out.println(request.getAttribute("bienvenida")); %>
	<h2>${bienvenida}</h2>
</body>
</html>
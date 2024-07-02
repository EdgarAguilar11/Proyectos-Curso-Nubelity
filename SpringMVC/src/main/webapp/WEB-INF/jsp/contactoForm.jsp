<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacto Nuevo</title>
</head>
<body>
	<h2>Contacto Nuevo</h2>
	<form:form action="salvarContacto" method="Post">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td><form:label path="nombre" >Nombre:</form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" /></td>
			</tr>
			<tr>
				<td><form:label path="email" >Email:</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="direccion" >Dirección:</form:label></td>
				<td><form:input path="direccion" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono" >Telefono:</form:label></td>
				<td><form:input path="telefono" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Salvar"></td>
			</tr>
		</table>
	</form:form>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- directiva de jsp se caracterisa por iniciar con < %@ -->
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Estudiante</title>
</head>
<body>
	<h2>Información del estudiante</h2>
	<form:form action="estudiante" method="Post">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre</form:label></td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td><form:label path="edad">Edad</form:label></td>
				<td><form:input path="edad"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Registrar">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
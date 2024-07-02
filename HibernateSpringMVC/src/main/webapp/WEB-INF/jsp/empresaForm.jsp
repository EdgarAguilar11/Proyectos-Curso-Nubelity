<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Empresa</title>
</head>
<body>
	<h2>Registro de empresa</h2>
	<form:form action="agregarEmpresa" method="Post">
		<table>
			<tbody>
				<tr>
					<td><form:label path="nombre">Nombre:</form:label></td>
					<td><form:input path="nombre"/></td>
				</tr>
				<tr>
					<td><form:label path="descripcion">Descripcion:</form:label></td>
					<td><form:input path="descripcion"/></td>
				</tr>
				<tr>
					<td coldspan="2">
						<button type="submit">Registrar</button>
					</td>
				</tr>
			</tbody>
		</table>		
	</form:form>
</body>
</html>
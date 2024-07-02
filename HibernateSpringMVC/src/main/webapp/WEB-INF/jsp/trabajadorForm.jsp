<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Trabajador</title>
</head>
<body>
	<h2>Agregar Trabajador</h2>
	<form:form action="agregarTrabajador" method="Post">
		<table>
			<tbody>
				<tr>
					<td><form:label path="nombre">Nombre:</form:label></td>
					<td><form:input path="nombre"/></td>
				</tr>
				<tr>
					<td><form:label path="apellido">Apellido:</form:label></td>
					<td><form:input path="apellido"/></td>
				</tr>
				<tr>
					<td><form:label path="tipoTrabajador">Tipo Trabajador</form:label></td>
					<td>
						<form:select path="tipoTrabajador">
							<form:options items="${tiposTrabajador}"/>
						</form:select>		
					</td>
				</tr>
				<tr>
					<td><form:label path="empresa.id">Empresa</form:label></td>
					<td>
						<form:select path="empresa.id">
							<form:options items="${empresas}" itemLabel="nombre" itemValue="id"/>
						</form:select>
					</td>
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
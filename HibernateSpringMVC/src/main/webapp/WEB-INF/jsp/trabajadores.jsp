<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajadores</title>
</head>
<body>
	<h2>Lista de Trabajadores</h2>
	<h3><a href="agregarTrabajador">Agregar Trabajador</a></h3>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Empresa</th>
				<th>Tipo de Trabajador</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trabajadores}" var="trabajador">
				<tr>
					<td>${trabajador.id}</td>
					<td>${trabajador.nombre}</td>
					<td>${trabajador.apellido}</td>
					<td>${trabajador.empresa.nombre}</td>
					<td>${trabajador.tipoTrabajador}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
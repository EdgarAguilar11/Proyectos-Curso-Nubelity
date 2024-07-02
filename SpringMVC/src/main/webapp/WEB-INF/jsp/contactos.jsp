<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- directiva de la libreria jstl     -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contactos</title>
</head>
<body>
	<h2>Lista de Contactos</h2>
	<h3><a href="nuevoContacto">Agregar Contacto</a></h3>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Dirección</th>
				<th>Teléfono</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="contacto">
				<tr>
					<td>${contacto.id}</td>
					<td>${contacto.nombre}</td>
					<td>${contacto.email}</td>
					<td>${contacto.direccion}</td>
					<td>${contacto.telefono}</td>
					<td>
						<a href="editarContacto?id=${contacto.id}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="borrarContacto?id=${contacto.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
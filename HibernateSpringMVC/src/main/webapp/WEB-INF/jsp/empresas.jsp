<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>
	<h2>Lista de Empresas</h2>
	<h3><a href="agregarEmpresa">Agregar Empresa</a></h3>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empresas}" var="empresa">
				<tr>
					<td>${empresa.id}</td>
					<td>${empresa.nombre}</td>
					<td>${empresa.descripcion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
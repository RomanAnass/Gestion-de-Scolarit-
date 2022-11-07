<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Filières</title>
</head>
<body bgcolor="#F0FFF0">

<h1 style="text-align: center; color: blue">Gestion des Filières<br><img src="${pageContext.request.contextPath}/img/logo.png" align="center" height="65px"></h1>
<hr /> <br />

<div style="width: 50%; position: relative; left: 25% " >
	<form method="post" action="http://localhost:8080/Gestion_ecole/filiere/save">
		<fieldset style="border-color: silver;">
			<legend>${filiereBean.label} d'une Filiere</legend>
			<table width="100%" cellpadding="5">
				<tr>
					<td> ID </td>
					<td> <input type="text" name="id" value="${filiereBean.filiere.id}"
								style="width: 100%; background-color: silver;"
								readonly="readonly" /> </td>
				</tr>
				
				<tr>
					<td> Code </td>
					<td> <input type="text" name="code" value="${filiereBean.filiere.code}"
								style="width: 100%;"/> </td>
				</tr>
				
				<tr>
					<td> Libelle </td>
					<td> <input type="text" name="libelle" value="${filiereBean.filiere.libelle}"
								style="width: 100%;"/> </td>
				</tr>
			
				<tr>
					<td colspan="2" style="text-align: right;"> 
					<input type="submit" value="${filiereBean.label}"/> </td>
				</tr>
				
			</table>
		</fieldset>
	</form>
</div>
<br /><br /> 
<div style="width: 60%; position: relative; left: 20%" >
	<table width="100%" cellpadding="3" border="1" style="text-align: center; border-color: silver;">
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Libelle</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		
		<c:forEach items="${filiereBean.filieres}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.code}</td>
				<td>${f.libelle}</td>
				<td><a href="http://localhost:8080/Gestion_ecole/filiere/modify?id=${f.id}"> <img src="${pageContext.request.contextPath}/img/b_edit.png" /> </a> </td>
				<td><a href="http://localhost:8080/Gestion_ecole/filiere/delete?id=${f.id}"> <img src="${pageContext.request.contextPath}/img/b_drop.png" /> </a> </td>
			</tr>
		</c:forEach>
		
		<tfoot>
			<tr>
				<td colspan="5"> Nombre total des filieres est : ${filiereBean.filieres.size()} </td>
			</tr>
		</tfoot>
	</table>
</div>

</body>
</html>
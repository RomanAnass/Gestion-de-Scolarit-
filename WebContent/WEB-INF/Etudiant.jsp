<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Etudiants</title>
</head>
<body bgcolor="#F0FFF0">

<h1 style="text-align: center; color: blue;">Gestion des Etudiant<br><img src="${pageContext.request.contextPath}/img/logo.png" align="center" height="65px"></h1>
<hr /> <br />

<div style="width: 50%; position: relative; left: 25% " >
	<form method="post" action="http://localhost:8080/Gestion_ecole/etudiant/save">
		<fieldset style="border-color: silver;">
			<legend>${etudiantBean.label} d'un etudiant(s)</legend>
			<table width="100%" cellpadding="5">
				<tr>
					<td> ID : </td>
					<td> <input type="text" name="id" value="${etudiantBean.etudiant.id}"
								style="width: 100%; background-color: silver;"
								readonly="readonly" /> </td>
				</tr>
				
				<tr>
					<td> Nom : </td>
					<td> <input type="text" name="nom" value="${etudiantBean.etudiant.nom}"
								style="width: 100%;"/> </td>
				</tr>
				
				<tr>
					<td> Prenom :  </td>
					<td> <input type="text" name="prenom" value="${etudiantBean.etudiant.prenom}"
								style="width: 100%;"/> </td>
				</tr>
				<tr>
					<td> CNE : </td>
					<td> <input type="text" name="cne" value="${etudiantBean.etudiant.cne}"
								style="width: 100%;"/> </td>
				</tr>
				
				<tr>
					<td>Numéro Filliére </td>
					<td> <input type="text" name="id_f" value="${etudiantBean.etudiant.filiere.id}"
								style="width: 100%;"/> </td>
				</tr>
			
				<tr>
					<td colspan="2" style="text-align: right;"> 
					<input type="submit" value="${etudiantBean.label}"/> </td>
				</tr>
				
			</table>
		</fieldset>
	</form>
</div>

<br /><br /> 
<div style="width: 60%; position: relative; left: 20%" >
	<table width="100%" cellpadding="3" border="1" style="text-align: center;">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>CNE</th>
			<th>Filiére</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		
		<c:forEach items="${etudiantBean.getEtudiants()}" var="e" varStatus="s">
			<tr>
				<td>${e.id}</td>
				<td>${e.nom}</td>
				<td>${e.prenom}</td>
				<td>${e.cne}</td>
				<td>${e.filiere.libelle}</td>
				<td><a href="http://localhost:8080/Gestion_ecole/etudiant/modify?id=${e.id}"> <img src="${pageContext.request.contextPath}/img/b_edit.png" /> </a> </td>
				<td><a href="http://localhost:8080/Gestion_ecole/etudiant/delete?id=${e.id}"> <img src="${pageContext.request.contextPath}/img/b_drop.png" /> </a> </td>
			</tr>
		</c:forEach>
		
		<tfoot>
			<tr>
				<td colspan="7"> Nombre total des Etudiant est : ${etudiantBean.getEtudiants().size()} </td>
			</tr>
		</tfoot>
	</table>
</div>

</body>
</html>
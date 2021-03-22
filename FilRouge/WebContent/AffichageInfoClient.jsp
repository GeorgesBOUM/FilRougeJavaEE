<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Affichage infos client</title>
		<link type="text/css" rel="stylesheet" href="/inc/style.css" />
	</head>
<body>
	<p>${message }</p>
	<p>Nom : ${client.nom }</p>
	<p>Prénom : ${client.prenom }</p>
	<p>Adresse : ${client.adresseLivraison}</p>
	<p>Téléphone : ${client.telephone }</p>
	<p>Email : ${client.mail }</p>
	<c:import url="/inc/Menu.jsp"></c:import>
</body>
</html>
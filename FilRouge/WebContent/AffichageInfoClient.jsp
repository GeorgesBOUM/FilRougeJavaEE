<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Affichage infos client</title>
	</head>
<body>
	<p>${message }</p>
	<p>Nom : ${client.nom }</p>
	<p>Prénom : ${client.prenom }</p>
	<p>Adresse : ${client.adresseLivraison}</p>
	<p>Téléphone : ${client.telephone }</p>
	<p>Email : ${client.mail }</p>
</body>
</html>
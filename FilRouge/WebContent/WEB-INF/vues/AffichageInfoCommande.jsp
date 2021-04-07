<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Affichage info commande</title>
		<link rel="stylesheet" type="text/css" href='<c:url value="inc/style.css"></c:url>'>
	</head>
<body>
	<p class="info">${ validation.resultat }</p>
	<p>Client</p>
	<p>Nom : ${commande.client.nom }</p>
	<p>Prénom : ${commande.client.prenom }</p>
	<p>Adresse : ${commande.client.adresseLivraison}</p>
	<p>Téléphone : ${commande.client.telephone }</p>
	<p>Email : ${commande.client.mail }</p>
	<br>
	<p>Commande</p>
	<p>Date : </p>
	<p>Montant : ${commande.montant }</p>
	<p>Mode de paiement : ${commande.modePaiement }</p>
	<p>Statut du paiement : ${commande.statutPaiement }</p>
	<p>Mode de livraison : ${commande.modeLivraison }</p>
	<p>Statut de la livraison : ${commande.statutLivraison }</p>
	<c:import url="/inc/Menu.jsp"></c:import>
</body>
</html>
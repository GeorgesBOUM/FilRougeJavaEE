<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulaire création commande</title>
		<link type="text/css" rel="stylesheet" href='<c:url value="inc/style.css"></c:url>' />
	</head>
	<body>
		 <div>
            <form method="post" action="CreationCommande">
            	<c:set var="client" value="${ commande.client }" scope="request" />
                <fieldset>
                    <legend>Informations client</legend>                    
                    <!--
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value='${nom }' size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value='${prenom }' size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" value='${adresse }' size="20" maxlength="20" />
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value='${telephone }' size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value='${mail }' size="20" maxlength="60" />
                    <br />
                    -->
                    <c:import url="/inc/IncFormulaireClient.jsp"></c:import>
                </fieldset>
                
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="<c:out value="commande.montant"/>" size="20" maxlength="20" />
                    <span class="erreur">${validation.erreurs[montantCommande] }</span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="<c:out value="commande.modePaiement"/>" size="20" maxlength="20" />
                    <span class="erreur">${validation.erreurs[modePaiementCommande] }</span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="<c:out value="commande.statutPaiement"/>" size="20" maxlength="20" />
                    <span class="erreur">${validation.erreurs[statutPaiementCommande] }</span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="<c:out value="commande.modeLivraison"/>" size="20" maxlength="20" />
                    <span class="erreur">${validation.erreurs[modeLivraisonCommande] }</span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value=<c:out value="commande.statutLivraison"/> size="20" maxlength="20" />
                    <span class="erreur">${validation.erreurs[statutLivraisonCommande] }</span>
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
            <p class="info">${ validation.resultat }</p>
        </div>
	</body>
</html>
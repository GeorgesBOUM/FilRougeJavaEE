<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">
    <p><a href="<c:url value="/CreationClient" var="lienFormClient"/>">Créer un nouveau client</a></p>
    <p><a href="<c:url value="/CreationCommande" var="lienFormCommande"/>">Créer une nouvelle commande</a></p>
</div>
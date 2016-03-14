<%-- 
    Document   : _MENU
    Created on : 8 mars 2016, 14:59:05
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu">
    <div>Bonjour ${sessionScope.login}</div>
    <c:if test="${sessionScope.login==null}">
        <div class="bouton"><a href="login_servlet">S'identifier</a></div>
    </c:if>
    <c:if test="${sessionScope.login!=null}">
        <div class="bouton"><a href="deconnexion">Se deconnecter</a></div>
    </c:if>
    <br>
    <div class="bouton"><a href="detail_compte">Mon compte</a></div>
    <br>
    <div class="bouton"><a href="ajouter_enchere">Ajouter une enchere</a></div>
    <br>
    <div class="bouton"><a href="lister_article">Voir les encheres</a></div>
    <br>
    <div class="bouton"><a href="ajouter_categorie">Ajouter categorie</a></div>
    <br>
    <div class="bouton"><a href="inscription">Inscription</a></div>
    <input type="hidden" name="util" value="${sessionScope.login}"/>
</div>
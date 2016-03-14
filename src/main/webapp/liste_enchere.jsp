<%-- 
    Document   : TEMPLATE
    Created on : 8 mars 2016, 14:59:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENCHERE</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <h2>Liste des encheres :</h2>

            <table  class="table">
                <tr>
                    <td> NOM </td>
                    <td>DESCRIPTION</td>
                    <td>PRIX ACTUEL</td>
                    <td>DATE DE FIN</td>
                    <td>VENDEUR</td>
                    <td>SURENCHERISSEUR ACTUEL</td>
                </tr>
                <c:forEach items="${articles}" var="article">
                    <tr>
                        <td>${article.nom}</td>
                        <td>${article.description}</td>
                        <td>${article.prixActuel}</td>
                        <td>${article.dateFinal}</td>
                        <td>${article.createur.login}</td>
                        <td>${article.encherisseur.login}</td>

                        <c:if test="${article.encherisseur.login!=sessionScope.login && article.createur.login!=sessionScope.login}">
                            <td><a href="encherir?idArticle=${article.id}"> Encherir </a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>

    </body>
</html>

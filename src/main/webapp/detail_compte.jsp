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
            <h2>Articles crees :</h2>
            <table  class="table">
                <tr>
                    <td> NOM </td>
                    <td>DESCRIPTION</td>
                    <td>PRIX ACTUEL</td>
                    <td>DATE DE FIN</td>
                    <td>SURENCHERISSEUR ACTUEL</td>
                </tr>
                <c:forEach items="${articlesCrees}" var="articlesCrees">
                    <tr>
                        <td>${articlesCrees.nom}</td>
                        <td>${articlesCrees.description}</td>
                        <td>${articlesCrees.prixActuel}</td>
                        <td>${articlesCrees.dateFinal}</td>
                        <td>${articlesCrees.encherisseur.login}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <h2>Articles gagnes :</h2>
            <table  class="table">
                <tr>
                    <td> NOM </td>
                    <td>DESCRIPTION</td>
                    <td>PRIX FINAL</td>
                    <td>DATE DE FIN</td>
                    <td>VENDEUR </td>
                    <td> ETAT</td>
                </tr>
                <c:forEach items="${articlesGagnees}" var="articlesGagnees">
                    <tr>
                        <td>${articlesGagnees.nom}</td>
                        <td>${articlesGagnees.description}</td>
                        <td>${articlesGagnees.prixVente}</td>
                        <td>${articlesGagnees.dateFinal}</td>
                        <td>${articlesGagnees.createur.login}</td>
                        <td>${articlesGagnees.statut}</td>
                        <c:if test="${articlesGagnees.statut!='PAYE'}">
                            <td><a href="payer?idArticle=${articlesGagnees.id}"> Payer </a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <h2>Historique des encheres :</h2>
            <table  class="table">
                <tr>
                    <td> NOM </td>
                    <td>DESCRIPTION</td>
                    <td>SOMME ENCHERI</td>
                    <td>DATE DE FIN</td>
                    <td>VENDEUR </td>
                    <td>SURENCHERISSEUR ACTUEL</td>
                </tr>
                <c:forEach items="${encheres}" var="encheres">
                    <tr>
                        <td>${encheres.article.nom}</td>
                        <td>${encheres.article.description}</td>
                        <td>${encheres.sommeEnchere}</td>
                        <td>${encheres.article.dateFinal}</td>
                        <td>${encheres.article.createur.login}</td>
                        <td>${encheres.article.encherisseur.login}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

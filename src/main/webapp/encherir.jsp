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
        <title>ENCHERIR</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <form action="encherir" method="post">
                <table  class="table">
                    <tr>
                        <td> <label>Nom de l'article</label></td>
                        <td>${article.nom}</td>
                    </tr>
                    <tr>
                        <td> <label>Description</label></td>
                        <td>${article.description}</td>
                    </tr>
                    <tr>
                        <td> <label>Description</label></td>
                        <td>${article.dateFinal}</td>
                    </tr>
                    <tr>
                        <td> <label>Description</label></td>
                        <td>${article.prixActuel}</td>
                    </tr>
                    <tr>
                        <td> <label>Somme que vous souhaitez encherir</label></td>
                        <td><textarea name="somme"></textarea></td>
                    </tr>
                </table>
                <input type="submit"/>
                <input type="hidden" name="id" value="${article.id}"/>
                <input type="hidden" name="util" value="${sessionScope.login}"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>

    </body>
</html>

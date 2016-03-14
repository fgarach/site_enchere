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
        <title>STREAMING</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/>
        <div class="contenu"> 
            <form action="ajouter_enchere" method="post">
                <table  class="table">
                    <tr>
                        <td> <label>Nom de l'annonce</label></td>
                        <td><textarea name="nom"></textarea></td>
                    </tr>
                    <tr>
                    <tr>
                        <td> <label>Description</label></td>
                        <td><textarea name="description"></textarea></td>
                    </tr>
                    <tr>
                        <td> <label>Prix de depart</label></td>
                        <td><textarea name="prix"></textarea></td>
                    </tr>
                    <tr>
                        <td> <label>Categorie</label></td>
                        <td>
                            <select multiple="true" name="categorie">
                                <c:forEach var="cat" items="${categories}" varStatus="loop">
                                     <option value="${cat.id}">${cat.nom}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> <label>Duree de l'enchere en jours</label></td>
                        <td>
                            <select multiple="true" name="duree">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="util" value="${sessionScope.login}"/>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

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
            <form action="ajouter_categorie" method="post">
                <table  class="table">
                    <tr>
                        <td> <label>Nom des categories existantes</label></td>
                        <td><c:forEach var="cat" items="${categories}" varStatus="loop">
                                ${cat.nom}
                                <br>
                            </c:forEach></td>
                    </tr>
                    <tr>
                    <tr>
                        <td> <label>Nouvelle categorie</label></td>
                        <td><textarea name="nom"></textarea></td>
                    </tr>
                </table>
                <input type="hidden" name="util" value="${sessionScope.login}"/>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

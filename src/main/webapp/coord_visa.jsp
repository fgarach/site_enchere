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
             <form action="saisi_visa" method="post">
                <table  class="table">
                    <tr>
                        <td> Coordonnées bancaires<td>
                    </tr>
                    <tr>
                        <td> <label>Nom</label></td>
                        <td><textarea name="nom"></textarea></td>
                    </tr>
                    <tr>
                    <tr>
                        <td> <label>Numero de carte</label></td>
                        <td><textarea name="num"></textarea></td>
                    </tr>
                    <tr>
                        <td> <label>criptogramme</label></td>
                        <td><textarea name="cripto"></textarea></td>
                    </tr>
                </table>
                <input type="hidden" name="idArticle" value="${idArticle}"/>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>

    </body>
</html>

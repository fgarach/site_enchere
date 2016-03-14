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
            <form action="inscription" method="post">
                <table  class="table">
                    <tr>
                        <td> <label>Login</label></td>
                        <td><textarea name="login"></textarea></td>
                    </tr>
                    <tr>
                        <td> <label>Mot de passe</label></td>
                        <td><textarea name="mdp"></textarea></td>
                    </tr>
                </table>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

<%-- 
    Document   : login
    Created on : 19/02/2017, 12:19:19 PM
    Author     : david
--%>
<% 
    if(session.getAttribute("username") != null)
    response.sendRedirect("profile.jsp");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
    <h1>Bienvenido</h1>
    <form action="LoginController" method="POST">
        
        Usuario
        <input type="text" name="username">
        <br>
        <br>
        Contraseña
        <input type="password" name="password">
        <br>
        <br>
        <input type="submit" name="iniciar" value="Ingresar">
    </form>
    </body>
</html>


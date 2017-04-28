<%-- 
    Document   : login
    Created on : 19/02/2017, 12:19:19 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <form action="LoginController">
        Usuario:
        <input type="text" name="username">
        <br>
        Contraseña:
        <input type="password" name="password">
        <br>
        Nombre:
        <input type="text" name="nombre"/>
        <br>
        Apellidos:
        <input type="text" name="apellidos"/>
        <br>
        E-mail:
        <input type="text" name="ema"/>
        <br>
        Ocupacion:
        <input type="text" name="ocu"/>
        <br>
        <input type="submit" value="Iniciar sesion">
        </form>
    </body>
</html>

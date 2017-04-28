<%-- 
    Document   : profile
    Created on : 10/03/2017, 11:01:24 PM
    Author     : david
--%>


<%
    if (session.getAttribute("username")== null){
    response.sendRedirect("login.jsp");
    }
    Cookie []c = request.getCookies();
    String value = "";
    for(int i = 0; i<c.length;i++){
        String nombre = c[i].getName();
        if(nombre.equals("Color")){
            value = c[i].getValue();
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body style="background-color: <%=value%>">
        <h1>Hola <%= session.getAttribute("username") %> </h1>
        <form action="ProfileController">
            <label>Color: </label>
            <select name="color">
                <option value="red">red</option>
                <option value="blue">blue</option>
                <option value="green">green</option>
            </select>
            <br>
            <br>
            <a href="LogoutController" onclick="document.form.submit();">Cerrar sesion</a>
            <br>
            <br>
            <input type="submit" value="Guardar"/>
        </form>
        
    </body>
</html>

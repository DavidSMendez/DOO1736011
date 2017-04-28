<%-- 
    Created on : 18/03/2017, 11:52:46 PM
    Author     : david
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.ComentariosPOJO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form method="POST" action="ComentariosControlador">
            Nombre:
            <br><br/>
            <input type="text" value="" name="nombre">
            <br><br/>
            Comentario:
            <br><br/>
            <textarea rows="5" name="comentario"></textarea>
            <input type="submit">
            <input type="hidden" name="action" value="buscar">
        </form>
        
        <%  if(session != null){
            ArrayList  comentarios = (ArrayList)session.getAttribute("comentarios");
            if(comentarios!=null){
        %>
               <table border="1">
                   <tr>
                       <th>Nombre: </th>
                       <th>Comentario: </th>
                   </tr>
                   
               <% 
                   for(Object adn : comentarios){
                       ComentariosPOJO comentario = (ComentariosPOJO) adn;
               %>    
                   <tr>
                       <td><%=comentario.getNombre()%></td>
                       <td><%=comentario.getComentario()%></td>
                   </tr>
               <%  } %>    
               </table>
            <%  }
                }%>
    </body>
</html>

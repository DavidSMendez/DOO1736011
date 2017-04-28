
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Log;

/**
 *
 * @author Jorge David Sosa Méndez 1736011
 */

public class ComentariosDAO {

    Log L;
    
    private Connection conexion;

    public ComentariosDAO() {
        this.L = Log.getInstance("C:\\Users\\david\\Desktop\\Text.txt");
    }
    private void abrirConexion() throws SQLException{

        String dbURI = "jdbc:derby://localhost:1527/Comentarios";
        String username = "fcfm";
        String password = "lsti01";
        conexion = DriverManager.getConnection(dbURI, username, password);
    }

    private void cerrarConexion() throws SQLException{

        conexion.close();

    }

    public void insertar(ComentariosPOJO dm){

        try{
           abrirConexion();
        
           String sqlInsert = "insert into COMNTARIOS values ('"+dm.getNombre()+"','"+dm.getComentario()+"')";
           Statement stmen = conexion.createStatement();
           stmen.executeUpdate(sqlInsert);
           cerrarConexion();
           
       }catch(Exception ex){
            L.write("Ha ocurrido un error");
       }
    }
    public ArrayList buscar(ComentariosPOJO pp){
        ResultSet regis ;
        ArrayList<ComentariosPOJO> comentarios = new ArrayList();
        try{
            abrirConexion();
            String sqlBuscar = "select * from COMENTARIOS where NOMBRE = '" + pp.getNombre()+"' and COMENTARIO like '%"+pp.getComentario()+ "%'";            
            Statement stmen = conexion.createStatement();
            ResultSet mensajes = stmen.executeQuery(sqlBuscar);
            
            while(mensajes.next()){
            
                String nombre = mensajes.getString("Nombre");
                String comentario = mensajes.getString("Comentario");
                ComentariosPOJO comment = new ComentariosPOJO();
                comment.setNombre(nombre);
                comment.setComentario(comentario);
                comentarios.add(comment);
            }
            cerrarConexion();
        }catch(Exception ex){
            L.write("Ha ocurrido un error");
        }
        return comentarios;
    }
    
}

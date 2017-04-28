/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week5.models;

/**
 *
 * @author david
 */
public class User {

    private String username;
    private String password;
    private String ema;
    private String ocu;
    private String nombre;
    private String apellidos;

    public User(String username, String password, String ema, String ocu, String nombre, String apellidos) {
        this.username = username;
        this.password = password;
        this.ema = ema;
        this.ocu = ocu;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return this.username;
    }
}
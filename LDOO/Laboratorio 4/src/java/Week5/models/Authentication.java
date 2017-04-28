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
public class Authentication {

    public static boolean authenticate(String username, String password, String ema, String ocu, String nombre, String apellidos) {

        //Variables *dummy*.
        //Se hardcodean los valores "Miguel" y "MiPassword" para emular que se obtuvieron de una base de datos
        String userDataBase = "Miguel";
        String passwordDataBase = "MiPassword";
        String emaDataBase = "davids";
        String ocuDataBase = "Lsti";
        String nombreDataBase = "Miguel" ;
        String apellidosDataBase = "Salazar";

        //username.equals(userDataBase) realiza una comparación entre las cadenas username y userDataBase
        //Si son iguales devuelve true. Si son diferentes devuelve false.
        if(username.equals(userDataBase) && password.equals(passwordDataBase) && ema.equals(emaDataBase) && ocu.equals(ocuDataBase) && nombre.equals(nombreDataBase)&& apellidos.equals(apellidosDataBase)) {
            return true;
        }
        else {
            return false;
        }
    }
}
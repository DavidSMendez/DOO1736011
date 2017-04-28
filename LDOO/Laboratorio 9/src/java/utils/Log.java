/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Jorge David Sosa Méndez 1736011
 */
public class Log {
    final String fileName;
    private static Log instance;

    public Log(String fileName) {
        this.fileName = fileName;
    }
    
    public static  Log getInstance(String fileName){
        if(instance == null) {
            return new Log(fileName);
        }
        
            return instance;
    }
    public void write(String message){
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) { 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            String data = "\n" + dateFormat.format(cal.getTime()) + ": " + message ;
            br.write(data);
        }
        catch(Exception ex){
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilo1;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdeni
 */
public class Hilo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int datos[] = new int[100000];
        Random rnd = new Random();
        for(int i=0; i < datos.length;i++)
            datos[i]= rnd.nextInt(2);
        
        Contador con = new Contador(datos);
        Thread hilo_con = new Thread(con);
        
        hilo_con.start();
        
       while( hilo_con.isAlive()==true)
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        
        System.out.println("Cuenta es :"+ con.getResp());
        
        
    }
    
}

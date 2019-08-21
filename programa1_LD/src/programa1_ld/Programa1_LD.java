/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1_ld;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author mdeni
 */
public class Programa1_LD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        float x;
        float y;
        
        //CREAMOS EL ARREGLO PRINCIPAL
        punto2dd Datoss[]=new punto2dd [100];
        
        //LLENAMOS EL ARREGLO CON OBJETOS punto2dd CON VALORES ALEATORIOS
        for(int i=0; i<Datoss.length; i++)
        {
            x= (float) (Math.random()*10)+0;
            y= (float) (Math.random()*(5+5) )-5;
            Datoss[i]= new punto2dd(x,y);  
        }
        
        //CREAMOS 4 SUB-ARREGLOS PARA TRABAJAR EN CADA HILO
        punto2dd ar1[] = new punto2dd[25];
        punto2dd ar2[] = new punto2dd[25];    
        punto2dd ar3[] = new punto2dd[25];
        punto2dd ar4[] = new punto2dd[25];
        
        //COPIAMOS DATOS DEL ARR PRINCIPAL A LOS SUBARREGLOS
        System.arraycopy(Datoss, 0, ar1, 0, 25);
        System.arraycopy(Datoss, 25, ar2, 0, 25);
        System.arraycopy(Datoss, 50, ar3, 0, 25);
        System.arraycopy(Datoss, 75, ar4, 0, 25);
        
        //CREAMOS 4 CONTADORES PARA CADA HILO
        Contadorr con1 = new Contadorr(ar1);
        Contadorr con2 = new Contadorr(ar2);
        Contadorr con3 = new Contadorr(ar3);
        Contadorr con4 = new Contadorr(ar4);
        
        //CRAMOS 4 HILOS Y CON QUE ARRAYS VA A TRABAJAR
        Thread hilo1=new Thread(con1);
        Thread hilo2=new Thread(con2);
        Thread hilo3=new Thread(con3);
        Thread hilo4=new Thread(con4);
        
        //INICIAMOS LOS HILOS
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        while(hilo1.isAlive() || hilo2.isAlive() || hilo3.isAlive() || hilo4.isAlive())
        {
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
        
        
        //SUMAMOS E IMPRIMIMOS LOS TOTALES DE CADA HILO
        float TOTAL = con1.getResultado() + con2.getResultado() + con3.getResultado() + con4.getResultado();
        System.out.println("Resultado Genral es:" + TOTAL);
        
        
        
        
        
        
    }   
    
}

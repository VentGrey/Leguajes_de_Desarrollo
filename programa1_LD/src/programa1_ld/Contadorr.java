/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1_ld;

/**
 *
 * @author mdeni
 */
public class Contadorr implements Runnable{
    
    // PASAR PARAMETROS CON LOS QUE TRABAJARÁ E INSTANCIAR 
    private punto2dd [] Datoss;
    private float Resultado;
    

    public Contadorr(punto2dd[] Datoss) {
        this.Datoss = Datoss;
        this.Resultado=Resultado;
    }

    public float getResultado() {
        return Resultado;
    }

    @Override
    public void run() {
        //HACER EL CÁLCULO DE LA FUNCIÓN X2 +2Y -X Y LO SUMA EN LA VARIABLE "Resultado"
        for(int i=0; i<this.Datoss.length;i++)
        {
                                //x al cuadrado
           Resultado= Resultado +(((Datoss[i].getX())*(Datoss[i].getX()))
                                // + 2y
                                +(2*(Datoss[i].getY()))
                                //  -x
                                -(Datoss[i].getX()));    
        }  
    }
    
    
    
    
}

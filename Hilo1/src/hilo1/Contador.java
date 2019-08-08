/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilo1;

/**
 *
 * @author mdeni
 */
public class Contador implements Runnable{
    
    private int arr[];
    private int resp;

    public Contador(int[] arr) {
        this.arr = arr;
        resp=0;
    }

    public int getResp() {
        return resp;
    }

    @Override
    public void run() {
        
          for(int i=0; i < arr.length;i++)
            resp = arr[i]+resp;
    }
    
    
    
    
    
    
    
}

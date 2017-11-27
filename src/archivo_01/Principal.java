/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo_01;

import java.io.File;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) 
    {        
      VentanaArbol v = new VentanaArbol("Hola");
      v.setDefaultCloseOperation(3);
      v.setVisible(true);
      System.out.println("Esta es la línea de prueba que estamos manejando versión 2.0");
      System.out.println("Esta es la línea de prueba que estamos manejando versión 3.0");
      System.out.println("Esta es la línea de prueba que estamos manejando versión 4.0");
      v.metodoSuma(89, 100);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package least_squarescovid.pkg19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author juan
 */
public class Leer {
    private double clausulas [][];

    public Leer(String url) {
        leer(url);
    }
  private void leer(String url){
      LinkedList<String> lista = new LinkedList<String>();
      try {
         File file = new File(url);
         FileReader read = new FileReader(file); 
         BufferedReader buffer = new BufferedReader(read);
         String linea = buffer.readLine();
         lista.add(linea);
            while ((linea=buffer.readLine())!=null) {                
               //System.out.println(linea); 
            lista.add(linea);
            }//cierra while
      } catch (Exception e) {
          System.err.println("error");
      }
      limpia(lista);
   }
  private void limpia(LinkedList<String> lista){
      String linea= lista.get(0);
      String col[]=linea.split(",");
      int columnas =col.length;
       clausulas=new double [lista.size()-1][columnas];
        for (int i = 1; i <=clausulas.length; i++) {
            linea=lista.get(i);
            col=linea.split(",");
            for (int j = 0; j < clausulas[0].length; j++) {
                clausulas[i-1][j]=Double.valueOf(col[j]);
            }
      }
  }

    public double[][] getClausulas() {
        return clausulas;
    }
}

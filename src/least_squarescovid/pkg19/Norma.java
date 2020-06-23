/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package least_squarescovid.pkg19;

/**
 *
 * @author juan
 */
public class Norma {
    double[][] lstNormal = new double[0][0];

    
    
    public void ejecutar(double[][] lst){
        lstNormal = new double[lst.length][lst[0].length];
        
        for (int i = 0; i < lst.length; i++) {
            lstNormal[i] = dividir(lst[i]);
        }
        
    }
    
    public double[][] getNorma(){
        return lstNormal;
    }
    
    private double[] dividir(double[] obj){
        double norma = normalizar(obj);
        for (int i = 0; i < obj.length; i++) {
            obj[i] = (obj[i]/norma);
            //obj.getLstVector().set(i, obj.getLstVector().get(i)/norma);
        }
        return obj;
    }
    
    private double normalizar(double[] obj){
        double result = 0;
        result = Opera.productoPunto(obj, obj);
        result = Math.sqrt(result);
        return result;
    }
    
    
     public void imprimir(){
        String cadena = "";
        for (int i = 0; i < lstNormal.length; i++) {
            for (int j = 0; j < lstNormal[i].length; j++) {
                cadena += lstNormal[i][j] + "\t";
            }
            cadena += "\n";
            
        }
        System.out.println("Resultado\n" + cadena);
    }
}

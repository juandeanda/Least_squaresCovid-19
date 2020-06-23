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
public class Opera {
    public static double[] SumVec(double[] v, double[] u){
        double result = 0;
        double[] lst = new double[u.length];
         
        for (int i = 0; i < u.length; i++) {
            result =  v[i] + u[i];
            lst[i] = result;
        }
        return lst;
    }
    
    public static double[] RestaVec(double[] v, double[] u){
        double result = 0;
        double[] lst = new double[u.length];
         
        for (int i = 0; i < u.length; i++) {
            result =  v[i] - u[i];
            lst[i] = result;
        }
        return lst;
    }
    
    public static double productoPunto(double[] u, double[] v){
        double result = 0;
                
        for (int i = 0; i < u.length; i++) {
            result +=  u[i] * v[i];
        }
        return result;
    }
    
    public static double[] productoEscalar(double escalar, double[] u){
        double[] lst = new double[u.length];
        double result = 0;
                
        for (int i = 0; i < u.length; i++) {
            result =  (u[i] * escalar);
            lst[i] = result;
        }
        return lst;
    }
}

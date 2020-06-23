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
public class Least_squaresCovid19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double datos [][];
        reflexion objref = new reflexion();
        
        String url = args[0];
        String modelo = args[1];
        int grado = Integer.valueOf(args[2]);
        double alfa = Double.valueOf(args[3]);
        double beta = Double.valueOf(args[4]);
        double dEpsilon = Double.valueOf(args[5]);
        
        Leer objleer = new Leer(url);
        datos = objleer.getClausulas();
        objref.esqui(modelo,datos,grado,0,dEpsilon,alfa,beta);
        System.out.println(objref.getdError());
    }
    
}

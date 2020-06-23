/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package least_squarescovid.pkg19;

import java.util.LinkedList;

/**
 *
 * @author juan
 */
public class Ortogonal {
    private double vector[][] = new double[0][0];
    private double vectorOrto[][] = new double[0][0];
    private double num = 0;
    private double den = 0;
    private Norma norma = new Norma();
    private LinkedList<LinkedList> proyecta;
   

    public Ortogonal(double[][] vector) {
//        this.vector = vector;
//        this.vectorOrto = vector;
        proyecta = new LinkedList<>();
        LinkedList<Double> aux = new LinkedList<Double>();
        aux.add(0.0);
        proyecta.add(aux);
        this.vector= new double [vector.length][vector[0].length];
        this.vectorOrto = new double [vector.length][vector[0].length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                this.vector[i][j]=vector[i][j];
                this.vectorOrto[i][j]=vector[i][j];
            }
        }
        
    }
    
    public double[][] getMatrizOrtogonal(){
        return vectorOrto;
    }
    
    public double[][] getMatrizOrtoNormal(){
        return norma.getNorma();
    }
    
    
    public void ejecutar( ){        
        for (int i = 1; i < vector.length; i++) {
            double proyAux[] = proyeccion(vectorOrto, vector[i], i);
            proyAux = Opera.RestaVec(vector[i], proyAux);
            vectorOrto[i] = proyAux;
        }
        //imprimir();        
        //norma.ejecutar(vectorOrto);
        //norma.imprimir();
    }
    
    private double[] proyeccion(double[][] u, double[] v, int stop){
        double[] objAux = new double[v.length];
        LinkedList<Double> aux = new LinkedList<>();
        for (int i = 0; i < stop; i++) {
            num = Opera.productoPunto(u[i], v);
            den = Opera.productoPunto(u[i], u[i]);
            num = num/den;
            aux.add(-1.0*num);
            double[] Aux = Opera.productoEscalar(num, u[i]);
            objAux = Opera.SumVec(Aux, objAux);
        }
        proyecta.add(aux);
        return objAux;
    }
    
    public void imprimir(){
        String cadena = "";
        for (int i = 0; i < vectorOrto.length; i++) {
            for (int j = 0; j < vectorOrto[i].length; j++) {
                cadena += vectorOrto[i][j] + "\t";
            }
            cadena += "\n";
            
        }
        System.out.println("Resultado\n" + cadena);
    }

    public LinkedList<LinkedList> getProyecta() {
        return proyecta;
    }
}

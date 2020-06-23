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
public class Matrices {
    private double[] dMatrizB,h,dMatrizA;
    private double[][] dMatrizC;
    private double[][] dInversaMatrizC;
    private operaciones oOperacion;
    private double[][] dDatos,dOrtho,dV;
    private int iGrado;
    private double alfa,beta;
    private double [] Â;
    public double[] getdMatrizB() {
        return dMatrizB;
    }

    public double[][] getdMatrizC() {
        return dMatrizC;
    }

    public Matrices(operaciones oOperacion, double[][] dDatos, int iGrado, double alfa,double beta) {
        this.oOperacion = oOperacion;
        this.dDatos = dDatos;
        this.iGrado = iGrado;
        this.alfa = alfa;
        this.beta = beta;
        //pq(iGrado);
        //mCalculaMatrizC();
        //mCalculaMatrizB();
        //h_k();
        //calcula();
        MatrizDatos();
    }
    private double [][] MatrizDatos(){
        double v[][]= new double[iGrado+1][dDatos.length];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                v[i][j]=oOperacion.calculo(dDatos[j][1],alfa,beta,i);
            }
        }
        dV = v;
        Orto(v);
        return v;
    }

    public double[][] getdV() {
        return dV;
    }
    
    private double [][] Orto(double v[][]){
        double u[][];
        LinkedList<LinkedList> proy;
        LinkedList<Double> aux,a;
        Ortogonal objOrt = new Ortogonal(v);
        objOrt.ejecutar();
        u=objOrt.getMatrizOrtogonal();
        proy = objOrt.getProyecta();
        dOrtho=u;
//        System.out.println("proyección");
//        for (int i = 0; i < proy.size(); i++) {
//            aux = proy.get(i);
//            for (int j = 0; j < aux.size(); j++) {
//                System.out.print(aux.get(j)+" ");
//            }
//            System.out.println();
//        }
        aux = proy.getLast();
        double bks[][]= new double[proy.size()][aux.size()+1];
        for (int k = 0; k < bks.length; k++) {
            bks[k][k]=1.0;
        }
        double suma;
        for (int k = 1; k<proy.size(); k++) {
            a = proy.get(k);
            for (int s = 0; s< k; s++) {
                suma=0.0;
                for (int t = 0; t <= k-s-1; t++) {
                    suma+=a.get(k-(t+1))*bks[k-(t+1)][s];
                }
                bks[k][s]=suma;
            }
        }
//        System.out.println("******** bks *******");
//        for (int i = 0; i < bks.length; i++) {
//            for (int j = 0; j < bks[0].length; j++) {
//                System.out.print(bks[i][j]+" ");
//            }
//            System.out.println();
//        }
        mCalculaMatrizB(dOrtho);
        h_k(dOrtho);
        calcula();
        mDarÂ(bks);
        return u;
    }
    public double [][] Transpuesta(double u[][]){
         double ut[][] = new double[u[0].length][u.length]; 
            for (int j = 0; j < ut.length; j++) {
                for (int k = 0; k < ut[0].length; k++) {
                    ut[j][k]=u[k][j];
                }
            }
          return ut;
    }
    public double [][]producto(double u[][],double ut[][]){
       double producto[][]= new double [u.length][u.length];
            for (int j = 0; j < u.length; j++) {
                for (int k = 0; k < ut[0].length; k++) {
                    for (int l = 0; l < u[0].length; l++) {
                        producto[j][k]+=u[j][l]*ut[l][k];
                    }
                }
            }
       return producto;
   }
    private void mCalculaMatrizC (){
//        int l = ((iGrado+1)*(iGrado+2))/2;
//        dMatrizC = new double[l][l];
//        double dSuma;
//        for (int k = 0; k < l; k++) {
//            for (int j = 0; j < l; j++) {
//                dSuma = 0.0;
//                for (int i = 0; i < dDatos.length; i++) {
//                    dSuma += dDatos[i][0]*oOperacion.calculo(dDatos[i][1],dDatos[i][2],pq[k][0],pq[k][1])*oOperacion.calculo(dDatos[i][1],dDatos[i][2], pq[j][0],pq[j][1]);
//                } // fin for i
//                dMatrizC[k][j]= dSuma;
//               } // fin for j
//        } // fin for k
//        for (int i = 0; i < dMatrizC.length; i++) {
//            for (int j = 0; j < dMatrizC[0].length; j++) {
//                System.out.print(dMatrizC[i][j]+" ");
//            }
//            System.out.println();
//        }
//        dMatrizC = new double[iGrado+1][iGrado+1];
//        double dSuma;
//        for (int k = 0; k <= iGrado; k++) {
//            for (int j = 0; j <= iGrado; j++) {
//                dSuma = 0.0;
//                for (int i = 0; i < dDatos.length; i++) {
//                    dSuma += dDatos[i][0]*(oOperacion.calculo(dDatos[i][1],alfa,beta,k)*oOperacion.calculo(dDatos[i][1],alfa,beta,j));
//                } // fin for i
//                dMatrizC[k][j]= dSuma;
//               } // fin for j
//        } // fin for k
    } // fin método mCalculaMatrizC

    private  void mCalculaMatrizB (double orth[][]){
        dMatrizB = new double[iGrado+1];
        double dSuma;
        for (int k = 0; k <= iGrado; k++) {
                dSuma = 0.0;
                for (int i = 0; i < dDatos.length; i++) {
                    
                    dSuma += dDatos[i][0]*orth[k][i]*dDatos[i][2];
                } // fin for i
                dMatrizB[k] = dSuma;
        } // fin for k
    } // fin método mCalculaMatrizB
   private void h_k(double orth[][]){
       h = new double[iGrado+1];
       double dSuma;
       for (int k= 0; k <= iGrado; k++) {
           dSuma = 0.0;
           for (int i = 0; i < dDatos.length; i++) {
               dSuma+=dDatos[i][0]*(Math.pow(orth[k][i],2));
           }
          h[k]=dSuma;
       }
   }
   public double[] getH() {
        return h;
    }
   private void calcula(){
       dMatrizA = new double [h.length];
       double a=0.0;
       for (int k = 0; k < h.length; k++) {
           dMatrizA[k]=dMatrizB[k]/h[k];
       }
   }
   private void mDarÂ(double bks[][]){
       Â = new double[dMatrizA.length];
       double suma;
       for (int k = 0; k < Â.length-1; k++) {
           suma =0.0;
           for (int s = k+1; s <=iGrado; s++) {
               suma+=dMatrizA[s]*bks[s][k];
           }
           Â[k]=dMatrizA[k]+suma;
       }
       Â[dMatrizA.length-1]=dMatrizA[dMatrizA.length-1];
   }

    public double[] getÂ() {
        return Â;
    }
  
  public double[] getdMatrizA() {
        return dMatrizA;
    }

    public double[][] getdOrtho() {
        return dOrtho;
    }
  
//  public double [][] junta(double M[][], double B[]){
//         double jun[][]=new double [M.length][M[0].length+1];
//        // System.out.println(jun[0].length);
//         for (int i = 0; i < jun.length; i++) {
//             for (int j = 0; j < jun[0].length; j++) {
//                 if (j==jun[0].length-1) {
//                     jun[i][j]=B[i];
//                     
//                 }
//                 else{
//                     jun[i][j]=M[i][j];
//                 }
//             }
//      }
//         return jun;
//  }  
public double [][] mEvaluRecu(double datos [][], double dMatrizA []){
    double [][] dMatrizRec = new double [datos.length][2];
    double suma;
                    for (int j = 0; j < datos.length; j++) {
                           dMatrizRec[j][0]=datos[j][1];
                           suma=0.0;
                        for (int k = 0; k < dMatrizA.length; k++) {
                           suma+=oOperacion.calculo(datos[j][1],alfa,beta,k)*dMatrizA[k];
                        }
                       dMatrizRec[j][1] = suma;
                    }
      return dMatrizRec;
}    
  public double mError(double [][] datos, double [][] dMatrizR, int m){
     double sigma, suma=0.0;
       for (int i = 0; i < datos.length; i++) {
          suma+=Math.pow(datos[i][2]-dMatrizR[i][1], 2);
           //System.out.println(datos[i][2]+" "+dMatrizR[i][1]);
      }
     sigma = Math.sqrt(suma/(datos.length-(m+1)));
     return sigma;
  }
//  private void pq(int grado){
//      int coef = ((grado+2)*(grado+1))/2;
//      int r=0;
//      System.out.println(coef);
//      int pq [][] = new int [coef][2];
//      for (int i = 0; i <= grado; i++) {
//          for (int j = 0; j <=i; j++) {
//              pq[r][0]=i;
//              pq[r][1]=j;
//              r++;
//          }
//      }
//   this.pq = pq;
//  }

}

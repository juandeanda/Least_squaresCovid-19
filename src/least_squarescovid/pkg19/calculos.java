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
public class calculos {
    public double conbina(double alfa, int k){
            double sqrt;
            sqrt=(puchhamer((-1.0*alfa), k)*Math.pow(-1.0, k))/puchhamer(1.0, k);
        return sqrt;
    }
    private double puchhamer(double alfa, int k){
        double conb=1.0;
        double aux= 0.0;
        if (k==0) {
            conb=1.0;
        }
        else{
            for (double i = 1; i <=k;i++) {
                conb=conb*((alfa+i)-1);
            }
        }
        
        return conb;
    }
}

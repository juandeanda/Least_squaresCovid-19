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
public class GaussJordan {
      private int             numFila    = 0;
    private int             numColum   = 0;
    private double[][]      matriz      = new double[0][0];
    private double          divisor     = 1; 
    private double[]        dCoeficiente = new double[0];
    
    public GaussJordan(double[][] matriz){
        this.matriz = matriz;
        numFila = matriz.length;
        numColum = matriz.length+1;        
    }
    
    public void ejecuta() throws Exception{
        try{
            for(int i=0; i<numFila; i++){
                if(matriz[i][i]==0){
                    //error
                }else{
                    divisor = matriz[i][i];
                    //divide la fila para obtener 1
                    obtenerUno(i);
                    obtenerCero(i);
                }
            }
        }catch(Exception e){
            System.err.println("Error al ejecutar Gauss Jordan \n" + e.toString());
            throw new Exception("Error al ejecutar Gauss Jordan \n" + e.getMessage());
            
        }
    }
    
    private void obtenerUno(int i){
        try{
            for(int j=i; j<numColum; j++){
                matriz[i][j] = matriz[i][j]/divisor;
            }
       }catch(Exception e){
            new Throwable("Error al ejecutar Gauss Jordan \n" + e.getMessage());
            System.err.println("Error al poner en 1 la diagonal principal \n" + e.toString());
        }
    }
    
    private void obtenerCero(int i){
        try{
        for(int j=0; j<numFila; j++){
            if(i!=j){
                double var = matriz[j][i]*-1;
                for(int k=i; k<numColum; k++){
                    matriz[j][k]= (matriz[i][k]*var)+matriz[j][k];
                }
            }
        }
        }catch(Exception e){
            new Throwable("Error al ejecutar Gauss Jordan \n" + e.getMessage());
            System.err.println("Error al realizar operaciones para obtener 0 \n" + e.toString());
        }
    }
    
    public void imprime(){
         System.out.println("\n______Sol_______________\n");
        for(int i=0; i<matriz.length; i++){
            System.out.println("\n");
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + "  ");
            }
        }
        System.out.println("\n_______________________\n");
        
    }
    
//    public String[] getResult(){
//        String[] resultado = new String[numFila];
//        for(int i=0; i<numFila; i++){
//            resultado[i] = String.valueOf(Formatos.getFormatoNumero("#,##0.00", (matriz[i][numColum-1])));
//        }
//        imprime();
//        return resultado;
//    }
    public double[] getCoeficiente(){
        return dCoeficiente;
    }
    
    public String[] getdResult(){
        String[] resultado = new String[numFila];
        dCoeficiente = new double[numFila];
        for(int i=0; i<numFila; i++){
            dCoeficiente[i] = matriz[i][numColum-1];
            if(matriz[i][numColum-1]>=0 && i!=0){                
                resultado[i] = " +" +  String.valueOf(dCoeficiente[i]);
            }else{                
                resultado[i] = " " + String.valueOf(dCoeficiente[i]);
            }
        }
        //imprime();
        return resultado;
    }
}

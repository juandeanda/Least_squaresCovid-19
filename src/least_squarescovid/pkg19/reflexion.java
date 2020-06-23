/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package least_squarescovid.pkg19;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

/**
 *
 * @author juan
 */
public class reflexion {
    private operaciones oOperacion=null;
    private double dError;
    public void esqui(String modelo,double[][] datos, int grado, int iSelec, double dEpsilon,double alfa, double beta){
        double x=0,y=0.0;
        int i=0;
        FileWriter file = null;
        PrintWriter write = null;
        StringWriter wfile =null;
        String nombrec="Clase1";
        String mensa = "hola mundo";
        
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            GaussJordan objGauss;
            wfile = new StringWriter();
            file = new FileWriter(nombrec+".java");
            write = new PrintWriter(wfile);
            //write = new PrintWriter(file);
            //Graficar objGrafica;
               write.println(
                    "import least_squarescovid.pkg19.calculos;\n"+
                    "public class "+nombrec+" implements least_squarescovid.pkg19.operaciones"
                    +" {\n"+
                           " public double calculo(double x, double alfa, double beta, int k){\n"+
                            " double z=0.0,sum=0.0;\n"+
                            "calculos objpolcha = new calculos ();\n"+
                             "if(x == -1.0){\n"+
                             "sum= Math.pow(-1.0,k)*objpolcha.conbina((k+beta),k);\n"+ 
                             "}\n"+
                             "if(x == 1.0){\n"+
                             "sum=objpolcha.conbina((k+alfa),k);\n"+
                             "}\n"+
                             "if(x != 1.0 && x !=-1.0){\n"+
                             "for(int p=0;p<=k;p++){\n"+
                                   "sum+=(objpolcha.conbina((k+alfa),p)*objpolcha.conbina((k+beta),k-p))*"+modelo+";\n"+
                                "}\n"+
                                "sum=sum*Math.pow(2,-k);\n"+
                              "}\n"+
                               "   z=sum;"+
                              "  return z;\n"+
                          "  }\n"+
                         "}");  
            
            
//           System.out.println(wfile.toString());
           JavaFileObject comp = new JavaSourceFromString(nombrec, wfile.toString());
           Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(comp);
           JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);
            boolean success = task.call();
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                System.err.println(diagnostic.getCode());
                System.err.println(diagnostic.getKind());
                System.err.println(diagnostic.getPosition());
                System.err.println(diagnostic.getStartPosition());
                System.err.println(diagnostic.getEndPosition());
                System.err.println(diagnostic.getSource());
                System.err.println(diagnostic.getMessage(null));

            }
            if (success) {
                try {
                      
                    addPath(System.getProperty("user.dir"));
                    Class clsOperaciones = Class.forName(nombrec);
                    this.oOperacion= (operaciones) clsOperaciones.newInstance();
                    double dErr,d=0;
                    double [][] dMatrizR=null;
                    double [] dMatrizA=null;
                    int g;
                    //******** Proceso Manual **********//
                    
                    if (iSelec==0) {
                        Matrices cMatriz = new Matrices(oOperacion,datos,grado,alfa,beta);
//                        double dV [][]=cMatriz.getdV();
//                        for (int j = 0; j < dV.length; j++) {
//                            for (int k = 0; k < dV[0].length; k++) {
//                                System.out.print(dV[j][k]+",");
//                            }
//                            System.out.println();
//                        }
                        
//                        System.out.println("******** producto punto **********");   
//                       double [][] ort = cMatriz.getdOrtho();
//                        for (int j = 0; j < ort.length; j++) {
//                            for (int k = 0; k < ort[0].length; k++) {
//                                System.out.print(ort[j][k]+" ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("nhkk");
//                       double ut[][] = cMatriz.Transpuesta(ort);
//                       double prod [][]= cMatriz.producto(ort, ut);
//                        for (int j = 0; j < prod.length; j++) {
//                            for (int k = 0; k < prod[0].length; k++) {
//                                System.out.print(prod[j][k]+" ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("***** Matriz B *********");
                        double dMatrizB[]=cMatriz.getdMatrizB();
//                        for (int j = 0; j < dMatrizB.length; j++) {
//                            System.out.println(dMatrizB[j]);
//                        }
                        double h_k[]=cMatriz.getH();
//                        System.out.println("******* Matriz H ********");
//                        for (int j = 0; j < h_k.length; j++) {
//                            System.out.println(h_k[j]);
//                        }
                        dMatrizA = cMatriz.getdMatrizA();
//                        System.out.println("****** Matriz A ********");
//                        for (int j = 0; j < dMatrizA.length; j++) {
//                            System.out.println(dMatrizA[j]);
//                        }
                        double dmÂ[]=cMatriz.getÂ();
//                        System.out.println("****** Matriz Â ********");
//                        for (int j = 0; j < dMatrizA.length; j++) {
//                            System.out.println(dmÂ[j]);
//                        }
                        //double dJunta [][]= cMatriz.junta(dMatrizC, dMatrizB);
                        //objGauss = new GaussJordan(dJunta);
//                        objGauss.ejecuta();
//                        objGauss.getdResult();
//                        dMatrizA=objGauss.getCoeficiente();
//                        System.out.println("\n Matriz A");
//                        for (int k = 0; k < dMatrizA.length; k++) {
//                              System.out.println(dMatrizA[k]);
//                        }
                         double R [][]=cMatriz.mEvaluRecu(datos, dMatrizA);
                         dMatrizR = cMatriz.mEvaluRecu(datos, dmÂ);
                         dErr = cMatriz.mError(datos, dMatrizR, grado);
                         this.dError = dErr;
                         for (int j = 0; j < dMatrizR.length; j++) {
                             for (int k = 0; k < dMatrizR[0].length; k++) {
                                 System.out.print(dMatrizR[j][k]+" ");
                             }
                               System.out.println("");
                          }
                         //System.out.println("error="+dErr);
                         //objGrafica = new Graficar(datos, R);
                         //objGrafica = new Graficar(datos, dMatrizR);
                    }
               // ***********Proceso Automático *********///     
                    
                    if (iSelec==1) {
                           LinkedList<Double> lError = new LinkedList<Double>(); 
                           dErr=100000000.0;
                           g=0;
                           while(dErr>dEpsilon){
                                if (g<datos.length) {
                                     d = dErr;
                                    Matrices cMatriz = new Matrices(oOperacion,datos,g,alfa,beta);
                                    dMatrizA= cMatriz.getÂ();
                                    dMatrizR = cMatriz.mEvaluRecu(datos, dMatrizA);
                                    dErr = cMatriz.mError(datos, dMatrizR, g);
                                   lError.add(dErr);
                                   g++;
                               }//fin del if
                                else{
                                    System.out.println("Termino sin encontrar ajuste con ese error");
                                    break;
                                }//fin del else
                           }// fin del while
                         g=g-1;
                        System.out.println("error="+dErr);
                        System.out.println("grado="+g);
                        //objGrafica = new Graficar(datos, dMatrizR);
                        //objGrafica = new Graficar(lError);
                                System.out.println("\n Matriz A");
                                  for (int k = 0; k < dMatrizA.length; k++) {
                                         System.out.println(dMatrizA[k]);
                                  }
                    }
 
                    
                 
                 
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not found: " + e);
                } catch (NoSuchMethodException e) {
                    System.err.println("No such method: " + e);
                } catch (IllegalAccessException e) {
                    System.err.println("Illegal access: " + e);
                } catch (InvocationTargetException e) {
                    System.err.println("Invocation target: " + e);
                }
            }
            } catch (Exception e) {
            System.out.println("error: "+e);
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != file ){   
               file.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
    }
        
    }

    public double getdError() {
        return dError;
    }
    
    
    private void addPath(String s) throws Exception {
        File f = new File(s);
        URL u = f.toURL();
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[]{u});
    }
   
   private class JavaSourceFromString extends SimpleJavaFileObject {

        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }
}

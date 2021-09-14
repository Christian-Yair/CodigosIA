import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class test{
  double []x={4,-3,-7,-8,-10};
  double []y={-12,6,-12,-6.45,-23.5};

  SimpleRegression regression = new SimpleRegression();
  JTextArea resultado = new JTextArea(); 
  

  public static void main (String[] noseusa){
    new test();    
}

  public test(){
    for (int i=0; i<x.length; i++){
      regression.addData(x[i],y[i]);
    }
    double [] y_re = new double [y.length];
    for (int i=0; i<x.length; i++){
      y_re [i] = regression.predict(x[i]);
    }
    resultado.append("\n Datos leidos "+regression.getN());
    resultado.append("\n Ordenada al origen "+regression.getIntercept());
    resultado.append("\n Pendiente "+regression.getSlope());

    JFrame ventana = new JFrame ("Regression Lineal");

    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(400,400);
    ventana.add(resultado);
    ventana.setVisible(true);

  }

}

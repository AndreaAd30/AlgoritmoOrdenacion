package Programas;
import Clases.DatosDesordenados;
import Clases.DatosOrdenados;
import javax.swing.JOptionPane;

public class TestOrdenamiento {

    public static void main(String[] args) {
        DatosDesordenados m;
        int n, s;
        long t, t1, t2;
        n=Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos datos son?"));
        s=Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es el valor maximo?"));
        m=new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println(""+m);
        t1=System.nanoTime();
        DatosOrdenados mob=m.bubbleSort();
        t2=System.nanoTime();
        t=t2-t1;
        System.out.println("n="+n+"t="+t+"ns.Burbuja="+mob);
    }
    
}

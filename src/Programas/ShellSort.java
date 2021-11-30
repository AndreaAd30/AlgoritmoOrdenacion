package Programas;
import java.util.Scanner;
public class ShellSort {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int Arreglo[]=new int [20];
        int numero,i,j,k,incremento,aux;
        System.out.print("Ingrese dimension del arreglo: ");
        numero=teclado.nextInt();
        for(i=1;i<=numero;i++){
            System.out.print("A["+i+"]= ");
            Arreglo[i]=teclado.nextInt();
        }
     
     
        incremento=numero/2;
        while(incremento>0){
            for(i=incremento+1;i<=numero;i++){
                j=i-incremento;
                while(j>0){
                    if(Arreglo[j]>=Arreglo[j+incremento]){
                        aux = Arreglo[j];
                        Arreglo[j] = Arreglo[j+incremento];
                        Arreglo[j+incremento] = aux;
                    }
                    else{
                        j=0;
                    }
                    j=j-incremento;
                }
            }
            incremento=incremento/2;
        }
        System.out.println("EL ARREGLO ORDENADO");
        for(i=1;i<=numero;i++){
            System.out.print(" "+Arreglo[i]);
         }
    }
}

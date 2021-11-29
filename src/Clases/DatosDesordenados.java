package Clases;

public class DatosDesordenados {
    private int[] valores;
    private int limiteSuperior;
    private int size;
    
    public DatosDesordenados(int limite, int size){
        this.valores=new int[size];
        this.limiteSuperior=limite;
        this.size=size;
    }
    public void agregarDato(int valor){
        valores[size]=valor;
        size++;
    }
    public int getDato(int posicion){
        return valores[posicion];
    }
    public void generarValores(){
        for(int i=0; i<valores.length; i++){
            double aleatorio=Math.random()*limiteSuperior;
            valores[i]=(int)aleatorio+1;
        }
    }
    public int getSize(){
        return size;
    }
    public int getCapacidad(){
        return valores.length;
    }
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    public int[] getValores(){
        return valores;
    }
    public int[] getCopiaValores(){
        int[] copia=new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }
    public DatosOrdenados bubbleSort(){
        int[] arreglo=this.getCopiaValores();
        int n=arreglo.length;
        int cont=0;
        int ci=0;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                cont++;
                if(arreglo[j]>arreglo[j+1]){
                    ci++;
                    int temporal=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temporal;
                }
            }
        }
        System.out.println("BS-comparaciones="+cont);
        System.out.println("BS-intercambios="+ci);
        return new DatosOrdenados(arreglo);
    }
    
    static int mo=0;
    public static void quicksort(int arreglo[], int izq, int der) {
        int pivote=arreglo[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;
 
        while(i < j){                          // mientras no se crucen las búsquedas                                   
            while(arreglo[i] <= pivote && i < j) 
                i++; // busca elemento mayor que pivote
            while(arreglo[j] > pivote) 
                j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado                      
                aux= arreglo[i];                      // los intercambia
                arreglo[i]=arreglo[j];
                arreglo[j]=aux;
            }
            mo++;
        }
   
        arreglo[izq]=arreglo[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
        arreglo[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
   
        if(izq < j-1) {
            quicksort(arreglo,izq,j-1);          // ordenamos subarray izquierdo
            mo++;
        }
        if(j+1 < der){
            quicksort(arreglo,j+1,der);          // ordenamos subarray derecho
            mo++;
        }
    }
    
    public DatosOrdenados QuickSort(){
        int [] q = this.getCopiaValores();
	    this.quicksort(q, 0, q.length-1);
        System.out.println("QS-comparaciones = " + mo);
	    return new DatosOrdenados(q);
    }
    
    @Override
    public String toString(){
        String cad="Datos desordenados";
        for(int x:valores){
            cad+=x+", ";
        }
        return cad;
    }
}

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
    
}

package Programas;

public class Radix {

    public static void main(String[] args) {
        long t, t1, t2;
        int n=1000;
        int cont=0;
        int ci=0;
         int[] arr = new int[n] ;
         
         for (int i=0; i<n; i++){
            arr [i]= (int)(Math.random() *2000)+1; 
        }
         t1=System.nanoTime();
        System.out.println("Datos Desordenados");
        Desordenados(arr);
        radixSort(arr);
        System.out.println("\nDatos Ordenados");
        printArray(arr);
        
        t2=System.nanoTime();
        t=t2-t1;
        System.out.println("\n"+t+"ns");
    }
    
    public static void Desordenados(int[] arr) {
         for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");  
         }
      return;   
         
    }
 
    public static void radixSort(int[] arr) {
        
        int digit = getMaxDigit (arr);
        for (int i = 0; i < digit; i++) {
                        
                         bucketSort (arr, i); 
                         
        }
    }
 
    public static int getMaxDigit(int[] arr) {
                 int digit = 1; 
                 int base = 10; 
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }
 
    public static void bucketSort(int[] arr, int digit) {
        int base = (int) Math.pow(10, digit);
        // init buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
                 for (int i = 0; i <10; i ++) {
            buckets.add(new ArrayList<Integer>());
        }
        
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }
 
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        
    
    }
    }
    
}

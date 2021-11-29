package Programas;

public class Radix {

    public static void main(String[] args) {
        int n=1000;
        
        
         int[] arr = new int[n] ;
         for (int i=0; i<n; i++){
            arr [i]= (int)(Math.random() *2000)+1; 
        }
        radixSort(arr);
        printArray(arr);
    }
    public static void radixSort(int[] arr) {
        int digit = getMaxDigit (arr); // obtiene el número máximo de dígitos
        for (int i = 0; i < digit; i++) {
             
                         bucketSort (arr, i); // ordena bucketSort por dígitos veces
                         
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
        // sort
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output: copy back to arr
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }
 
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

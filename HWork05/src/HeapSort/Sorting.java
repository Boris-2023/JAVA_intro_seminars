package HeapSort;

import java.util.Random;

public class Sorting {

    public static void heapSort(int[] arr){
                      
        int length = arr.length;
        if (length == 0) return;
        
        for (int i = length / 2 - 1; i >= 0; i--) {// Moving from the first element that isn't a leaf towards the root
            heapify(arr, length, i);
        }
        
        for (int i = length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
       
    }
    
    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }

    public static int[] randomIntArr(int sz, int min, int max) {
        Random rand = new Random();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = (int) (rand.nextInt((max - min) + 1) + min);
        }
        return res;
    }

    public static String arrayIntToString(int[] arr) {
        StringBuilder res = new StringBuilder("");
        res.append("[");
        for (int i : arr)
            res.append(i + "," + " ");

        return res.toString().substring(0, res.length() - 2) + "]";
    }
}

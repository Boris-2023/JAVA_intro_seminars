//Task #1
// Реализовать алгоритм сортировки слиянием(метод взять из Интернета)
package Solution;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task01 {

    public static void sortArray() {

        int size = readInt("Enter a size of array to sort: ");

        ArrayList<Integer> array = randomArrayList(size, 1, 100, true);
        mergeSort(array, 0, array.size());

        System.out.println(array);
    }

    public static void mergeSort(ArrayList<Integer> list, int beg, int fin) {
        if (fin - beg >= 2) {
            int mid = beg + (fin - beg) / 2;
            mergeSort(list, beg, mid);
            mergeSort(list, mid, fin);
            merge(list, beg, mid, fin);
        }
    }

    public static void merge(ArrayList<Integer> list, int beg, int mid, int fin) {
        ArrayList<Integer> left = new ArrayList<Integer>(list.subList(beg, mid));

        for (int i = 0, j = mid, k = beg; i < left.size(); k++) {
            if (j >= fin || left.get(i) <= list.get(j)) {
                list.set(k, left.get(i++));
            } else {
                list.set(k, list.get(j++));
            }
        }
    }

    public static ArrayList<Integer> randomArrayList(int size, int min, int max, boolean ifPrint) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size; ++i) {
            arr.add((int) (rand.nextInt((max - min) + 1) + min));
        }

        if (ifPrint)
            System.out.println(arr);

        return arr;
    }

    private static int readInt(String string) {

        int res = 0;
        Scanner iScanner = new Scanner(System.in);

        System.out.printf(string);
        boolean flag = iScanner.hasNextInt();// if input value is int

        if (flag)
            res = iScanner.nextInt();

        return res;
    }

}

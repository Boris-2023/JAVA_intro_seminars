// Task #2
// Пусть дан произвольный список целых чисел, удалить из него четные числа
package Solution;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task02 {
    public static void deleteEvenValues() {

        int size = readInt("Enter a size of array to eliminate even values: ");

        ArrayList<Integer> array = randomArrayList(size, 1, 100, true);

        elimEnenValues(array);
        
        System.out.println(array);
    }

    public static void elimEnenValues(ArrayList<Integer> myList) {
        ArrayList<Integer> delList = new ArrayList<Integer>();
        for (int item : myList) {
            if (item % 2 == 0)
                delList.add(item);
        }
        myList.removeAll(delList);
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

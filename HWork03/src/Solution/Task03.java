// Task #3
// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Task03 {
    public static void findStats() {

        int size = readInt("Enter a size of array to find min, max & mean values: ");

        ArrayList<Integer> array = randomArrayList(size, 1, 100, true);

        printMap(findMinMaxMean(array));
    }

    public static LinkedHashMap<Object, Object> findMinMaxMean(ArrayList<Integer> myList) {

        LinkedHashMap<Object, Object> res = new LinkedHashMap<Object, Object>();

        res.put("min value:", Collections.min(myList));
        res.put("max value:", Collections.max(myList));
        res.put("mean value:", sumArrayList(myList) / myList.size());
        return res;
    }

    public static double sumArrayList(ArrayList<Integer> myList) {
        double res = 0;
        for (int i = 0; i < myList.size(); i++) {
            res += myList.get(i);
        }
        return res;
    }

    public static void printMap(HashMap<Object, Object> input) {
        for (Object objectName : input.keySet())
            System.out.println(objectName + " " + input.get(objectName));
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

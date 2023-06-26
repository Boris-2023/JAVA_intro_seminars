package UniqueNumFinder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Finder {

    public static int[] GetRandomArray(int size, int maxValue) {
        int[] myArr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            myArr[i] = r.nextInt(maxValue);
        }
        return myArr;
    }
    
    public static Set<Integer> arrayToSet(int[] array) {
        Set<Integer> uniques = new HashSet<>();
        for (Integer integer : array) {
            uniques.add(integer);
        }
        return uniques;
    }

    public static double percenter(int[] array, Set<Integer> uniques) {
        double percent = (double)uniques.size() * 100 / (double)array.length;
        return percent;
    }

    
}

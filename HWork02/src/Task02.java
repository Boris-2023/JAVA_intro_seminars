import java.io.IOException;
import java.util.logging.*;
import java.util.Random;

public class Task02 {
    // Task #2:
    // Реализуйте алгоритм сортировки пузырьком числового массива, результат после
    // каждой итерации запишите в лог-файл.

    public static void logBubbleSort(int size, String fName) throws IOException{

        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fh = new FileHandler(fName);
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        int[] arr = randomIntArr(size, 1, 100);// forms a random array
        logger.log(Level.INFO, "Array to sort:" + arrayIntToString(arr));
            
        System.out.println(arrayIntToString(arr));

        //bubble sorting
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;

                    //String logStr = arr[j] + " exchanges with " + arr[j+1];
                    logger.log(Level.INFO, arr[j] + " exchanges with " + arr[j+1]);
                }
            }
        }

        logger.log(Level.INFO, "Array sorted:" + arrayIntToString(arr));
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

package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 📌 Заполнить список десятью случайными числами.
// 📌 Отсортировать список методом sort() и вывести его на
// экран.
public class Task01 {

    public static List<Integer> filler() {
        ArrayList<Integer> array = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; ++i) {
            array.add(rnd.nextInt(100));
        }
        
        System.out.println(array);

        array.sort(Integer::compareTo);

        System.out.println(array);

        return array;
    }
}

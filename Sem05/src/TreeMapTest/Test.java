// Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.
// Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.

package TreeMapTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Test {

    public static TreeMap<String, Integer> sortHashMap(HashMap<String, Integer> notSortMap) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(notSortMap);
        new Comparator<String>(){
            @Override
            public int compare(String s1, String s2)
            {
                return Integer.compare(s1.length(), s2.length());
            };
        };
        return sortedMap;
    }
}

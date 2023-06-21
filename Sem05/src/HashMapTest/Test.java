// Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
// 123456 Иванов
// 321456 Васильев
// 234561 Петрова
// 234432 Иванов
// 654321 Петрова
// 345678 Иванов
// Вывести данные по сотрудникам с фамилией Иванов.

package HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static HashMap<Integer, String> fill() {
        HashMap<Integer, String> outMap = new HashMap<>();

        outMap.put(123456, "Иванов");
        outMap.put(321456, "Васильев");
        outMap.put(234561, "Петрова");
        outMap.put(234432, "Иванов");
        outMap.put(654321, "Петрова");
        outMap.put(345678, "Иванов");

        return outMap;
    }

    public static void printHM(HashMap<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            if (item.getValue() == value) {
                System.out.println(item.getValue() + " -> " + item.getKey());
            }
        }

    }

}

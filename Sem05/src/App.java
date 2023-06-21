import java.util.HashMap;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {

        // Task #1
        // Создать структуру для хранения Номеров паспортов и Фамилий сотрудников
        // организации.
        // 123456 Иванов
        // 321456 Васильев
        // 234561 Петрова
        // 234432 Иванов
        // 654321 Петрова
        // 345678 Иванов
        // Вывести данные по сотрудникам с фамилией Иванов.
     //   HashMap<Integer, String> map = HashMapTest.Test.fill();
     //   HashMapTest.Test.printHM(map, "Иванов");


        // Task #3
        // Написать программу, определяющую правильность расстановки скобок в выражении.
        // Пример 1: a+(d*3) - истина
        // Пример 2: [a+(1*3) - ложь
        // Пример 3: [6+(3*3)] - истина
        // Пример 4: {a}[+]{(d*3)} - истина
        // Пример 5: <{a}+{(d*3)}> - истина
        // Пример 6: {a+]}{(d*3)} - ложь

        // HashMap<String, Integer> open = new HashMap<>();
        // open.put("(", 0);
        // open.put("[", 1);
        // open.put("{", 2);
        // open.put("<", 3);

        // HashMap<String, Integer> close = new HashMap<>();
        // open.put(")", 0);
        // open.put("]", 1);
        // open.put("}", 2);
        // open.put(">", 3);

        // System.out.println(CheckBrackets.Test.validation(open, close, "a+(d*3)"));
        // System.out.println(CheckBrackets.Test.validation(open, close, "[a+(1*3)"));
        // System.out.println(CheckBrackets.Test.validation(open, close, "[6+(3*3)]"));
        // System.out.println(CheckBrackets.Test.validation(open, close, "{a}[+]{(d*3)}"));

        //Task #5
        String line = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        String[] sLine = line.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : sLine){
            map.put(s, s.length());
        }

        TreeMap<String, Integer> sortMap = TreeMapTest.Test.sortHashMap(map);
        sortMap.entrySet().forEach(System.out::println);


    }
}

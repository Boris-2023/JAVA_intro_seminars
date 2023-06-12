public class App {
    public static void main(String[] args) throws Exception {

        // Task #1:
        // Дана строка sql-запроса "select * from students where ". Сформируйте часть
        // WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
        // ниже в виде json-строки.
        // Если значение null, то параметр не должен попадать в запрос.
        // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
        // "city":"Moscow", "age":"null"}

        System.out.println("\nTask #1:\n");
        String beginStr = "use dbMain select * from students where";
        String fname1 = "Task01.json";

        System.out.println(Task01.completeDBRequest(beginStr, fname1));

        // Task #2:
        // Реализуйте алгоритм сортировки пузырьком числового массива, результат после
        // каждой итерации запишите в лог-файл.

        System.out.println("\nTask #2:\n");

        String fname2 = "sortLog.txt";
        int arrSize = 10;

        Task02.logBubbleSort(arrSize, fname2);

        // Task #3:
        // 3) Дана json-строка (можно сохранить в файл и читать из файла)
        // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
        // строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        // Пример вывода:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.
        System.out.println("\nTask #3:\n");
        String fname3 = "Task03.json";

        Task03.printJsonMarks(fname3, true); // returns requested String[] & prints out if selected 'true'

        // Task #4:
        // К калькулятору из предыдущего ДЗ добавить логирование.
        System.out.println("\nTask #4:\n");
        
        String fname4 = "calc.txt";
        Task04.logSimpleCalc(fname4);

    }
}

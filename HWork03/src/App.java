import Solution.Task01;
import Solution.Task02;
import Solution.Task03;

public class App {
    public static void main(String[] args) throws Exception {

        // Task #1
        System.out.println("\n1) Реализовать алгоритм сортировки слиянием (метод взять из Интернета)\n");
        Task01.sortArray();

        // Task #2
        System.out.println("\n2) Дан произвольный список целых чисел, удалить из него четные числа\n");
        Task02.deleteEvenValues();

        // Task #3
        System.out.println("\n3) Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.\n");
        Task03.findStats();
    }
}

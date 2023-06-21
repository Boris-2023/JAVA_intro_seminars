import PhoneBook.PhoneBook;
import HeapSort.Sorting;
import Chess.Set8Queens;

public class App {
    public static void main(String[] args) throws Exception {

        // Task #1
        
        // Реализуйте структуру телефонной книги с помощью HashMap. Программа также
        // должна учитывать, что во входной структуре будут повторяющиеся имена с
        // разными телефонами, их необходимо считать, как одного человека с разными
        // телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.(можно
        // выводить без сортировки, но обязательно в отдельном методе)
        System.out.println("\nЗадание №1. Структура телефонной книги. Данные в файле PhoneBook.txt.\n");
        
        String fileName = "src/PhoneBook/PhoneBook.txt";//source file with name:phone
        
        PhoneBook.printSortedPB(PhoneBook.fillPB(fileName));

        //Task #2
        //Реализовать алгоритм пирамидальной сортировки (HeapSort)(найти метод в Интернете и включить в проект)
        System.out.println("\nЗадание №2. Алгоритм пирамидальной сортировки (HeapSort).\n");
                
        int[] arr = Sorting.randomIntArr(30, 1, 100);// forms a random array
        
        System.out.println(Sorting.arrayIntToString(arr));
        Sorting.heapSort(arr);
        System.out.println(Sorting.arrayIntToString(arr));

        //Task #3
        //На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
        System.out.println("\nЗадание №3. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.\n");
        
        Set8Queens.setQueens();
    }
}

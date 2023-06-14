package Solution;

import java.util.ArrayList;
import java.util.List;

public class Task04 {
    // 📌 Каталог товаров книжного магазина сохранен в виде двумерного
    // списка List<ArrayList<String>> так, что на 0й позиции каждого
    // внутреннего списка содержится название жанра, а на остальных
    // позициях - названия книг. Напишите метод для заполнения данной
    // структуры.

    public static void catalog() {
        List<List<String>> library = new ArrayList<>();

        List<String> gList = new ArrayList<>();
        gList.add("proza");
        gList.add("Tolstoy");
        gList.add("Gogol");
        library.add(gList);// initialization of interior objects

        List<String> gList2 = new ArrayList<>();
        gList2.add("poet");
        gList2.add("Pushkin");
        gList2.add("Lermontov");
        library.add(gList2);// initialization of interior objects

        System.out.println(library);

        // library.get().get()...
        // library.get(0) - initial null in all cells

    }

}

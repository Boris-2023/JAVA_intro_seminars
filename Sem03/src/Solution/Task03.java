package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Task03 {
    // 📌 Создать список типа ArrayList<String>.
    // 📌 Поместить в него как строки, так и целые числа.
    // 📌 Пройти по списку, найти и удалить целые числа.

    public static void MakeString() {
        List<Object> oList = new ArrayList<>();
        oList.add("a");
        oList.add(1);
        oList.add(2);
        oList.add("b");
        System.out.println(oList);

        for (int i = 0; i < oList.size(); i++) {
            System.out.println(oList.get(i).getClass());
        }
        oList.removeAll(Arrays.asList(new Integer[]{1, 2}));
        System.out.println(oList);



        
    }
}

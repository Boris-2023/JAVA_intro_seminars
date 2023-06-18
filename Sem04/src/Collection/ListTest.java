// 📔 **Текст задачи:**
// 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
// 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.

package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListTest {
    public static void TimeTest(int size){
        List<Integer> simpleList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        long curTime = System.currentTimeMillis();
        System.out.println(curTime);

                for (int i = 0; i < size; i++) {
            simpleList.add(0,1);//1 to index 0
        }

        System.out.println("Простой: " + (System.currentTimeMillis()-curTime));
        curTime = System.currentTimeMillis();
        System.out.println(curTime);

        for (int i = 0; i < size; i++) {
            linkedList.add(0,1);//1 to index 0
        }

        System.out.println("Связный: " + (System.currentTimeMillis()-curTime));
        curTime = System.currentTimeMillis();
        System.out.println(curTime);

    }
}

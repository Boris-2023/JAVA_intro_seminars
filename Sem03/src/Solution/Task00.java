package Solution;

import java.util.ArrayList;
import java.util.List;

public class Task00 {

    public static void StringTest() {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;// both now refers to the same
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[] { 'h', 'e', 'l', 'l', 'o' });

        List<String> stringList1 = new ArrayList<>();
        stringList1.add(s1);
        stringList1.add("new value");
        List<String> stringList2 = stringList1;

        System.out.println((stringList1));
        System.out.println((stringList2));

        stringList1 = new ArrayList<>();//now - it has a new cell in memory, List1 & List2 now divided!
        stringList1.add("new value 2");

        System.out.println((stringList1));
        System.out.println((stringList2));

        if (s1 == s2)
            System.out.println("Test 1 ok!");// ok
        if (s3 == s4)
            System.out.println("Test 2 ok!");// ok, as the same reference for optimization

        if (s5 == s6)
            System.out.println("Test 3 ok!");// used new => new memory was allocated (even if the same value)
        if (s5.equals(s6))
            System.out.println("Test 4 ok!");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        s2 = "new value";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}

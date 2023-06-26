import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import CatLibrary.Cat;

public class App {
    public static void main(String[] args) throws Exception {

        // Task #1
        // 1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5,6,
        // 3}. Распечатайте содержимое данного множества.
        // 2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2,4,
        // 5, 6, 3}. Распечатайте содержимое данного множества.
        // 3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5,6,
        // 3}. Распечатайте содержимое данного множества.

        HashSet<Integer> numsSet = new HashSet<>();
        numsSet.add(1);
        numsSet.add(6);
        numsSet.add(4);
        numsSet.add(2);
        numsSet.add(3);
        numsSet.add(5);
        numsSet.add(2);
        numsSet.add(3);
        numsSet.add(6);
        System.out.println(numsSet);

        LinkedHashSet<Integer> numsSet1 = new LinkedHashSet<>();
        numsSet1.add(1);
        numsSet1.add(6);
        numsSet1.add(4);
        numsSet1.add(2);
        numsSet1.add(3);
        numsSet1.add(5);
        numsSet1.add(2);
        numsSet1.add(3);
        numsSet1.add(6);
        System.out.println(numsSet1);

        TreeSet<Integer> numsSet2 = new TreeSet<>();
        numsSet2.add(1);
        numsSet2.add(6);
        numsSet2.add(4);
        numsSet2.add(2);
        numsSet2.add(3);
        numsSet2.add(5);
        numsSet2.add(2);
        numsSet2.add(3);
        numsSet2.add(6);
        System.out.println(numsSet1);


        // Task #2
        // 1. Напишите метод, который заполнит массив из 1000 элементов случайными
        // цифрами от 0 до 24.
        // 2. Создайте метод, в который передайте заполненный выше массив и с помощью
        // Set вычислите процент уникальных значений в данном массиве и верните его в
        // виде числа с плавающей запятой.
        // Для вычисления процента используйте формулу:
        // процент уникальных чисел = количество уникальных чисел * 100 / общее
        // количество чисел в массиве.

        // int[] arr = UniqueNumFinder.Finder.GetRandomArray(300, 25);
        // Set<Integer> randSet = UniqueNumFinder.Finder.arrayToSet(arr);
        // System.out.println(UniqueNumFinder.Finder.percenter(arr, randSet));

        // Task #3
        // 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
        // приложения, которое является
        // а) информационной системой ветеринарной клиники
        // б) архивом выставки котов
        // в) информационной системой Театра кошек Ю. Д. Куклачёва
        // Можно записать в текстовом виде, не обязательно реализовывать в java.

        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
        
        Cat myCat = new Cat(2000, "Барсик", 245, formatter.parse("Sat, Apr 4, 2019"), true, 1);
        Cat motherCat = new Cat(10000, "Кеша", 245, formatter.parse("Mon, May 25, 2010"), true, 2);

        HashSet<Cat> catSet = new HashSet<>();
        catSet.add(myCat);
        catSet.add(motherCat);

        System.out.println(myCat);
        System.out.println(motherCat);

        System.out.println(myCat.equals(motherCat));
        System.out.println(catSet.contains(motherCat));

     
    }
}

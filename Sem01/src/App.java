import java.time.LocalTime;
import java.util.Scanner;
import java.io.*;

//https://github.com/Golikov-Andrey/JavaUnit1Gr4580

public class App {
    public static void main(String[] args) throws Exception {
        // task1(); //приветствие пользователя в зависимости от времени суток
        // task2(); //вывести макс. кол-во идущих подряд 1
        // task3(); //перенести элем-ты, равные заданному, в конец массива
        // task4(); //общий префикс
        task5(); // переставить слова в обратном порядке
        // task6(); //возведение числа в степень
        // task7(); //алгоритм получения числа b из а (рекурсия)
        task8(); // найти индекс в массиве, что сумма эл-тов до и после него равны
        task9();
    }

    private static void task9() {
        // Записать в файл следующие данные:
        // Name Surname Age
        // Kate Smith 20
        // Paul Green 25
        // Mike Black 23

        String[] ages = {"Name Surname Age", "Kate Smith 20", "Paul Green 25", "Mike Black 23"};
        char sepLines = '\n';
        String fileName = "ages.txt";
        
        writeFile(fileName, ages, sepLines);
   
    }

    private static void writeFile(String fileName, String[] ages, char sepLines) {
        try (FileWriter fw = new FileWriter(fileName, false)){
            for (int i = 0; i < ages.length; i++) {
                fw.write(ages[i]);
                fw.append(sepLines);
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void task8() {
        // Задан массив, например, nums = [1,7,3,6,5,6].
        // Написать программу, которая найдет индекс i для этого массива
        // такой, что сумма элементов с индексами < i равна сумме
        // элементов с индексами > i.

        int[] arr = { 1, 7, 3, 6, 5, 6 };

        boolean ifFound = false;
        int[] cumSum = new int[arr.length];// array for cumulative sum

        cumSum[0] = arr[0];// init of 1st element
        for (int i = 1; i < arr.length; i++)// fill in cumsum
            cumSum[i] = cumSum[i - 1] + arr[i];

        for (int i = 1; i < arr.length - 1; i++) {
            if ((cumSum[arr.length - 1] - arr[i]) % 2 == 0 && // if sum of all other elems can be divided in 2 parts
                    cumSum[i - 1] == (cumSum[arr.length - 1] - arr[i]) / 2) { // if left part equals to half of sum
                System.out.printf("\nMedian index is %d !\n", i);
                ifFound = true;
                break;
            }
        }

        if (!ifFound)
            System.out.printf("\nThere is NO median index in the array!\n");
    }

    private static void task7() {
        // На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть
        // две команды
        // - команда 1 (к1): увеличить на с, к а прибавляется c
        // - команда 2 (к2): увеличить в d раза, a умножаетется на d
        // Написать программу, которая выдаёт набор команд, позволяющий число a
        // превратить в число b или сообщить, что это невозможно
        // Пример 1: а = 1, b = 7, c = 1, d = 3
        // ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
        // Пример 2: а = 11, b = 7, c = 2, d = 1
        // ответ: “”.

        int valSource = 11;
        int valTarget = 77;
        int add = 2;
        int mult = 3;
        String algo = "";

        findAlgo(valSource, valTarget, add, mult, algo);

    }

    private static void findAlgo(int base, int target, int c, int d, String algo) {
        if (base > target)
            return;
        if (base == target) {
            System.out.println(algo);
            return;
        }

        findAlgo(base + c, target, c, d, algo + " K1");
        findAlgo(base * d, target, c, d, algo + " K2");
    }

    private static void task6() {
        // Реализовать функцию возведения числа а в степень b. a, b из Z.
        // Сводя количество выполняемых действий к минимуму.
        // Пример 1: а = 3, b = 2, ответ: 9
        // Пример 2: а = 2, b = -2, ответ: 0.25
        // Пример 3: а = 3, b = 0, ответ: 1
        int a = 2;
        int b = -2;

        System.out.printf("\n%d pw %d = %.3f\n", a, b, pow(a, b));
    }

    private static double pow(double a, int b) {
        double res = 1;

        if (b == 1)
            return 1;
        if (a == 0 || a == 1)
            return 1;

        if (b < 0) {
            b = -b;
            a = 1 / a;
        }

        while (b > 0) {
            if (b % 2 == 1)
                res *= a;
            a *= a;
            b /= 2;
        }

        return res;
    }

    private static void task5() {
        // Во фразе "Добро пожаловать на курс по Java" переставить слова
        // в обратном порядке.
        String str = "Welcome to the course on Java";
        System.out.println(wordsReverse(str));
    }

    private static String wordsReverse(String str) {
        String[] strArr = str.split(" ");
        String res = "";

        for (int i = strArr.length - 1; i >= 0; i--)
            res = res.concat(strArr[i] + " ");

        return res;
    }

    private static void task4() {
        // Напишите метод, который находит самую длинную строку общего префикса среди
        // массива строк.
        // Если общего префикса нет, вернуть пустую строку "".
        String[] lines = { "dom", "domovoy", "domashniy" };
        System.out.println(findPfx(lines));
        System.out.println(lines[0].substring(0, findPfx(lines)));

    }

    private static int findPfx(String[] lines) {
        int res = 0;
        boolean pfxExist = true;
        while (pfxExist) {
            res++;
            for (int i = 0; i < (lines.length - 1); i++) {
                if (res < lines[i].length() && res < lines[i + 1].length()) {
                    if (lines[i].substring(0, res).compareTo(lines[i + 1].substring(0, res)) != 0) {
                        res--;
                        pfxExist = false;
                        break;
                    }
                } else {
                    pfxExist = false;
                    break;
                }
            }
        }
        return res;
    }

    private static void task3() {
        // Дан массив nums = [3,2,2,3] и число val = 3.
        // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в
        // конец массива.
        // Таким образом, первые несколько (или все) элементов массива должны быть
        // отличны от заданного, а остальные - равны ему.

        int[] arr = new int[] { 1, 1, 0, 3, 1, 1, 3, 0, 1 };
        int val = 3;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                for (int j = i; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];
                arr[arr.length - 1] = val;
            }
        }

        for (int item : arr)
            System.out.printf("%d\t", item);

    }

    private static void task2() {
        // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
        // максимальное количество подряд идущих 1.

        int[] arr = { 1, 1, 0, 1, 1, 1 };
        int cnt = 0;
        int max_cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                cnt++;
            else
                cnt = 0;
            if (cnt > max_cnt)
                max_cnt = cnt;
        }
        System.out.println(max_cnt);
    }

    private static void task1() {
        // Написать программу, которая запросит пользователя ввести <Имя> в консоли.
        // Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
        Scanner iScanner = new Scanner(System.in);

        System.out.printf("Enter your name: ");
        String name = iScanner.nextLine();
        System.out.println("Hello " + name + "!\n");

        // В консоли запросить имя пользователя. В зависимости от текущего времени,
        // вывести приветствие вида
        // "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        // "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        // "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        // "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

        LocalTime timeOfDay = LocalTime.now();
        System.out.println(timeOfDay);
        if (timeOfDay.getHour() >= 18 && timeOfDay.getHour() < 23) {
            System.out.println("Good evening, " + name + "!\n");
        } else if (timeOfDay.getHour() >= 5 && timeOfDay.getHour() < 12) {
            System.out.println("Good morning, " + name + "!\n");
        } else if (timeOfDay.getHour() >= 12 && timeOfDay.getHour() < 18) {
            System.out.println("Good afternoon, " + name + "!\n");
        } else if (timeOfDay.getHour() >= 23 || timeOfDay.getHour() < 5) {
            System.out.println("Good night, " + name + "!\n");
        }

        iScanner.close();

    }

}
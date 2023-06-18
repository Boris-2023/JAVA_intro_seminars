// 📔 **Текст задачи:**
// Реализовать консольное приложение, которое:

// 1. Принимает от пользователя строку вида text~num

// 1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
// 2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

// 📔 **Текст задачи:**
// Реализовать консольное приложение, которое:

// 1. Принимает от пользователя и “запоминает” строки.
// 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// 3. Если введено reverse, вывести список в обратном порядке.

package Solution;

import java.util.LinkedList;
import java.util.Scanner;

public class Task01 {

    private static LinkedList<String> list = new LinkedList<>();

    public static void runList() {
        boolean getIteration = true;
        while (getIteration) {
            String cmd = inputUser("Enter the command ('exit' - to exit)");
            String[] cLine = cmd.split("~");
            switch (cLine[0].toUpperCase()) {
                case "EXIT":
                    getIteration = false;
                    break;
                case "PRINT":
                    System.out.println(list.get(Integer.parseInt(cLine[1])));
                    break;
                case "LIST":
                    while (list.size() > 0) {
                        System.out.println(list.pollFirst());
                    }
                    break;
                case "REVERSE":
                    while (list.size() > 0) {
                        System.out.println(list.pollLast());
                    }
                    break;
                default:
                    list.add(cLine[0]);
                    break;
            }
        }
    }

    private static String inputUser(String message) {
        System.out.print(message + " -> ");
        Scanner scannerNumber = new Scanner(System.in);
        return scannerNumber.nextLine();
    }

}


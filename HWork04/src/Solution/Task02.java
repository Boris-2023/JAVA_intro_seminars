// Task # 2
// Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, dequeue() - 
// возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.

package Solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task02 {
    public static void processQueue() {
        
        // form initial queue
        System.out.println("FORM initial QUEUE (empty string to finish):");
        Queue<String> que = formLinkedList();// forms initial list of any strings
        printQueue(que);

        // add item to the end
        System.out.println();
        enqueue(que);
        printQueue(que);

        // print & delete the 1st element of the queue
        System.out.println();
        dequeue(que);
        printQueue(que);

        // print the 1st element of the queue
        System.out.println();
        first(que);
        printQueue(que);

    }

    private static void enqueue(Queue<String> list) {
        list.add(inputUser("Enter a string to put at the end of the queue - enqueue(): "));
    }

    private static void dequeue(Queue<String> list) {
        System.out.println("The 1st item in the queue (with deletion): " + list.remove());
    }

    private static void first(Queue<String> list) {
        System.out.println("The 1st item in the queue (w/o deletion): " + list.peek());
    }

    private static void printQueue(Queue<String> que) {
        System.out.println("\nthe QUEUE:\n");
        for (String item : que)
            System.out.println(item);
    }

    private static LinkedList<String> formLinkedList() {

        LinkedList<String> list = new LinkedList<>();

        String str = "-1";
        while (!str.isEmpty()) {
            str = inputUser("Enter new string for the list: ");
            if (!str.isEmpty())
                list.add(str);

        }
        return list;
    }

    private static String inputUser(String message) {
        System.out.print(message);
        Scanner iScanner = new Scanner(System.in);
        return iScanner.nextLine();
    }
}

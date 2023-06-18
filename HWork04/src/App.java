import Solution.Task01;
import Solution.Task02;
import Solution.Task03;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("\nTASK #1\n");
        Task01.runList();// REVERSE option added to Task 02-03 of Seminar #4

        System.out.println("\nTASK #2\n");
        Task02.processQueue();// forms new queue and makes enqueue(), dequeue() & first() as required

        System.out.println("\nTASK #3\n");
        Task03.calculator();// function cancel last operation added; performed with a Stack (combines Tasks
                            // ## 3, 4 of homework)

    }
}

// Task #3
// В калькулятор добавьте возможность отменить последнюю операцию. Калькулятор сделать на основе программы разработанной на семинаре.

package Solution;

import java.util.Scanner;
import java.util.Stack;

public class Task03 {
    
    public static void calculator() {

        boolean getIteration = true;
        double val1 = 0;// to save
        Stack<Double> values = new Stack<>();

        while (getIteration) {

            takeValues(values, "c");// fills the stack until cantains 2 double values, if c/C pressed - goes to
                                    // cancel operation

            String cmd;
            if (!values.empty()) {// command can be taken only if the values are in place (to allow 'cancel' in
                                  // takeValues())
                cmd = inputUser("Enter the operation ( '+', '-', '*', '/'; C - to cancel last operation, E - exit): ");
            } else {
                cmd = "C";// cancel last operation: signal by takeValues() - empty stack returned
            }

            switch (cmd.toUpperCase()) {
                case "E":
                    getIteration = false;
                    break;
                case "C":
                    values.removeAllElements();// reinit, remove All
                    values.push(val1);
                    System.out.println("Last operation cancelled!\nValue #1 = " + values.peek());
                    takeValues(values, "kdsgjfghkjdfgkfdjglk;qw;s;,s,'d;ld;lsd;ls");// fills the stack until cantains 2
                                                                                    // values; stopString unrepeatable)
                    break;
                case "+":
                    val1 = values.get(0); // if needs to cancel
                    System.out.println("Result: " + (values.pop() + values.pop()));
                    break;
                case "-":
                    val1 = values.get(0); // if needs to cancel
                    System.out.println("Result: " + (-values.pop() + values.pop()));
                    break;
                case "*":
                    val1 = values.get(0); // if needs to cancel
                    System.out.println("Result: " + (values.pop() * values.pop()));
                    break;
                case "/":
                    val1 = values.get(0); // if needs to cancel
                    System.out.println("Result: " + 1 / (values.pop() / values.pop()));
                    break;
                default:
                    System.out.println("Choose an operation from the list!");
                    break;
            }
        }

    }

    private static void takeValues(Stack<Double> values, String stopString) {
        for (int i = values.size(); i < 2; i++) {// if stack has one value already => only one more needed (cancelled
                                                 // operation)
            String str;
            while (true) {
                str = inputUser("Enter a value #" + (i + 1) + ": ");
                if (isNumeric(str)) {
                    values.push(Double.parseDouble(str));
                    break;
                } else {
                    if (str.toUpperCase().replaceAll(stopString.toUpperCase(), "").isEmpty()) {// if stop string is
                                                                                               // input (e.g. "e" - to
                                                                                               // exit, as
                        values.removeAllElements();
                        return;
                    }
                }
            }
        }
    }

    private static boolean isNumeric(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String inputUser(String message) {
        System.out.printf(message);
        Scanner iScanner = new Scanner(System.in);
        return iScanner.nextLine();
    }

}

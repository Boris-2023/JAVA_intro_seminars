import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("task #1 (sum of values 1 -> n):");
        task01(); // вычислить сумму чисел от 1 до n
        System.out.println("\ntask #2 (print prime numbers up to 1000):");
        task02(); // Вывести все простые числа от 1 до 1000
        System.out.println("\ntask #3 (simple calculator):");
        task03(); // Реализовать простой калькулятор
        System.out.println("\ntask #4 (find digits to replace '?'):");
        task04(); // для уравнения вида 2? + ?5 = 69, найти ? цифры или сообщить, что их нет

    }

    private static void task04() {
        // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
        // заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить
        // выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
        // что его нет.
        String val1 = readStr("Enter value #1, may contain '?':\t");
        String val2 = readStr("Enter value #2, may contain '?':\t");
        String result = readStr("Enter result value, may contain '?':\t");

        System.out.println(findMissedFigs(val1, val2, result));
    }

    private static String findMissedFigs(String val1, String val2, String result) {
        String[] string_vals = { val1, val2, result };
        int[] missed = new int[3]; // for number of variants for each value
        int[][] options = new int[10][3];

        for (int i = 0; i < string_vals.length; i++) {

            //finds '?' in values input - only 1 '?' is allowed yet
            missed[i] = countSymbolInString(string_vals[i], '?');
            if (missed[i] > 1)
                return "Only ONE figure in any single value can be '?' !!!";

            //fill in the array with all options of hidden figures
            if (missed[i] == 0)
                options[0][i] = Integer.parseInt(string_vals[i]);
            else {
                for (int j = 0; j < (int)(Math.pow(10, missed[i])); j++)
                    options[j][i] = Integer.parseInt(string_vals[i].replace(String.valueOf('?'), Integer.toString(j)));
            }

        }

        //checks all possible combinations
        for (int i = 0; i < (int)(Math.pow(10, missed[0])); i++) {//val1
            for (int j = 0; j < (int)(Math.pow(10, missed[1])); j++) {//val2
                for (int z = 0; z < (int)(Math.pow(10, missed[2])); z++) {//result
                    if((options[i][0] + options[j][1]) == options[z][2]){//combination found!
                        return "Matched figures found: " + options[i][0] + " + " + options[j][1] + " = " + options[z][2];
                    }
                }
            }
        }
 
         return "NO solution found!";
    }

    // counts the number symbol 'c' encounters in the string
    private static int countSymbolInString(String string, char c) {
        return string.length() - string.replace(String.valueOf(c), "").length();
    }

    private static void task03() {
        // Реализовать простой калькулятор
        double val1 = readDbl("Enter value #1: ");
        double val2 = readDbl("Enter value #2: ");
        String operation = readStr("Enter operation (+, -, *, /): ");

        System.out.println(val1 + " " + operation + " " + val2 + " = " + calculator(val1, val2, operation));
    }

    private static double calculator(double val1, double val2, String oper) {
        double res = -10000000;
        switch (oper) {
            case "+":
                res = val1 + val2;
                break;
            case "-":
                res = val1 - val2;
                break;
            case "*":
                res = val1 * val2;
                break;
            case "/":
                if (val2 == 0)
                    System.out.println("Cannot divide by zero!!!");
                else
                    res = val1 / val2;
                break;
            default:
                System.out.println("Wrong operation! Only '+', '-', '*' and '/' are allowed.");
                break;

        }

        return res;
    }

    private static void task02() {
        // Вывести все простые числа от 1 до 1000
        int n = 1000;
        printPrimesToN(n);
    }

    private static void printPrimesToN(int num) {
        boolean ifPrime;
        System.out.printf("1, 2");
        for (int i = 3; i <= num; i += 2) {
            ifPrime = true;
            for (int j = 3; j < i / 3 + 1; j++) {
                if (i % j == 0) {
                    ifPrime = false;
                    break;
                }
            }
            if (ifPrime)
                System.out.printf(", %d", i);
        }
        System.out.println();
    }

    private static void task01() {
        // Вычислить сумму чисел от 1 до n
        int n = 0;
        while (n < 1)
            n = readInt("Enter a value >= 1: ");
        System.out.printf("The sum from 1 to %d is %d.\n", n, sumToN(n));
    }

    // computes sum of values from 1 to n
    private static int sumToN(int n) {
        return n * (n + 1) / 2;
    }

    private static int readInt(String string) {

        int res = 0;
        Scanner iScanner = new Scanner(System.in);

        System.out.printf(string);
        boolean flag = iScanner.hasNextInt();// if input value is int

        if (flag)
            res = iScanner.nextInt();

        return res;
    }

    private static double readDbl(String string) {

        double res = 0;
        Scanner iScanner = new Scanner(System.in);

        System.out.printf(string);
        boolean flag = iScanner.hasNextDouble();// if input value is int

        if (flag)
            res = iScanner.nextDouble();

        return res;
    }

    private static String readStr(String string) {

        int res = 0;
        Scanner iScanner = new Scanner(System.in);

        System.out.printf(string);

        return iScanner.nextLine();
    }
}

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Task04 {
    public static void logSimpleCalc(String fName) throws IOException {

        Logger logger = Logger.getLogger(Task04.class.getName());
        FileHandler fh = new FileHandler(fName);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        char proceed = 'y';
        while (proceed == 'y' || proceed == 'н') {
            double val1 = readDbl("Enter value #1: ");
            double val2 = readDbl("Enter value #2: ");
            String operation = readStr("Enter operation (+, -, *, /): ");

            String res = val1 + " " + operation + " " + val2 + " = " + calculator(val1, val2, operation);

            logger.log(Level.INFO, res);

            proceed = readStr("Next operation? (Y/N): ").toLowerCase().charAt(0);
        }
    }

    private static String calculator(double val1, double val2, String oper) {
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
                    return "Cannot divide by zero!!!";
                else
                    res = val1 / val2;
                break;
            default:
                return "Wrong operation! Only '+', '-', '*' and '/' are allowed.";

        }

        return String.valueOf(res);
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

        Scanner iScanner = new Scanner(System.in);

        System.out.printf(string);

        return iScanner.nextLine();
    }

}

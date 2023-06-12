import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task04 {
    // 📌 Напишите метод, который составит строку, состоящую из 100
    // повторений слова TEST и метод, который запишет эту строку в
    // простой текстовый файл, обработайте исключения.

    // David
    public static void writeTestToFile(int n) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            pw.println(generateString("TEST", n));
        }
    }

    public static String generateString(String s, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Olga
    public static String createString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; ++i) {
            sb.append("TEST ");
        }
        String result = sb.toString();
        return result;
    }

    public static void writer(String line) throws IOException {
        File file = new File("Test.txt");
        try (FileWriter fw = new FileWriter(file, false)) {
            fw.write(line);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Anton
    public static String createString(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append("TEST ");
        }

        return sb.toString();
    }

    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

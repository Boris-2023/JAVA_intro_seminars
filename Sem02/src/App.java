import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        // Task01.execute();

        // Task02
        String input = "aaaaaaaaaaaaaaaaaabbbcdd";
        if (!input.isEmpty()) {
            String compressed = Task02.compressString(input);
            System.out.println(compressed);
        }

        // Task03

        // Task04
        // 📌 Напишите метод, который составит строку, состоящую из 100
        // повторений слова TEST и метод, который запишет эту строку в
        // простой текстовый файл, обработайте исключения.

        Task04.writeTestToFile(100);// David

        // Olga
        String bufferLine = Task04.createString();
        Task04.writer(bufferLine);

        // Anton
        String str = Task04.createString(100);
        Task04.writeToFile("file.txt", str);


        // Task05 & 06
        // Задание №5
        // 📌 Напишите метод, который вернет содержимое текущей папки в виде
        // массива строк.
        // 📌 Напишите метод, который запишет массив, возвращенный предыдущим
        // методом в файл.
        // 📌 Обработайте ошибки с помощью try-catch конструкции. В случае
        // возникновения исключения, оно должно записаться в лог-файл.

        // Задание №6 (доп)
        // 📌 Напишите метод, который определит тип (расширение) файлов из
        // текущей папки и выведет в консоль результат вида
        // 1 Расширение файла: txt
        // 2 Расширение файла: pdf
        // 3 Расширение файла:
        // 4 Расширение файла: jpg

        try {
            String[] fldrCnt = Task05.getCrntFldrCnts();
            Task05.wrtArrToFile(fldrCnt, "filenames.txt");
            Task05.dtrmFileExts(fldrCnt);
        } catch (IOException e) {
            Task05.wrtExcptToLogFile(e, "log.txt");
        }

    }
}

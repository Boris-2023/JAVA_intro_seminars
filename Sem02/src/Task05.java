import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task05 {
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

    // public static List <String> fileName(String DirPath){
    //     List <String> fNames = ArrayList<>();
    //     File directory = new File(DirPath);
    //     if(directory.isDirectory()){
    //         for(File item: directory.listFiles()){//access to each file
    //             fNames.add(item.getName());

    //             //print the extensions - task 6
    //             try{//as extention may be absent!
    //                 System.out.println(item.getName().substring(item.getName().lastIndexOf('.')));
    //             } catch{
    //                 System.out.println("No extention!");
    //             }
    //         }
    //     }

    //     return fNames;
    // }

   //Vladimir
    public static String[] getCrntFldrCnts() {
        File folder = new File(".");
        return folder.list();
    }

    public static void wrtArrToFile(String[] array, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String item : array) {
                writer.write(item);
                writer.write(System.lineSeparator());
            }
            System.out.println("Успех.");
        }
    }

    public static void dtrmFileExts(String[] folderContents) {
        int count = 1;
        for (String fileName : folderContents) {
            File file = new File(fileName);
            if (file.isFile()) {
                String extension = getExt(fileName);
                System.out.printf("%d Расширение файла: %s%n", count++, extension);
            }
        }
    }

    public static String getExt(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return "";
        } else {
            return fileName.substring(dotIndex + 1);
        }
    }

    public static void wrtExcptToLogFile(Exception e, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(e.toString());
            writer.write(System.lineSeparator());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                writer.write(element.toString());
                writer.write(System.lineSeparator());
            }
            System.out.println("Исключение записано в лог.");
        } catch (IOException ex) {
            System.err.println("Ошибка записи в лог: " + ex.getMessage());
        }
    }

}

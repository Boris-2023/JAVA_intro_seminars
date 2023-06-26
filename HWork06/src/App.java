import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;

import Stock.Laptop;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

        Laptop laptop001 = new Laptop(15.6, "ASUS VivoBook PRO 15", "M6500QC-HN058", "Blue", "Full HD (1920x1080)",
                "IPS", "AMD Ryzen 5", 3.3, 6, 16, 512, "GeForce RTX 3050", 4, "Not installed",
                formatter.parse("Apr 2023"), 72999, 1);
        Laptop laptop002 = new Laptop(17.3, "MSI GF76 Katana", "11UC-879XRU", "Black", "Full HD (1920x1080)", "IPS",
                "Intel Core i5-11400H", 2.7, 6, 8, 512, "GeForce RTX 3050", 4, "Not installed",
                formatter.parse("Feb 2023"), 76999, 2);
        Laptop laptop003 = new Laptop(17.3, "MSI GF76 Katana", "12UE-659XRU", "Blue", "Full HD (1920x1080)", "IPS",
                "Intel Core i5-12450H", 2.0, 8, 16, 1024, "GeForce RTX 3060", 6, "Not installed",
                formatter.parse("May 2023"), 94999, 3);
        Laptop laptop004 = new Laptop(15.6, "Maibenben", "X558", "Grey", "Full HD (1920x1080)", "IPS",
                "AMD Ryzen 7 5800H", 3.2, 8, 16, 512, "GeForce RTX 3060", 6, "Linux", formatter.parse("Dec 2022"),
                79999, 4);
        Laptop laptop005 = new Laptop(15.6, "ASUS VivoBook PRO 15", "M6500QC-HN058", "Blue", "Full HD (1920x1080)",
                "IPS", "AMD Ryzen 5", 3.3, 6, 16, 512, "GeForce RTX 3050", 4, "Not installed",
                formatter.parse("Mar 2023"), 72999, 5);
        Laptop laptop006 = new Laptop(17.3, "MSI Vector GP77", "13VG-060XRU", "Black", "Quad HD 2K (2560x1440)", "IPS",
                "Intel Core i7-13700H", 2.4, 14, 16, 2048, "GeForce RTX 4070", 8, "Not Installed",
                formatter.parse("May 2023"), 194999, 6);
        Laptop laptop007 = new Laptop(17.3, "MSI Katana GF76", "12UD-259RU", "Green", "Full HD (1920x1080)", "IPS",
                "Intel Core i7-12650H", 2.3, 10, 16, 512, "GeForce RTX 3050 Ti", 4, "Windows 11",
                formatter.parse("Oct 2022"), 104999, 7);

        // fill in the collection of laptops
        HashSet<Laptop> laptopStock = new HashSet<>();
        laptopStock.add(laptop002);
        laptopStock.add(laptop003);
        laptopStock.add(laptop004);
        laptopStock.add(laptop005);
        laptopStock.add(laptop006);

        // print selected
        System.out.println(laptop001);
        System.out.println(laptop002);

        // compare 2 laptops
        System.out.println();
        System.out.println(laptop001.equals(laptop002));// -> false
        System.out.println(laptop001.equals(laptop005));// -> true

        // find laptop in the set
        System.out.println();
        System.out.println(laptopStock.contains(laptop003));// -> true
        System.out.println(laptopStock.contains(laptop007));// -> false

        // filter
        HashSet<Laptop> laptopFiltered = Laptop.filter(laptopStock);
        if(laptopFiltered.size()!=0){
            System.out.println("\nResults for the search:");
            System.out.println(laptopFiltered);
        }

    }
}

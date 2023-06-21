package PhoneBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PhoneBook {

    public static void printSortedPB(HashMap<String, ArrayList<Integer>> pBook) {
        HashMap<String, ArrayList<Integer>> printPB = new HashMap<String, ArrayList<Integer>>();
        printPB = pBook;// to keep original pBook unchanged

        while (printPB.size() > 0) {
            String name = mostPopularName(printPB);// finds the name with biggest number of phones
            System.out.println(name + ": " + printPB.remove(name).toString().replace("[", "").replace("]", "") + ";");
        }

    }

    public static HashMap<String, ArrayList<Integer>> fillPB(String fname) {

        HashMap<String, ArrayList<Integer>> pBook = new HashMap<String, ArrayList<Integer>>();
        ArrayList<String> phones = readFile(fname);

        String[] contact;
        // ArrayList<Integer> list = new ArrayList<>();// initialization to keep the
        // phones
        for (String item : phones) {
            ArrayList<Integer> list = new ArrayList<>();
            contact = item.split(":");

            if (pBook.containsKey(contact[0])) {// contact already has numbers - load existing numbers
                list = pBook.get(contact[0]);
            }

            list.add(Integer.parseInt(contact[1].replace(" ", "")));// add new number
            pBook.put(contact[0], list);// saves the numbers to the phonebook

        }

        return pBook;
    }

    private static String mostPopularName(HashMap<String, ArrayList<Integer>> pBook) {
        String name = "";

        Set<String> names = pBook.keySet();//gets the names of phoneBook

        int numMax = 0;//max value to compare
        for (String n : names) {
            int sz = pBook.get(n).size();//number of phones for current name
            if (sz > numMax) {
                numMax = sz;
                name = n;
            }
        }

        return name;
    }

    private static ArrayList<String> readFile(String fname) {
        ArrayList<String> phones = new ArrayList<>();
        try {
            File file = new File(fname);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();// reads 1st string - may be empty
                while (line != null) {
                    phones.add(line);
                    line = reader.readLine(); // reads next strings in a loop
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return phones;
    }

}

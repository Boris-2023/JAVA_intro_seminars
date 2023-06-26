package Stock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Laptop {

    public double screenSize;
    public String name;
    public String model;
    public String color;
    public String resolution;
    public String matrixType;
    public String procManufacture;
    public double procFrequency;
    public int coresNum;
    public int ramGb;
    public int ssdGb;
    public String videoCard;
    public int videoMemory;
    public String oSystem;
    public Date dateManufactured;
    public double price;
    public long id;

    public Laptop(double screenSize, String name, String model, String color, String resolution, String matrixType,
            String procManufacture, double procFrequency, int coresNum, int ramGb, int ssdGb, String videoCard,
            int videoMemory,
            String oSystem, Date dateManufactured, double price, long id) {

        this.screenSize = screenSize;
        this.name = name;
        this.model = model;
        this.color = color;
        this.resolution = resolution;
        this.matrixType = matrixType;
        this.procManufacture = procManufacture;
        this.procFrequency = procFrequency;
        this.coresNum = coresNum;
        this.ramGb = ramGb;
        this.ssdGb = ssdGb;
        this.videoCard = videoCard;
        this.videoMemory = videoMemory;
        this.oSystem = oSystem;
        this.dateManufactured = dateManufactured;
        this.price = price;
        this.id = id;
    }

    public static HashSet<Laptop> filter (HashSet<Laptop> ltSet) {

        String inStr = inputUser("\nWould you like to filter LapTops? (Y/N): ");
        HashSet<Laptop> filtered = new HashSet<>();

        if (inStr.toLowerCase().equals("y")) {

            HashMap<Integer, String> filters = fillFilters();// fikl in the fields for filter (basically 5)
            

            System.out.println();
            for (Object key : filters.keySet()) {// print the filters fields
                System.out.println(key + " -> " + filters.get(key));
            }

            // choose the field for filter
            int fld = Integer
                    .parseInt(inputUser("\nEnter a digit from list above to choose the filter (minimum parameter): "));
            
            if (filters.containsKey(fld)) { // eligible value input

                String fldValue = inputUser("Enter a value for '" + filters.get(fld) + "' to filter: ");
                if (fld == 4) {// String value of color
                    for (Laptop laptop : ltSet) {
                        if (laptop.color.toLowerCase().equals(fldValue.toLowerCase()))
                            filtered.add(laptop);
                    }
                } else {
                    Double fltValDbl = Double.parseDouble(fldValue);// parse the value into numeric
                    for (Laptop laptop : ltSet) {
                        switch (fld) {
                            case 1:// screen size
                                if (laptop.screenSize >= fltValDbl)
                                    filtered.add(laptop);
                                break;
                            case 2:// RAM size
                                if ((double) laptop.ramGb >= fltValDbl)
                                    filtered.add(laptop);
                                break;
                            case 3:// SSD size
                                if ((double) laptop.ssdGb >= fltValDbl)
                                    filtered.add(laptop);
                                break;
                            case 5:// Price
                                if ((double) laptop.price >= fltValDbl)
                                    filtered.add(laptop);
                                    System.out.println((double) laptop.price + " vs " + fltValDbl);
                                break;
                            default:
                                break;
                        }
                    }
                }
                if(filtered.size()==0){
                    System.out.println("\nNO elements found for this search!");
                }
            } else { // no such value in the list
                System.out.println("\nNo such criteria listed! Have a nice day!");
            }
        }
        return filtered;
    }

    // fill in the filters
    private static HashMap<Integer, String> fillFilters() {
        HashMap<Integer, String> filters = new HashMap<>();
        filters.put(1, "Screen Size");
        filters.put(2, "RAM size");
        filters.put(3, "SSD size");
        filters.put(4, "Color");
        filters.put(5, "Price");
        return filters;
    }
    
    private static String inputUser(String message) {
        System.out.print(message);
        Scanner scannerNumber = new Scanner(System.in);
        return scannerNumber.nextLine();
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

        return "\nLaptop [Screen size: " + screenSize + ", Name: " + name + ", Model: " + model + ", Color: " + color
                + ", Screen resolution: " + resolution + ", Matrix type: " + matrixType + ", Processor: "
                + procManufacture
                + ", Frequency: " + procFrequency + ", Number of cores: " + coresNum + ", RAM: " + ramGb
                + ", Video card: "
                + videoCard + ", Video memory: " + videoMemory + ", SSD: " + ssdGb + ", OS: " + oSystem
                + ", date of manufacture: "
                + formatter.format(dateManufactured) + ", Price: " + price + ", ID: " + id + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenSize, name, model, color, resolution, matrixType, procManufacture, procFrequency,
                coresNum, ramGb, ssdGb, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;

        if (Double.doubleToLongBits(screenSize) != Double.doubleToLongBits(other.screenSize))
            return false;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;

        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;

        if (resolution == null) {
            if (other.resolution != null)
                return false;
        } else if (!resolution.equals(other.resolution))
            return false;

        if (matrixType == null) {
            if (other.matrixType != null)
                return false;
        } else if (!matrixType.equals(other.matrixType))
            return false;

        if (procManufacture == null) {
            if (other.procManufacture != null)
                return false;
        } else if (!procManufacture.equals(other.procManufacture))
            return false;

        if (Double.doubleToLongBits(procFrequency) != Double.doubleToLongBits(other.procFrequency))
            return false;

        if (coresNum != other.coresNum)
            return false;

        if (ramGb != other.ramGb)
            return false;

        if (ssdGb != other.ssdGb)
            return false;

        if (videoCard == null) {
            if (other.videoCard != null)
                return false;
        } else if (!videoCard.equals(other.videoCard))
            return false;

        if (videoMemory != other.videoMemory)
            return false;

        if (oSystem == null) {
            if (other.oSystem != null)
                return false;
        } else if (!oSystem.equals(other.oSystem))
            return false;

        return true;
    }

}

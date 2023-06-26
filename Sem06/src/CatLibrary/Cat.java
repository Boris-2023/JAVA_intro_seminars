package CatLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Cat {

    public int weight;
    public String name;
    public int color;
    public Date age;
    public boolean gender;
    public long id;
    
    public Cat(int weight, String name, int color, Date age, boolean gender, long id) {
        this.weight = weight;
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }
    
    public boolean medSupport(){
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
        
        return "Кличка: " + name + ";\tId: " + id + ";\tвес: "+ weight + ";\tдата рождения: " + formatter.format(age) + "\tи т.д.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//self compare
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return weight == cat.weight && color == cat.color && gender == cat.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name, color, age, gender, id);
    }

}

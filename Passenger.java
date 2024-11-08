// Class; information about passengers
public class Passenger {
    // private to follow OOP encapsulation
    private String name;
    private int age;

    // Constructor 
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //Only need to check String:name not age, if seat isEmpty then:
    public boolean isEmpty() { //calls method isEmpty
        return this.name.equals(""); // compares name of the object Passenger to an empty string: true/false
    }

    @Override
    public String toString() { //Custom toString method to display passenger details, readabilty
        return isEmpty() ? "(empty)" : name + " " + age;
    }
}

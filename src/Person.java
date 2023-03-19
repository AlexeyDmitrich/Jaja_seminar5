import java.util.ArrayList;

public class Person {
    int id;
    String name;
    String surname;
    ArrayList<Integer> numbers = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(int number) {
        this.numbers.add(number);
    }

}

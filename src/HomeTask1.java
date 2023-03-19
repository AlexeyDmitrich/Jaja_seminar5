import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HomeTask1 {
    //Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    //Добавить функции 1) Добавление номера
    //2) Вывод всего
    public static void main(String[] args) {

    }

    public static Map phoneBook (){
        Map phoneBook = new HashMap<>();
        int number = 1;
        while (number != 0) {
            number = input.Int("Введите номер");
            phoneBook.put(createAbonent(), number);
        }

    }
    public static Person createAbonent (){
        String name = input.Str("Введите имя");
        String surname = input.Str("Введите фамилию");
        Person abonent = new Person(name, surname);
        return abonent;
    }
}

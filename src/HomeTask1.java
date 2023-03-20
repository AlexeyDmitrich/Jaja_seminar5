import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeTask1 {
    //Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    //Добавить функции 1) Добавление номера
    //2) Вывод всего
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.newContact("Иван Иванов", 523452);
        phoneBook.newContact("Светлана Петрова", 652652);
        phoneBook.newContact("Кристина Белова", 62657);
        phoneBook.newContact("Анна Мусина", 6543632);
        phoneBook.newContact ("Анна Крутова", 9087865);
        phoneBook.newContact ("Иван Юрин", 9348945);
        menu(phoneBook);

    }

    /**
     * добавление контакта
     * @param phoneBook
     */
    public static void addContact (PhoneBook phoneBook){
        String abonent = input.Str("Введите имя абонента");
        long num = input.Long("Введите номер телефона");
        phoneBook.newContact(abonent, num);
    }

    /**
     * добавление номера контакту
     * @param phoneBook
     */
    public static void addNumber (PhoneBook phoneBook){
        String name = input.Str("Введите имя абонента");
        long num = input.Long("Введите номер телефона");
        phoneBook.addNumberToContact(name, num);
    }

    /**
     * демонстрация всей книги
     * @param phoneBook
     */
    public static void showAll (PhoneBook phoneBook){
        System.out.println(phoneBook.toString());
    }

    /**
     * меню
     * @param phoneBook
     */
    public static void menu (PhoneBook phoneBook){
        int choise = 5;
        while (choise != 0) {
            System.out.println("\t \tМЕНЮ");
            System.out.println("1. Добавить контакт\t");
            System.out.println("2. Добавить номер контакту\t");
            System.out.println("3. Вывести всё\t");
            System.out.println("0. Выход\t");
            choise = input.Int("Выберите действие: ");
            switch (choise) {
                case 1:
                    addContact(phoneBook);
                    break;
                case 2:
                    addNumber(phoneBook);
                    break;
                case 3:
                    showAll(phoneBook);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неа, такого варианта не было");
                    menu(phoneBook);
                    break;
            }
        }
    }
}

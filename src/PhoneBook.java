import com.sun.javafx.binding.StringFormatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс построен на Мапе
 */
public class PhoneBook {
    Map<String, Set> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<String, Set>();
    }

    /**
     * функция добавления нового абонента
     * @param abonent
     * @param number
     * если абонент с таким именем есть - предложим добавить к нему номер или отменить операцию
     */
    public void newContact (String abonent, long number){
        Set<Long> num = new HashSet<>();
        num.add(number);
        if (!phoneBook.containsKey(abonent)) {
            phoneBook.put(abonent, num);
        }
        else {
            System.out.println("Абонент с таким именем уже есть");
            int choise = input.Int("обновить его? \n1.\t Обновить\n0.\t Отмена");
            switch (choise) {
                case 1:
                    if (phoneBook.get(abonent).contains(number)) {
                        System.out.println("И номер этот уже записан");
                    } else {
                        System.out.println("Добавляем номер...");
                        phoneBook.get(abonent).add(number);
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    /**
     * функция добавления номера абоненту. конечно же, мы проверим, есть ли такой
     * @param abonent
     * @param newNumber
     * если абонента еще нет - предложим его создать.
     */
    public void addNumberToContact (String abonent, long newNumber){
        if (phoneBook.containsKey(abonent)) {
            Set nums = phoneBook.get(abonent);
            nums.add(newNumber);
            phoneBook.putIfAbsent(abonent, nums);
        }
        else {
            System.out.println("Такого абонента нет.");
            int choise = input.Int("Создать? \n1. \tда \n0. \tнет");
            switch (choise){
                case 1:
                    newContact(abonent,newNumber);
                    break;
                case 0:
                    return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out= new StringBuilder();
        for (Map.Entry <String, Set> contact: phoneBook.entrySet()) {
            out.append("Имя: ");
            out.append(contact.getKey());
            out.append("\tНомера:");
            out.append(contact.getValue());
            out.append("\n");
        }

        return out.toString();
    }
}

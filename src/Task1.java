import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        HashMap<Integer, String> bd_pas = pasports();
        for (Map.Entry <Integer, String> item:bd_pas.entrySet()){
            if (item.getValue().equals("Иванов")){
                System.out.println(item.getKey());
                System.out.println(item.getValue());
            }
        }
        for (Map.Entry <Integer,String> item: bd_pas.entrySet()) {
            if (item.getKey() == 234561){
                System.out.printf("Номер: %s  Фамилия: %s \n", item.getKey(), item.getValue());
            }
        }
    }

    public static HashMap<Integer, String> pasports(){
        HashMap<Integer, String> pasport = new HashMap();
        pasport.put(123456, "Иванов");
        pasport.put(321456, "Васильев");
        pasport.put(234561, "Петрова");
        pasport.put(234432, "Иванов");
        pasport.put(654321, "Петрова");
        pasport.put(345678, "Иванов");
        int number = 1;
        while (number != 0) {
            number = input.Int("Введите номер паспорта");
            String surname = input.Str("Введите фамилию");
            pasport.put(number,surname);
        }

        return pasport;
    }

}

import java.util.*;

public class HomeTask2 {
    //    Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
    //
    //Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    //Отсортировать по убыванию популярности Имени.

    public static void main(String[] args) {
        String pairs = "Иван Иванов\n" +
                "Светлана Петрова\n" +
                "Кристина Белова\n" +
                "Анна Мусина\n" +
                "Анна Крутова\n" +
                "Иван Юрин\n" +
                "Петр Лыков\n" +
                "Павел Чернов\n" +
                "Петр Чернышов\n" +
                "Мария Федорова\n" +
                "Марина Светлова\n" +
                "Мария Савина\n" +
                "Мария Рыкова\n" +
                "Марина Лугова\n" +
                "Анна Владимирова\n" +
                "Иван Мечников\n" +
                "Петр Петин\n" +
                "Иван Ежов";

        Map blocks = namesPairs(pairs);
//        System.out.println(toString(blocks));
        String[] sorted = sortedBlocks(blocks);
        printArr(sorted);
    }

    /**
     * Метод для формирования мапы
     * @param pairs из строки, содержащей подстроки: "имя фамилия\n"
     * @return вернёт HashMap (String Имя, Integer ЧастотаУпотребления)
     */
    public static Map namesPairs (String pairs){
        Map<String, Integer> blocks = new HashMap<>();
        String[] x2 = pairs.split("\n");
        String[][] x1 = new String[x2.length][];
        for (int i = 0; i < x1.length; i++) {
            x1[i] = x2[i].split(" ");
        }
        for (int i = 0; i < x1.length; i++) {
        }
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1[i].length; j++) {
                if (j==0) {
                    if (!blocks.containsKey(x1[i][j])){
                        blocks.put(x1[i][j], 1);
                    }
                    else {
                        int counter = blocks.get(x1[i][j]);
                        counter++;
                        blocks.put(x1[i][j], counter);
                    }
                }
            }
        }
        return blocks;
    }

    /**
     * метод для сортировки по популярности
     * @param blocks принимает мап уникальных значений с числом задействования
     * @return возвращает массив строк
     */
    public static String[] sortedBlocks (Map<String, Integer> blocks){
        String[] sortBlock = new String[blocks.size()];
        int max = blocks.size();
        int i = 0;
        while (max>1) {
            if (blocks.containsValue(max)) {
                for (Map.Entry<String, Integer> name : blocks.entrySet()) {
                    if (name.getValue() == max) {
                        sortBlock[i] = name.getKey();
                        sortBlock[i] += ":\t ";
                        sortBlock[i] += (name.getValue()).toString();
                        i++;
                    }
                }
                max--;
            }
            else {
                max--;
            }
        }
        return sortBlock;
    }

    public static String toString(Map<String, Integer> names) {
        StringBuilder out= new StringBuilder();
        for (Map.Entry <String, Integer> name: names.entrySet()) {
            out.append("Имя: ");
            out.append(name.getKey());
            out.append("\tЧастота:");
            out.append(name.getValue());
            out.append("\n");
        }
        return out.toString();
    }

    public static void printArr (String[] array){
        for (int i = 0; i < array.length; i++) {
            try {
                if (!array[i].isEmpty()) {
                    System.out.println(array[i]);
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
    }
}

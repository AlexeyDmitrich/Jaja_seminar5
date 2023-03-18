import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        String s = "title";//input.Str("Введите строку1");
        String k = "paper";//input.Str("Введите строку2");
        System.out.println(is_isomorphe(s,k));
    }

    public static boolean is_isomorphe (String st, String kt){
        if (st.length()!=kt.length()){return false;}
        Map <Character, Character> isomor = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            if (!isomor.containsKey(st.charAt(i))){
                isomor.putIfAbsent(st.charAt(i), kt.charAt(i));
            }
            else {
                if (isomor.get(st.charAt(i)) != kt.charAt(i)){
                    return false;
                }
            }
        }
        Map <Character, Character> isomor_reverse = new HashMap<>();
        for (int i = 0; i < kt.length(); i++) {
            if (!isomor_reverse.containsKey(kt.charAt(i))){
                isomor_reverse.putIfAbsent(kt.charAt(i), st.charAt(i));
            }
            else {
                if (isomor_reverse.get(kt.charAt(i)) != st.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

}

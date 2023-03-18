import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        String math = "[6+(3*3)]";
        String math2 = "a+(1*3)]";
        System.out.println(is_valid(math));
        System.out.println(is_valid(math2));
    }

    public static boolean is_valid (String st){
        Map <Character, Character> math_text = new HashMap<>();
        math_text.put(')', '(');
        math_text.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] str = st.toCharArray();
        for (char ch:
             str) {
            if (math_text.containsValue(ch)) { //(ch=='(' || ch=='[')
                stack.push(ch);
            }
            if (math_text.containsKey(ch) ){
                if (math_text.get(ch)==stack.peek()&& !stack.isEmpty()){
                    stack.pop();
                }
                else return false;
            }
//            else return false;
        }
        if (stack.isEmpty()){
            return true;
        }
        else return false;
    }
}

//
//    public static boolean isRight(String str){
//        Stack<Character> stack = new Stack<>();
//        Map<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('[', ']');
//        map.put('{', '}');
//
//        for (char c : str.toCharArray()){
//            if (map.containsKey(c)){
//                stack.add(c);
//            }
//
//            for (Map.Entry<Character, Character> entry : map.entrySet()){
//                if (c == entry.getValue()){
//                    if (!stack.isEmpty() && stack.peek() == entry.getKey())
//                        stack.pop();
//                    else
//                        return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//    public static void main(String[] args) {
//        System.out.println(isRight("[(6+{3*3})]"));
//    }
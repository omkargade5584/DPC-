import java.util.*;

public class Day12{
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // odd length can't be valid
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = {"()", "([)]", "[{()}]", "", "{[}"};
        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\" -> " + isValid(test));
        }
    }
}

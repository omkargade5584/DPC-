import java.util.*;

public class Day19 {

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split("\\s+");

        for (String token : tokens) {
            
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {
                
                int a = stack.pop();  
                int b = stack.pop();  
                
                switch (token) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a); 
                        break;
                }
            } else {
                
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); 
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("2 1 + 3 *")); 
        System.out.println(evaluatePostfix("5 6 +")); 
        System.out.println(evaluatePostfix("-5 6 -")); 
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); 
        System.out.println(evaluatePostfix("5")); 
    }
}

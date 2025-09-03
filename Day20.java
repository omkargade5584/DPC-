import java.util.Stack;

public class Day20 {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: if stack has only one element or is empty
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively sort the remaining stack
        sortStack(stack);

        // Step 3: Insert the popped element back in sorted order
        insertInSortedOrder(stack, top);
    }

    // Helper function to insert an element into sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // If stack empty OR top <= element → safe to insert
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Otherwise, pop the top and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, element);

        // Push the popped element back
        stack.push(top);
    }

    // Driver code to test
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

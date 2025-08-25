import java.util.*;

public class Day11 {
    public static List<String> permuteUnique(String s) {
        Set<String> resultSet = new HashSet<>();
        char[] chars = s.toCharArray();
        backtrack(chars, 0, resultSet);
        return new ArrayList<>(resultSet);
    }

    private static void backtrack(char[] chars, int index, Set<String> resultSet) {
        if (index == chars.length) {
            resultSet.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            backtrack(chars, index + 1, resultSet);
            swap(chars, index, i); 
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String[] testCases = {"abc", "aab", "aaa", "a", "abcd"};

        for (String test : testCases) {
            System.out.println("Input: " + test);
            List<String> result = permuteUnique(test);
            System.out.println("Output: " + result);
            System.out.println("Total permutations: " + result.size());
            System.out.println();
        }
    }
}

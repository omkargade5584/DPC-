import java.util.*;

public class Day10 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); 

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"eat", "tea", "tan", "ate", "nat", "bat"},
            {""},
            {"a"},
            {"abc", "bca", "cab", "xyz", "zyx", "yxz"},
            {"abc", "def", "ghi"}
        };

        for (String[] test : testCases) {
            System.out.println("Input: " + Arrays.toString(test));
            System.out.println("Output: " + groupAnagrams(test));
            System.out.println();
        }
    }
}

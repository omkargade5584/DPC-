public class Day9 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
           
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"apple", "ape", "april"},
            {""},
            {"alone"}
        };

        for (String[] test : testCases) {
            System.out.print("Input: ");
            for (String s : test) System.out.print(s + " ");
            System.out.println("\nOutput: \"" + longestCommonPrefix(test) + "\"\n");
        }
    }
}

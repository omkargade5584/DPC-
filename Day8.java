public class ReverseWords {
    public static String Day8(String s) {
        
        String[] words = s.trim().split("\\s+");
        
        
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "the sky is blue",
            "  hello world  ",
            "a good   example",
            "    ",
            "word"
        };

        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\"");
            System.out.println("Output: \"" + reverseWords(test) + "\"");
            System.out.println();
        }
    }
}

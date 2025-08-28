import java.util.HashMap;

public class Day14 {
    
    public static int substringsWithKDistinct(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private static int atMostK(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            
            count += (right - left + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(substringsWithKDistinct("pqpqs", 2)); // 7
        System.out.println(substringsWithKDistinct("aabacbebebe", 3)); // 10
        System.out.println(substringsWithKDistinct("a", 1)); // 1
        System.out.println(substringsWithKDistinct("abc", 3)); // 1
        System.out.println(substringsWithKDistinct("abc", 2)); // 2
    }
}

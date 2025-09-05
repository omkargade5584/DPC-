import java.util.*;

public class Day22 {

    public static int firstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        return -1; 
    }

    
    public static void main(String[] args) {
        System.out.println(firstElementKTimes(new int[]{3, 1, 4, 4, 5, 2, 6, 1, 4}, 2)); 
        System.out.println(firstElementKTimes(new int[]{2, 3, 4, 2, 2, 5, 5}, 2));       
        System.out.println(firstElementKTimes(new int[]{1, 1, 1, 1}, 1));                
        System.out.println(firstElementKTimes(new int[]{10}, 1));                        
        System.out.println(firstElementKTimes(new int[]{6, 6, 6, 6, 7, 7, 8, 8, 8}, 3));
    }
}

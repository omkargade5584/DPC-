import java.util.Arrays;

public class MissingNumber {
    public static int findMissing(int[] arr) {
        int n = arr.length + 1; 
        long totalSum = (long) n * (n + 1) / 2; 
        long arrSum = 0;
        
        for (int num : arr) {
            arrSum += num;
        }
        
        return (int)(totalSum - arrSum);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 4, 5},
            {2, 3, 4, 5},
            {1, 2, 3, 4},
            {1},
            
        };
        
        for (int[] test : testCases) {
            System.out.println("Array: " + Arrays.toString(test));
            System.out.println("Missing number: " + findMissing(test));
            System.out.println();
        }
    }
}

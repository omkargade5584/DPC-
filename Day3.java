public class Day3 {
    public static int findDuplicate(int[] arr) {
       
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

       
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow; 
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 3, 4, 2, 2},
            {3, 1, 3, 4, 2},
            {1, 1},
            {1, 4, 4, 2, 3}
        };

        for (int[] test : testCases) {
            System.out.print("Input: ");
            for (int num : test) System.out.print(num + " ");
            System.out.println("\nDuplicate number: " + findDuplicate(test));
            System.out.println();
        }
    }
}

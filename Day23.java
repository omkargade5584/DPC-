

public class Day23 {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the window (from front)
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements (from back)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record the max for this window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    // ✅ Driver code
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();

        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(arr1, 3))); // [3, 3, 5, 5, 6, 7]

        int[] arr2 = {1, 5, 3, 2, 4, 6};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(arr2, 3))); // [5, 5, 4, 6]

        int[] arr3 = {7, 7, 7, 7};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(arr3, 1))); // [7, 7, 7, 7]

        int[] arr4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(arr4, 2))); // [2, 3, 4]
    }
}

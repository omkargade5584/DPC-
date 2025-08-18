import java.util.Arrays;

public class Day4 {
   
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = nextGap(m + n);

        while (gap > 0) {
            int i, j;

            
            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

           
            for (j = (gap > m ? gap - m : 0); i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            
            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }

            gap = nextGap(gap);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}

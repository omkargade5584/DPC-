import java.util.*;

public class Day18 {

    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; 
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDivisors(12));   
        System.out.println(countDivisors(18));   
        System.out.println(countDivisors(29));   
        System.out.println(countDivisors(100)); 
        System.out.println(countDivisors(1));    
        System.out.println(countDivisors(997)); 
        System.out.println(countDivisors(36));   
    }
}

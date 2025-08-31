import java.util.*;

public class Day17 {
    
    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();

        // Step 1: Handle factor 2
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }

        // Step 2: Check odd numbers up to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n is still > 1, then it is a prime factor
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        System.out.println(primeFactors(18));       // [2, 3, 3]
        System.out.println(primeFactors(30));       // [2, 3, 5]
        System.out.println(primeFactors(49));       // [7, 7]
        System.out.println(primeFactors(19));       // [19]
        System.out.println(primeFactors(64));       // [2, 2, 2, 2, 2, 2]
        System.out.println(primeFactors(123456));   // [2, 2, 2, 2, 2, 3, 643]
    }
}

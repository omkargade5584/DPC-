import java.math.BigInteger;

public class Day29{

    public static BigInteger fibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n];
    }

    // ✅ Example usage
    public static void main(String[] args) {
        System.out.println(fibonacci(5));    // 5
        System.out.println(fibonacci(10));   // 55
        System.out.println(fibonacci(0));    // 0
        System.out.println(fibonacci(1000)); // Very large number
    }
}

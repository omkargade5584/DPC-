import java.util.*;

public class Day30 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;  // a large number representing "impossible"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;  // base case

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ✅ Example usage
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(cc.coinChange(new int[]{2}, 3));        // -1
        System.out.println(cc.coinChange(new int[]{1}, 0));        // 0
    }
}

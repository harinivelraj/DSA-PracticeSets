import java.util.Arrays;

public class CoinChange {

    // Function to count the number of ways to make the change
    public static int countWays(int[] coins, int n, int amount) {
        // Create a DP array to store solutions to subproblems
        int[] dp = new int[amount + 1];
        
        // Base case: There is one way to make the amount 0, i.e., by using no coins
        dp[0] = 1;

        // Iterate over each coin
        for (int coin : coins) {
            // Update dp[] for each amount greater than or equal to the coin's value
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }

    public static void main(String[] args) {
        // Coin denominations
        int[] coins = {1, 2, 3};
        int amount = 4;

        // Number of coin types
        int n = coins.length;

        System.out.println("Number of ways to make change: " + countWays(coins, n, amount));
    }
}

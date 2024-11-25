public class StockProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No profit can be made if there are fewer than 2 prices
        }

        int minPrice = prices[0]; // Minimum price seen so far
        int maxProfit = 0; // Maximum profit initialized to 0

        for (int i = 1; i < prices.length; i++) {
            // Calculate potential profit if selling today
            int profit = prices[i] - minPrice;

            // Update maxProfit if the current profit is higher
            maxProfit = Math.max(maxProfit, profit);

            // Update minPrice to the lowest seen so far
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example price data
        int profit = maxProfit(prices);
        System.out.println("Maximum Profit: " + profit); // Output: Maximum Profit: 5
    }
}

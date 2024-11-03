class Solution {
    int[] prices;
    int[][][] dp;;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        dp = new int[prices.length+1][k+1][2];
        return dp(0, k, 0);
    }

    public int dp(int i, int k, int holding) {
        // base case
        if(k ==0 || i ==prices.length)
            return 0;

        if(dp[i][k][holding] == 0) {
            // recurrence
            int doNothing = dp(i+1, k, holding);
            int purchase = 0;
            if(holding == 1) {
                purchase = prices[i] + dp(i+1, k-1, 0);
            } else {
                purchase = -prices[i] + dp(i+1, k, 1);
            }
            dp[i][k][holding] = Math.max(doNothing, purchase);
        }

        return  dp[i][k][holding];

    }

}
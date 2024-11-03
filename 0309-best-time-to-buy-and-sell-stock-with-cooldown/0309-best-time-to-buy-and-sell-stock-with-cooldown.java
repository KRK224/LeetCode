class Solution {
    int[][] dp;
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        dp = new int[prices.length+1][3];
        return dp(0, 0);
    }

    public int dp (int i, int states) {
        // base case
        if(i == prices.length)
            return 0;
        
        if(dp[i][states] == 0) {
            int doNothing = 0;
            if(states == 2) {
                doNothing = dp(i+1, 0);
            } else {
                doNothing = dp(i+1, states);
            }

            int doSomething = 0;

            if(states == 1) {
                doSomething = prices[i] + dp(i+1, 2);
            } else {
                if(states == 0)
                    doSomething = -prices[i] + dp(i+1, 1);
            }

            dp[i][states] = Math.max(doNothing, doSomething);

        }
        return dp[i][states];
    }
}
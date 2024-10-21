class Solution {
    public static int[] dp = new int[46];
    static {
        Arrays.fill(dp, -1);
    }
    public int climbStairs(int n) {
        return dp(n);        
    }

    public int dp(int n) {
        if(n ==1)
            return 1;
        if(n ==2)
            return 2;

        if(dp[n] != -1)
            return dp[n];
        dp[n] = dp(n-1) + dp(n-2);
        return dp[n];
    }
}
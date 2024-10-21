class Solution {
    public static int[] dp = new int[46];
    static {
        Arrays.fill(dp, -1);
    }
    public int climbStairs(int n) {
        // top-down with memoization
        // return dp(n);        
        return dpIter(n);
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

    public int dpIter(int n) {
        dp[1] =1;
        dp[2] =2;
        for(int i = 3; i<=n;++i) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
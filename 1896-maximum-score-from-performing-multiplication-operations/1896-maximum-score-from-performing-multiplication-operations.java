class Solution {
    public int[][] dp;
    public int M_SIZE;
    public int[] multiplier;
    public int[] num;
    public int N_SIZE;

    public int maximumScore(int[] nums, int[] multipliers) {
        M_SIZE = multipliers.length;
        num = nums;
        N_SIZE = nums.length;
        multiplier = multipliers;
        dp = new int[M_SIZE][M_SIZE];
        for(int[] row : dp) {
            // max 값을 찾아야하니까.
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return dp(0, 0);
        
    }

    public int dp(int i, int left) {
        // base case
        if(i == M_SIZE)
            return 0;
        
        if(dp[i][left]!= Integer.MIN_VALUE)
            return dp[i][left];
        
        int right = N_SIZE - 1 - (i-left);
        dp[i][left] = Math.max(num[left] * multiplier[i] +dp(i+1,left+1), num[right] * multiplier[i] + dp(i+1, left));
        return dp[i][left];
        
    }
}
class Solution {
    int[][] dp;
    int[][] matrix;
    int m, n;
    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);

        dp(0,0);

        int ans = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j< n; j++){
                if(dp[i][j] != -1)
                    ans += dp[i][j];
            }
        }

        return ans;

    }

    int dp(int i, int j) {
        // base case;
        if(i <0 || j< 0 || i>=m || j>=n)
            return 0;

        if(dp[i][j] == -1) {
            // 아예 못 만듬.
            if(matrix[i][j] == 0) {
                dp[i][j] = 0;
                dp(i+1, j);
                dp(i, j+1);
            }            else {
                dp[i][j] = Math.min(dp(i+1, j), Math.min(dp(i, j+1), dp(i+1, j+1))) +1;
            }
        }

        return dp[i][j];
    }
}
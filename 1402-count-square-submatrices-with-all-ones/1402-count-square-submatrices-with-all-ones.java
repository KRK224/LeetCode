class Solution {
    int[][] dp;
    int[][] budp; // bottom up dp
    int[][] matrix;
    int m, n;

    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        budp = new int[m + 1][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = 0;
        // ** top-down with recursion.
        // dp(0, 0);

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // ans += dp[i][j];
        // }
        // }

        /**
         * tabulation : bottom-up;
         */
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0)
                    budp[i][j] = 0;
                else {
                    budp[i][j] = Math.min(budp[i + 1][j], Math.min(budp[i + 1][j + 1], budp[i][j + 1])) + 1;
                }
                ans += budp[i][j];
            }
            
        }
        return ans;
    }


    int dp(int i, int j) {
        // base case;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;

        if (dp[i][j] == -1) {
            // 아예 못 만듬.
            if (matrix[i][j] == 0) {
                dp[i][j] = 0;
                // 그래도 다 호출해야하니까..
                dp(i + 1, j);
                dp(i, j + 1);
            } else {
                dp[i][j] = Math.min(dp(i + 1, j), Math.min(dp(i, j + 1), dp(i + 1, j + 1))) + 1;
            }
        }

        return dp[i][j];
    }
}
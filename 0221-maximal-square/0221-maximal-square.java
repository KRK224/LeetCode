class Solution {
    int[][] dp;
    int m, n;
    char[][] matrix;
    
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        // 사이즈 하나 더 크게
        dp = new int[m+1][n+1];

        // 초기화: -1, 1개 크게 만든 테이블 때문에 범위까지만 -1이고 그 외는 자연스럽게 0으로 처리.
        for(int i = 0; i< m; i++) {
            for (int j = 0; j< n; j++) {
                dp[i][j] = -1;
            }
        }

        dp(0, 0);
        int max = 0;
        for(int i =0; i<m; i++) {
            for (int j =0; j< n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }       

        return max*max;
    }

    // i,j 가 최상단 왼쪽인 경우에 만들 수 있는 최대 크기의 한 변 길이
    public int dp(int i, int j) {
        // memoization이 안된 경우 계산
        if(dp[i][j] == -1) {
            if(matrix[i][j] == '0') {
                dp[i][j] = 0;
                dp(i+1, j);
                dp(i, j+1);
            }                
            else {
                int l = Math.min(Math.min(dp(i+1, j), dp(i, j+1)), dp(i+1, j+1)) +1;
                dp[i][j] = l;
            }
        }

        return dp[i][j];
    }
}
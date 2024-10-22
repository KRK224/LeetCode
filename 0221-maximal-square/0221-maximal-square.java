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

        int max = 0;

        for(int i =m-1; i>=0; i--) {
            for (int j =n-1; j>=0; j--) {
                if(dp[i][j] ==-1) {
                    if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]) +1;
                    max = Math.max(dp[i][j], max);
                    } else {
                        dp[i][j] =0;
                    }
                }                
            }
        }       

        return max*max;
    }

    // i,j 가 최상단 왼쪽인 경우에 만들 수 있는 최대 크기의 한 변 길이
    // public int dp(int i, int j) {
    //     // memoization이 안된 경우 계산
    //     if(dp[i][j] == -1) {
    //         if(matrix[i][j] == '0') {
    //             dp[i][j] = 0;
    //             // 계속 호출을 안해서.. 임의로; 근데 중복이 많아져서 그냥 for문으로 bottom up 하는게 더 좋을 듯
    //             dp(i+1, j);
    //             dp(i, j+1);
    //         }                
    //         else {
    //             int l = Math.min(Math.min(dp(i+1, j), dp(i, j+1)), dp(i+1, j+1)) +1;
    //             dp[i][j] = l;
    //         }
    //     }

    //     return dp[i][j];
    // }
}
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        int l = original.length;
        if(l != m*n)
            return new int[0][0];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                int idx = i * n + j;
                ans[i][j] = original[idx];
            }
        }
        return ans;
    }
}
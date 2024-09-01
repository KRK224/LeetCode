class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        int l = original.length;
        if(l != m*n)
            return new int[0][0];
        
        for(int i = 0; i < m; i++) {
            // Arrays.copyOfRange 는 idx로 범위를 설정하는데, 마지막 idx는 포함하지 않음.
            ans[i] = Arrays.copyOfRange(original, i*n, i*n+n);
            // System.arraycopy(original, i*n, ans[i], 0, n);
            // for (int j = 0; j< n; j++) {
            //     int idx = i * n + j;
            //     ans[i][j] = original[idx];
            // }
        }
        return ans;
    }
}
class Solution {
    public int s1, s2;
    public int[][] memo;
    public String text1, text2;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        s1 = text1.length();
        s2 = text2.length();
        memo = new int[s1][s2];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // top-down
        return dp(s1-1,s2-1);
        
    }

    public int dp(int i, int j) {
        // base case
        if(i <0 || j < 0)
            return 0;

        if(memo[i][j] == -1) {
            // 둘 다 안같아서 하나만 줄인 경우
            int max = Math.max(dp(i-1, j), dp(i, j-1));
            if(text1.charAt(i) == text2.charAt(j)) {
                max = Math.max(dp(i-1, j-1) +1, max);
            }
            memo[i][j] = max;
        }
        return memo[i][j];
    }
}
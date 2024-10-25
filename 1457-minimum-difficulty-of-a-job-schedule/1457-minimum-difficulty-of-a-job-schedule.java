class Solution {
    public int[][] dp;
    public int[] difs;
    public int d, l;
    public int minDifficulty(int[] jobDifficulty, int d) {
        difs = jobDifficulty;
        this.d = d;
        this.l = difs.length;
        if(this.l <this.d)
            return -1;
        dp = new int[l][d+1];
        
        // 초기화
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        return dp(0, 1);
        
    }
    
    int dp(int idx, int curD) {
        // base case
        if(curD > d)
            return 0;
        
        if(dp[idx][curD] == Integer.MAX_VALUE) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
        
            // 마지막 날만 남으면 한번에 처리
            if(curD == d) {
                for(int i = idx; i<l; ++i) {
                    max = Math.max(max, difs[i]);
                }
                return max;
            }         
        
            for(int i = idx; i< l-d+curD; ++i) {
                // i가 가능한 범위는 지금 idx부터 남은 날짜 당 하나씩을 남겨둔 범위까지
                // 현재 i까지 계산했다고 판단했을 때의 max값
                max = Math.max(max, difs[i]);
                min = Math.min(min, max + dp(i+1, curD+1));
            }
            dp[idx][curD] = min;
        }
        
        return dp[idx][curD];
    }
}
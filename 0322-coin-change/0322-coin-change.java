class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        
        // 초기화
        for(int i = 1; i<dp.length; ++i)
            dp[i] = -1;

        // w에서 사용할 수 있는 최소값을 저장.
        for(int w = 1; w<=amount; w++) {
            for(int i =0; i< coins.length; ++i) {
                // coins[i] < amount 이면 만들 수 있으므로 고려
                if(coins[i] <= w) {
                    if(dp[w-coins[i]]!=-1) {
                        dp[w] = dp[w] == -1? dp[w-coins[i]] +1 : Math.min(dp[w], dp[w-coins[i]] +1);
                    }
                
                }
            }
        }
        // System.out.println(dp[amount]);
        return dp[amount];
        
    }
}
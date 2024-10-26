class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i =0; i<nums.length; i++) {
            int max = dp[i];
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]){
                    max = Math.max(dp[j] +1, max);
                } 
            }
            dp[i] = max;
        }
        int ans = 0;
        for(int i =0; i< nums.length; ++i) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        
    }
}
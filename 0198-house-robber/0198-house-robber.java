class Solution {
    public static Map<Integer, Integer> dp;
    public static int[] moneys;
    
    public int rob(int[] nums) {
        dp = new HashMap<>();
        moneys = nums;
        return dp(nums.length-1);                
    }

    public int dp(int idx) {
        // base case
        if(idx == 0) {
            dp.put(idx, moneys[idx]);
            return moneys[idx];
        }

        if(idx == 1) {
            dp.put(idx, Math.max(moneys[0], moneys[1]));
            return dp.get(idx);
        }

        // 이미 존재
        if(dp.containsKey(idx)){
            return dp.get(idx);
        }
            
        
        // 최대값을 찾아야하니까 우선 최소값으로 초기화
        int max = Math.max(dp(idx-1), dp(idx-2) + moneys[idx]);
        dp.put(idx, max);
        return max;
    }
}
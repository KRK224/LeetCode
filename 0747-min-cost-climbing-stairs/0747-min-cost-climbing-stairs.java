class Solution {
    public Map<Integer, Integer> dp = new HashMap<>();
    public int[] cost;
    {
        dp.put(0, 0);
        dp.put(1, 0);
    }
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return dp(cost.length);
    }

    public int dp(int n) {
        // base case
        if(n == 0 || n==1)
            return dp.get(n);
        
        if(dp.containsKey(n))
            return dp.get(n);
        
        int min = Math.min(dp(n-1) + cost[n-1], dp(n-2) + cost[n-2]);
        dp.put(n, min);
        return min;
    }
}
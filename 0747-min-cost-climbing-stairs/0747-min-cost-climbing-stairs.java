class Solution {
    public Map<Integer, Integer> dp;
    public int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 0);
        this.cost = cost;
        // top-down
        // return dp(cost.length);
        // bottom-up
        int[] arr = new int[cost.length+1];
        arr[0] = arr[1] = 0;
        for(int i = 2; i<=cost.length; ++i) {
            arr[i] = Math.min(arr[i-1] + cost[i-1], arr[i-2] + cost[i-2]);
        }
        return arr[cost.length];        

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
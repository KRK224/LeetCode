class Solution {
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        // cache 용 최대값 조회.
        int max = 0;
        for(int i : nums) {
            max = Math.max(max, i);
           int cnt = points.getOrDefault(i, 0) +1;
           points.put(i, cnt);
        }
        System.out.println(max);

        for(Integer k : points.keySet()) {
            // 얻을 수 있는 값으로 치환.
            int value = points.get(k);
            
            points.put(k, value * k);
        }

        return dp(max);

        
    }

    int dp(int n) {
        // base case
        if (n ==0)
            return 0;

        if(n ==1) {
            cache.put(1, points.getOrDefault(1,0));
            return points.getOrDefault(1, 0);
        }

        if(cache.containsKey(n))
            return cache.get(n);

        int gain = points.getOrDefault(n, 0);
        int max = Math.max(dp(n-2) + gain, dp(n-1));
        cache.put(n, max);
        return max;
        
    }
}
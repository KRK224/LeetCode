class Solution {
    public Map<Integer, Integer> dp;
    public int[] arr;
    
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> cntMp = new HashMap<>();
        List<Integer> ks = new ArrayList<>();
        // 각 cnt 및 key list 저장.
        
        for(int i: nums) {
            // 이미 존재.
            if(cntMp.containsKey(i)) {
                int v = cntMp.get(i) +1;
                cntMp.put(i, v);
            } else {
                cntMp.put(i, 1);
                // 순서대로 저장.
                ks.add(i);
            }
        }
        arr = ks.stream().mapToInt(Integer::intValue).toArray();
        dp = new HashMap<>(ks.size());
        return dp(arr.length-1, cntMp);
    }
    
    public int dp(int n, Map<Integer, Integer> cntMap) {
        // base case
        if(n==0) {
            return arr[0] * cntMap.get(arr[0]);
        }
        if(n==1) {
            if(arr[0] +1 == arr[1])
                return Math.max(arr[0] * cntMap.get(arr[0]), arr[1] * cntMap.get(arr[1]));
            else
                return arr[0] * cntMap.get(arr[0]) + arr[1] * cntMap.get(arr[1]);
        }
        
        if(dp.containsKey(n))
            return dp.get(n);
        
        int max = Integer.MIN_VALUE;
        
        if(arr[n-1] +1 == arr[n]) {
            // System.out.println("n val: " + arr[n] + ", n-1 val: " + arr[n-1]);
            // System.out.println("cntMap.get(arr[n]): " + cntMap.get(arr[n]));
            max = Math.max(dp(n-1, cntMap), dp(n-2, cntMap) + arr[n] * cntMap.get(arr[n]));
            dp.put(n, max);
            return max;
        } else { // 연속되지 않으니까 눌러도 됨.
            max = dp(n-1, cntMap) + arr[n] * cntMap.get(arr[n]);
            dp.put(n, max);
            return max;
        }            
            
    }
}
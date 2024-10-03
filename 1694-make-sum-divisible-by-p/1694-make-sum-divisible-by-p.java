class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] sums = new int[nums.length];
        int min = nums.length;
        int target = 0;
        
        for(int i =0; i< nums.length; ++i) {
            target = (target + nums[i]) %p;
            // prefix modulo save
            sums[i] = target;
        }

        if(target == 0)
            return 0;
        
        for(int i =0; i< sums.length; ++i) {
            int startMod = (sums[i] - target + p ) %p;
            Integer startIdx = map.get(startMod);
            if(startIdx != null) {
                min = Math.min(min, i - startIdx);
            }
            map.put(sums[i], i);
        }

        return min == nums.length ? -1 : min;
    }
}
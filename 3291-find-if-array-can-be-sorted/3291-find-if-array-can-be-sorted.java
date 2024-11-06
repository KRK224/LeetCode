class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    public boolean canSortArray(int[] nums) {
        
        for(int i = 0; i< nums.length; i++) {
            int cnt = countOne(nums[i]);
            mp.put(nums[i], cnt);
        }

        for(int i =0; i< nums.length; i++) {
            for(int j=0; j< nums.length-i-1; j++) {
                // 교환
                if(nums[j] > nums[j+1]) {
                    if(!mp.get(nums[j]).equals(mp.get(nums[j+1]))) {
                        return false;
                    }
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return true;
    }

    public int countOne(int num) {
        int cnt = 0;
        while(num!=0) {
            num = num & num-1;
            cnt++;
        }
        return cnt;
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force
        // int[] answer = new int[] {
        // -1, -1
        // };

        // for (int i =0; i< nums.length; i++) {
        // for(int j =i+1; j<nums.length; j++) {
        // if(nums[i] + nums[j] == target) {
        // answer[0] = i;
        // answer[1] = j;
        // break;
        // }
        // }

        // if(answer[1] != -1) {
        // break;
        // }
        // }
        // return answer;
        // }

        // one-pass hash table
        int[] answer = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if(hm.containsKey(target-nums[i])) {
                answer[0] = i;
                answer[1] = hm.get(target-nums[i]);
                break;
            }
            hm.put(nums[i], i);
        }

        return answer;

    }
}
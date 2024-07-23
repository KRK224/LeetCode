class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> result = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int i =0; i<nums.length;i++) {
            Integer currentCnt = cntMap.getOrDefault(nums[i], 0);
            cntMap.put(nums[i], ++currentCnt);
        }
        Collections.sort(result, (a, b) -> {
            if(cntMap.get(a).equals(cntMap.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(cntMap.get(a), cntMap.get(b));
        });

        return result.stream().mapToInt(i->i).toArray();
        
    }
}
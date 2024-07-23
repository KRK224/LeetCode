class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int i =0; i<nums.length;i++) {
            Integer currentCnt = cntMap.getOrDefault(nums[i], 0);
            cntMap.put(nums[i], ++currentCnt);
        }
        for(Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            List<Integer> valueList = resultMap.get(entry.getValue());
            if(valueList == null) {
                valueList = new ArrayList<>();
                valueList.add(entry.getKey());
                resultMap.put(entry.getValue(), valueList);
            } else {
                valueList.add(entry.getKey());
            }
        }
        List<Integer> keyList = new ArrayList<>(resultMap.keySet());
        Collections.sort(keyList);
        for(Integer sortedKey : keyList) {
            List<Integer> values = resultMap.get(sortedKey);
            Collections.sort(values, (i1, i2) -> i2-i1);
            for(Integer value : values) {
                for(int i =0; i< sortedKey; i++) {
                    result.add(value);
                }
            }
            
        }
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}
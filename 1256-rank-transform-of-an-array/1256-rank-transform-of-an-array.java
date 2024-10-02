class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        int rank = 1;
        for(int i = 0; i< tmp.length; ++i) {
            if(!idxMap.containsKey(tmp[i])) {
                idxMap.put(tmp[i], rank++);
            }
            
        }
        for(int i = 0; i< arr.length; i++) {
            arr[i] = idxMap.get(arr[i]);
        }
        return arr;
    }
}
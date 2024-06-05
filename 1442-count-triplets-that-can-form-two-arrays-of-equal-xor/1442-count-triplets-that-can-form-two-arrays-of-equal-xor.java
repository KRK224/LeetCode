import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] arr) {
        int[] prefixArr = new int[arr.length + 1];
        prefixArr[0] = 0;
        System.arraycopy(arr, 0, prefixArr, 1, arr.length);

        // calculate prefixArr
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] ^= prefixArr[i - 1];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> sumIdxMap = new HashMap<>();
        int ret = 0;

        for (int i = 0; i < prefixArr.length; i++) {
            int prevCnt = countMap.getOrDefault(prefixArr[i], 0);
            int prevSumIdx = sumIdxMap.getOrDefault(prefixArr[i], 0);
            ret += prevCnt * (i - 1) - prevSumIdx;
            countMap.put(prefixArr[i], ++prevCnt);
            sumIdxMap.put(prefixArr[i], prevSumIdx + i);
        }
        return ret;

    }
}
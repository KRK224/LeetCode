import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        List<Integer> initValue = new ArrayList<>();
        initValue.add(0);
        cache.put(arr[0], initValue);
        int ans = 0;
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor = xor ^ arr[i];
            if (xor == 0) {
                ans += i;
            }
            
            List<Integer> values = cache.getOrDefault(xor, new ArrayList<>());
            for(Integer value : values) {
                if(i > value +1) {
                    ans += i - value -1;
                }
            }
            values.add(i);
            cache.put(xor, values);
        }
        return ans;
    }
}
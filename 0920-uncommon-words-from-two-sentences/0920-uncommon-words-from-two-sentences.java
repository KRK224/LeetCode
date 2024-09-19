class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a1 = s1.split(" ");        
        String[] a2 = s2.split(" ");
        List<String> ans = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        
        for(String v1: a1) {
            int c = mp.getOrDefault(v1,0);
            mp.put(v1, ++c);
        }

        for(String v2 : a2) {
            int c = mp.getOrDefault(v2, 0);
            mp.put(v2, ++c);
        }

        for(String key: mp.keySet()) {
            if(mp.get(key) == 1) {
                ans.add(key);
            }
        }

        return ans.toArray(new String[0]);

    }
}
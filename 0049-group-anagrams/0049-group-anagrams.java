class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            String key = new String(chars);
            
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(s);
            map.put(key, values);
        }

        return new ArrayList<>(map.values());
        
    }
}
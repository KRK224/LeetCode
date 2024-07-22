class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int l = names.length;
        Map<Integer, String> map = new HashMap<>();
        
        for(int i =0; i < l; i++){
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] sortedNames = new String[l];
                
        for(int i =0; i<l; i++) {
            sortedNames[l-i-1] = map.get(heights[i]);
        }
        return sortedNames;

        
    }
}
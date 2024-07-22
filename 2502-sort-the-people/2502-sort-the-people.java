class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int l = names.length;
        Map<Integer, String> map = new HashMap<>();
        
        for(int i =0; i < l; i++){
            map.put(heights[i], names[i]);
        }

        List<Integer> hList = new ArrayList<>(Arrays.stream(heights).boxed().toList());
        Collections.sort(hList, (h1, h2) -> h2 - h1);
        List<String> nameList = new ArrayList<>();
        
        for(Integer h: hList) {
            nameList.add(map.get(h));
        }
        return nameList.toArray(new String[0]);

        
    }
}
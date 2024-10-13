class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String answer = "";
        Set<String> bans = new HashSet<>();
        for(String ban : banned) {
            bans.add(ban);
        }
        String r = paragraph.replaceAll("[^A-Za-z ]", " ").toLowerCase();
        String[] words = r.split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for(String w : words) {
            Integer cnt = map.getOrDefault(w, 0);
            if(!bans.contains(w))
                map.put(w, ++cnt);
        }
    

        int maxCnt =0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxCnt) {
                answer = entry.getKey();
                maxCnt = entry.getValue();
            }
                

        }
        return answer;

    }
}
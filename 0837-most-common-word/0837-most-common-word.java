class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String answer = "";
        String r = paragraph.replaceAll("[^A-Za-z ]", " ").toLowerCase();
        System.out.println(r);
        String[] words = r.split("\\s+");
        System.out.println(words.length);
        Map<String, Integer> map = new HashMap<>();

        for(String w : words) {
            Integer cnt = map.getOrDefault(w, 0);
            map.put(w, ++cnt);
        }
        
        for(String b : banned) {
            map.remove(b);
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
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        HashSet<Character> a_set = new HashSet();
        for(char allow : allowed.toCharArray()) {
            a_set.add(allow); 
        }
        
        for(String s: words) {
            boolean isCnt = true;
            for(char c: s.toCharArray()){
                if(!a_set.contains(c)) {
                    isCnt = false;
                    break;
                }
            }
            if(isCnt)
                cnt++;
        }        
        return cnt;
    }
}
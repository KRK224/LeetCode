class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for(int i =0; i < magazine.length(); i++) {
            int cnt = dictionary.getOrDefault(magazine.charAt(i), 0);
            dictionary.put(magazine.charAt(i), ++cnt);
        }
        for(int j = 0; j< ransomNote.length(); j++) {
            Integer cnt = dictionary.get(ransomNote.charAt(j));
            if(cnt == null || cnt == 0)
                return false;
            dictionary.put(ransomNote.charAt(j), --cnt);
        }
        return true;
    }
}
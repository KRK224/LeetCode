class Solution {
    // alphabet array for vowels
    // 'a', 'e', 'i', 'o', 'u' is 1, 2, 4, 8, 16;
    // consonants are 0;
    final int[] cm;
    {
        cm = new int[26];
        cm['a'-'a'] = 1;
        cm['i'-'a'] = 2;
        cm['e'-'a'] = 4;
        cm['o'-'a'] = 8;
        cm['u'-'a'] = 16;
    }
    public int findTheLongestSubstring(String s) {
        int prefixXor = 0;
        int answer = 0;
        // init xor initVal;
        int[] mp= new int[32];
        Arrays.fill(mp, -1);
        char[] charArr = s.toCharArray();

        for(int i =0; i< charArr.length; i++) {
            prefixXor ^= cm[charArr[i] - 'a'];
            if(prefixXor == 0) {
                answer = answer > i ? answer : i+1;
            } else if(mp[prefixXor] !=-1) {
                answer = answer > i-mp[prefixXor] ? answer: i - mp[prefixXor];
            } else {
                mp[prefixXor] = i;
            }
        }
        return answer;        
    }
}
class Solution {
    public void reverseString(char[] s) {
        int l = s.length;
        for(int i =0; i<l-1; i++) {
            if(i > l-1-i)
                break;
            char tmp = s[i];
            s[i] = s[l-1-i];
            s[l-1-i] = tmp;
        }
    }
}
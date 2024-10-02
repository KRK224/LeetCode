class Solution {
    public boolean isPalindrome(String s) {
        int f = 0, e = s.length()-1;
        while (f < e) {
            while(!Character.isLetterOrDigit(s.charAt(f))) {
                f++;
                if(f>=s.length())
                    return true;
            }

            while(!Character.isLetterOrDigit(s.charAt(e))){
                e--;
                if(e<0)
                    return true;
            }

            if(Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(e)))
                return false;
            f++;
            e--;
        }
        return true;
    }
}
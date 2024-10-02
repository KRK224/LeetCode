class Solution {
    public boolean isPalindrome(String s) {
        int f = 0, e = s.length()-1;
        while (f <= e) {
            while(!(Character.isAlphabetic(s.charAt(f)) || Character.isDigit(s.charAt(f)))) {
                f++;
                if(f>=s.length())
                    return true;
            }

            while(!(Character.isAlphabetic(s.charAt(e)) || Character.isDigit(s.charAt(e)))){
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
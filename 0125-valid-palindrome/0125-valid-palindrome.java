class Solution {
    public boolean isPalindrome(String s) {
        // replaceAll doesn't change origin!!!
        String letter = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // \\w : 알파벳 + 숫자 + _ 까지 포함
        // String letter = s.replaceAll("\\W", "").toLowerCase();
        String reverse = new StringBuilder(letter).reverse().toString().toLowerCase();
        if(letter.equals(reverse))
            return true;
        return false;

        // pointer 풀이
        // int f = 0, e = s.length()-1;
        // while (f < e) {
        //     while(!Character.isLetterOrDigit(s.charAt(f))) {
        //         f++;
        //         if(f>=s.length())
        //             return true;
        //     }

        //     while(!Character.isLetterOrDigit(s.charAt(e))){
        //         e--;
        //         if(e<0)
        //             return true;
        //     }

        //     if(Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(e)))
        //         return false;
        //     f++;
        //     e--;
        // }
        // return true;
    }
}
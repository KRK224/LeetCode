// class Solution {

//     public String shortestPalindrome(String s) {
//         int length = s.length();
//         String reversedString = new StringBuilder(s).reverse().toString();

//         // Iterate through the string to find the longest palindromic prefix
//         for (int i = 0; i < length; i++) {
//             if (
//                 s.substring(0, length - i).equals(reversedString.substring(i))
//             ) {
//                 return new StringBuilder(reversedString.substring(0, i))
//                     .append(s)
//                     .toString();
//             }
//         }
//         return "";
//     }
// }

class Solution {

    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        // Find the longest palindromic prefix
        int left = 0;
        for (int right = length - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        // If the whole string is a palindrome, return the original string
        if (left == length) {
            return s;
        }

        // Extract the suffix that is not part of the palindromic prefix
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(
            nonPalindromeSuffix
        ).reverse();

        // Form the shortest palindrome by prepending the reversed suffix
        return reverseSuffix
            .append(shortestPalindrome(s.substring(0, left)))
            .append(nonPalindromeSuffix)
            .toString();
    }
}
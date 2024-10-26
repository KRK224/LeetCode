class Solution {
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()])) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }

        }
        return dp[s.length() - 1];
    }
}
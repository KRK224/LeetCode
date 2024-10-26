class Solution {
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                for (String word : wordDict) {
                    if (i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()])) {
                        dp[i] = s.substring(i - word.length() + 1, i + 1).equals(word) || dp[i];
                    }
                }
            }

        }
        return dp[s.length() - 1];
    }
}
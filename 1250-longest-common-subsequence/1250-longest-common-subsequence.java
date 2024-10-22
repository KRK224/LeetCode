class Solution {
    // solution 시간 비교 => 똑같네ㅎㅎ
    // bottom-up 구현이 시간 단축을 하는데.. 그게 좀 어렵네
  private int[][] memo;
  private String text1;
  private String text2;
    
  public int longestCommonSubsequence(String text1, String text2) {
    // Make the memo big enough to hold the cases where the pointers
    // go over the edges of the strings.
    this.memo = new int[text1.length() + 1][text2.length() + 1];
    // We need to initialise the memo array to -1's so that we know
    // whether or not a value has been filled in. Keep the base cases
    // as 0's to simplify the later code a bit.
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        this.memo[i][j] = -1;
      }
    }
    this.text1 = text1;
    this.text2 = text2;
    return memoSolve(0, 0);
  }

  private int memoSolve(int p1, int p2) {        
    // Check whether or not we've already solved this subproblem.
    // This also covers the base cases where p1 == text1.length
    // or p2 == text2.length.
    if (memo[p1][p2] != -1) {
      return memo[p1][p2];
    }

    // Recursive cases.
    int answer = 0;
    if (text1.charAt(p1) == text2.charAt(p2)) {
      answer = 1 + memoSolve(p1 + 1, p2 + 1);
    } else {
      answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
    }
    
    // Add the best answer to the memo before returning it.
    memo[p1][p2] = answer;
    return memo[p1][p2];
  }

    // public int s1, s2;
    // public int[][] memo;
    // public String text1, text2;

    // public int longestCommonSubsequence(String text1, String text2) {
    //     this.text1 = text1;
    //     this.text2 = text2;
    //     s1 = text1.length();
    //     s2 = text2.length();
    //     memo = new int[s1][s2];

    //     for(int[] row : memo) {
    //         Arrays.fill(row, -1);
    //     }

    //     // top-down
    //     return dp(s1-1,s2-1);
        
    // }

    // public int dp(int i, int j) {
    //     // base case
    //     if(i <0 || j < 0)
    //         return 0;

    //     if(memo[i][j] == -1) {
    //         // 둘 다 안같아서 하나만 줄인 경우
    //         int max = Math.max(dp(i-1, j), dp(i, j-1));
    //         if(text1.charAt(i) == text2.charAt(j)) {
    //             max = Math.max(dp(i-1, j-1) +1, max);
    //         }
    //         memo[i][j] = max;
    //     }
    //     return memo[i][j];
    // }
}
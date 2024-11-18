class Solution {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] extCode = new int[length+length];
        System.arraycopy(code, 0, extCode, 0, length);
        System.arraycopy(code, 0, extCode, length, length);
        int[] dp = new int[length+ length];
        int[] answer = new int[length];

        if(k > 0) {               
            for(int i = 0; i< length; i++) {
                if(i == 0) {
                    for(int j = i+1; j<i+k+1; j++) {
                        dp[i] += extCode[j];
                    }
                } else {
                    dp[i] = dp[i-1] - extCode[i] + extCode[i+k];
                }
            }
            answer = Arrays.copyOf(dp, length);
        } else if (k <0) {
            for(int i = length; i<length+length; i++) {
                if(i == length) {
                    for(int j = i-1; j>i-1+k; j--) {
                        dp[i] += extCode[j];
                    }
                    // System.out.printf("init dp[%d]: %d%n" , i, dp[i]);
                } else {
                    // System.out.printf("i: %d, dp[%d]: %d, extCode[%d]: %d, extCode[%d]: %d%n", i, i-1,
                    // dp[i-1], i-1, extCode[i-1], i+k-1, extCode[i + k -1]);
                    // System.out.println(Arrays.toString(dp));
                    dp[i] = dp[i-1] + extCode[i-1] - extCode[i + k -1];
                }
            }
            answer = Arrays.copyOfRange(dp, length, length+length);
        } 

        return answer;
        
    }
}
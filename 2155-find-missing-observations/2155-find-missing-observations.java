class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int[] answer = new int[n];
        int mSum = 0;
        int nSum = 0;
        for (int roll : rolls) {
            mSum += roll;
        }
        nSum = mean * (m + n) - mSum;
        if (nSum > n * 6 || nSum < n)
            return new int[0];

        int nAvg = nSum / n;
        int remain = nSum % n;

        for (int i = 0; i < n; i++) {
            if (i < remain)
                answer[i] = nAvg + 1;
            else
                answer[i] = nAvg;
        }

        return answer;
    }
}
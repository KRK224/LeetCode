class Solution {
    public int minBitFlips(int start, int goal) {
        int result = 0;
        while(!(start==0 && goal ==0)) {
            if(start%2 != goal%2) {
                result++;
            }
            start/=2;
            goal/=2;
        }
        return result;
    }
}
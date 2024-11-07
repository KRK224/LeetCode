class Solution {
    public int[] cnt = new int[24];
    public int largestCombination(int[] candidates) {
        for(int i = 0; i<=24; ++i) {
            for(int num: candidates) {
                if((num & (1 <<i)) !=0)
                    cnt[i] +=1;
            }
        }

        int max = 0;
        for(int c: cnt) {
            if(c > max)
                max = c;
        }
        return max;
        
    }
}
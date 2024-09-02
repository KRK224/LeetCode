class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int cVal = k;
        int idx;
        for(int i = 0; i<n; i++) {
            cVal -= chalk[i];
            if(cVal < 0)
                return i;
        }
        int total = k - cVal;
        int remain = cVal % total;
        for(idx =0; idx<n; idx++) {
            remain -=chalk[idx];
            if(remain <0)
                break;
        } 
        return idx;
    }
}
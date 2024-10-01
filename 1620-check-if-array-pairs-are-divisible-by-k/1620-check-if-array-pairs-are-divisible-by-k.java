class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainders = new int[k];

        for(int x : arr) {
            int remainder = ((x%k) +k) %k;
            remainders[remainder] +=1;
        }

        if(remainders[0] %2 != 0)
            return false;
        for(int i = 1; i< k/2 +1; ++i) {
            if(remainders[i] != remainders[k-i])
                return false;
        }

        return true;
        
    }
}
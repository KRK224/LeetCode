class Solution {
    public int[] cache = new int[46];
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        if(cache[n] != 0)
            return cache[n];
        else {
            cache[n] = climbStairs(n-2) + climbStairs(n-1);
            return cache[n];
        }
    }
}
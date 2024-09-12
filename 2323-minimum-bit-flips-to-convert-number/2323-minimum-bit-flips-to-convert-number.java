class Solution {
    // public int minBitFlips(int start, int goal) {
    // int result = 0;
    // while(!(start==0 && goal ==0)) {
    // if(start%2 != goal%2) {
    // result++;
    // }
    // start/=2;
    // goal/=2;
    // }
    // return result;
    // }

    // Recursive Solution
    // public int minBitFlips(int start, int goal) {
    // // Base case: both numbers have been fully processed
    // if (start == 0 && goal == 0) return 0;

    // // Flip for the current least significant bit
    // int flip = (start & 1) != (goal & 1) ? 1 : 0;

    // // Recurse for the next bits by right-shifting both numbers
    // return flip + minBitFlips(start >> 1, goal >> 1);
    // }

    // XOR Solution
    // public int minBitFlips(int start, int goal) {
    // // XOR to find differing bits
    // int xorResult = start ^ goal;
    // int count = 0;
    // // Count the number of 1s in xorResult (differing bits)
    // while (xorResult != 0) {
    // count += xorResult & 1; // Increment if the last bit is 1
    // xorResult >>= 1; // Shift right to process the next bit
    // }
    // return count;
    // }

    // *** Brian Kernighan’s Algorithm
    public int minBitFlips(int start, int goal) {
        // XOR to find differing bits
        int xorResult = start ^ goal;
        int count = 0;
        // Count the number of 1s in xorResult (differing bits)
        while (xorResult != 0) {            
            xorResult &= xorResult-1;
            count++;
        }
        return count;
    }
}
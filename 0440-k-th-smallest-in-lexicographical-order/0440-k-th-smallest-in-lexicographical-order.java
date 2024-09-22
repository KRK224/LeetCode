// class Solution {
//     public int cur =0, result = 0;
//     public int findKthNumber(int n, int k) {
//         int idx = 0;
//         int tmp = n;
//         while(tmp / 10 > 0) {
//             idx++;
//             tmp /=10;
//         }
//         System.out.println(idx + ", " + tmp);
        
//         int branchSize = 0;
        
//         for(int p = 0; p<= idx; ++p) {
//             branchSize += Math.pow(10, p);
//         }

//         System.out.println(branchSize);

//         for(int i = 1; i <10; ++i) {
//             if(i * branchSize < k) {
//                 cur += branchSize;
//                 continue;
//             }
//             System.out.println(cur);
//             getLexicalNumbers(i, n, k);
//             if(cur >=k)
//                 break;
//         }

//         return result;
//     }

//     public void getLexicalNumbers(int start, int n, int k) {
//         if(start > n || cur >= k)
//             return;

//         if(++cur == k) {
//             result = start;
//             return;
//         }
        
//         for(int i =0; i< 10; ++i) {
//             int tmp = start * 10 + i;
//             if(tmp > n)
//                 return;
//             getLexicalNumbers(tmp, n, k);
//         }
//     }
// }

class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++;
                k -= step;
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
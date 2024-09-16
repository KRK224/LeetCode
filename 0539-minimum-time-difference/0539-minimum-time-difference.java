class Solution {
    public int findMinDifference(List<String> timePoints) {
        /** using bucket sort
        * 1. init boolean bucket array as its possible value [0, 24*60-1]
        * 2. timePoints to Minutes and inspect wheter is occured before.
        * 3. if it is occured, answer is 0. or keep going.
        * 4. init prevIdx, startIdx, endIdx;
         */

         boolean[] b = new boolean[24*60];
         int answer = 24*60;
         int prevIdx = -1, startIdx = -1, endIdx = -1; 

         for(String t: timePoints) {
            if(b[calcMin(t)]){
                return 0;
            } else {
                b[calcMin(t)] = true;
            }
         }
         
         for(int i =0; i< b.length; i++) {
            if(b[i]) {
                if(prevIdx !=-1) {
                    answer = Math.min(answer, i - prevIdx);
                } else {
                    startIdx = i;
                }

                endIdx = prevIdx = i;
            }
         }

         answer = Math.min(answer, 24*60 - endIdx +startIdx);
         return answer;
        
        /** 1st attempt
        * 1. timePoints to MinArray and sort
        * 2. calc difference between adjacent elements for answer
        * 3. calc last element to first element with 24*60 - value;
         */
        // int answer = 24*60;
        // int s = timePoints.size();
        // int[] minArr = new int[s];

        // for(int i =0; i< s; i++) {
        //     minArr[i] = calcMin(timePoints.get(i));
        // }

        // Arrays.sort(minArr);

        // for(int i = 1; i < s; i++) {
        //     answer = Math.min(answer, minArr[i] - minArr[i-1]);
        // }
        
        // answer = Math.min(answer, 24*60 - minArr[s-1] + minArr[0]);
        
        // return answer;
    }

    public int calcMin(String time) {
        char[] hh_mm = time.toCharArray();
        int hh = Character.getNumericValue(hh_mm[0]) * 10 + Character.getNumericValue(hh_mm[1]);
        int mm = Character.getNumericValue(hh_mm[3]) * 10 + Character.getNumericValue(hh_mm[4]);
        return hh * 60 + mm;
    }
}
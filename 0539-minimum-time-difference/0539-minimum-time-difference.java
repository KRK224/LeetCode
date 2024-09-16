class Solution {
    public int findMinDifference(List<String> timePoints) {
        int answer = 24*60;
        int s = timePoints.size();
        int[] minArr = new int[s];

        for(int i =0; i< s; i++) {
            minArr[i] = calcMin(timePoints.get(i));
        }

        Arrays.sort(minArr);

        for(int i = 1; i < s; i++) {
            answer = answer > minArr[i] - minArr[i-1] ? minArr[i] - minArr[i-1] : answer;
        }
        int temp =24 * 60 - minArr[s -1] + minArr[0];
        if(answer > temp) {
            return temp;
        } else {
            return answer;
        }

        
    }

    public int calcMin(String time) {
        char[] hh_mm = time.toCharArray();
        int hh = Character.getNumericValue(hh_mm[0]) * 10 + Character.getNumericValue(hh_mm[1]);
        int mm = Character.getNumericValue(hh_mm[3]) *10 + Character.getNumericValue(hh_mm[4]);
        return hh * 60 + mm;
    }
}
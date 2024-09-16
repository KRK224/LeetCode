class Solution {
    public int findMinDifference(List<String> timePoints) {
        int answer = 24*60;
        int s = timePoints.size();
        int[] minArr = new int[s];

        for(int i =0; i< s; i++) {
            minArr[i] = Integer.parseInt(timePoints.get(i).substring(0,2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }

        Arrays.sort(minArr);

        for(int i = 1; i < s; i++) {
            answer = Math.min(answer, minArr[i] - minArr[i-1]);
        }
        
        answer = Math.min(answer, 24*60 - minArr[s-1] + minArr[0]);
        
        return answer;
    }
}
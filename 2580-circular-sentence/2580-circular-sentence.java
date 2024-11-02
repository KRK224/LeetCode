class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sArr = sentence.split(" ");
        boolean answer = true;
        for(int i = 0; i< sArr.length-1; i++) {
            if(sArr[i].charAt(sArr[i].length()-1) != sArr[i+1].charAt(0)) {
                answer = false;
                break;
            }
        }
        if(answer) {
            if(sArr[sArr.length-1].charAt(sArr[sArr.length-1].length()-1) != sArr[0].charAt(0))
                answer = false;
        }

        return answer;
    }   
}
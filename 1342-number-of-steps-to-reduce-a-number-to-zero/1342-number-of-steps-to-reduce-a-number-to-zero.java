class Solution {
    public int numberOfSteps(int num) {
        String binary = Integer.toBinaryString(num);
        int answer = 0;
        for (int i = binary.length()-1; i>0; i--) {
            if(binary.charAt(i) == '1') {
                answer +=2;
            } else {
                answer++;
            }
        }
        return binary.charAt(0) == '0' ?answer : ++answer;
    }
}
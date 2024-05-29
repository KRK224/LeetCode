class Solution {
    public int numSteps(String s) {
        int ans = 0;
        int carry = 0;
        for(int i = s.length()-1; i>0; i--) {
            int c = s.charAt(i);
            if(c == '0') {
                if(carry == 0) {
                    ans++;
                } else {
                    ans +=2;
                    carry = 1;
                }
            } else {
                if(carry == 0) {
                    ans +=2;    
                } else {
                    ans++;
                }
                carry =1;
            }
        }
        return ans + carry;        
    }
}
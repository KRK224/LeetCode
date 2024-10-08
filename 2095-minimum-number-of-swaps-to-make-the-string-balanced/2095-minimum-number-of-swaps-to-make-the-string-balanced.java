class Solution {
    public int minSwaps(String s) {
        if(s.length() == 0)
            return 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        int unbal = 0;
        for(char c: s.toCharArray()) {
            if(c == '[')
                stack.push(c);
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    unbal++;
            }
        }
        return (unbal +1) / 2;
    }
}
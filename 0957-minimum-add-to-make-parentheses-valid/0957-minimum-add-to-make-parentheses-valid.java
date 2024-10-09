class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0; i< s.length(); ++i) {
            if(!stack.isEmpty()) {
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                    continue;
                }
            } 
                stack.push(s.charAt(i));
        }
        return stack.size();
        
    }
}
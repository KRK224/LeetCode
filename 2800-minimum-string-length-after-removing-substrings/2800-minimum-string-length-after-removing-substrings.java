class Solution {
    
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // Iterate over each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the stack is empty, simply push the current character
            if (stack.isEmpty()) {
                stack.push(currentChar);
                continue;
            }

            // Check for "AB" pattern, remove the pair by popping from the stack
            if (currentChar == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            // Check for "CD" pattern, remove the pair by popping from the stack
            else if (currentChar == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            // Otherwise, push the current character onto the stack
            else {
                stack.push(currentChar);
            }
        }

        return stack.size();
    }
    
    // public int minLength(String s) {
    //     String ans = s;
    //     do {
    //         s = remove(s);
    //     } while(!s.equals(remove(s)));
    //     return s.length();    
    // }

    public String remove(String s) {
        int size = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i< size; i++) {
            if(i == size-1) {
                sb.append(s.charAt(i));
            } else if((s.charAt(i) == 'A' && s.charAt(i+1) == 'B')||(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'))  {
                i+=1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();  
    }
}
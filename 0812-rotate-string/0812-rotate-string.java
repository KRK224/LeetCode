class Solution {
    public boolean rotateString(String s, String goal) {
        boolean ans = false;
        if(goal.equals(s))
            return true;

        String reorder = new String(goal);
        int length = s.length();

        while(length >0) {
            reorder = reorder.substring(1) + reorder.substring(0,1);
            // System.out.println(reorder);
            if(reorder.equals(s))
                return true;
            length--;
        }

        return false;
        
    }
}
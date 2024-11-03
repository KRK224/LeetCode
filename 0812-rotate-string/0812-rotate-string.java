class Solution {
    public boolean rotateString(String s, String goal) {
        boolean ans = false;
        if(s.length() != goal.length())
            return false;
        if(goal.equals(s))
            return true;

        String doubleString = s + s;

        if(doubleString.contains(goal))
            return true;

        return false;
        
    }
}
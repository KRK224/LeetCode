class Solution {
    public int minLength(String s) {
        String ans = s;
        do {
            s = remove(s);
        } while(!s.equals(remove(s)));
        return s.length();    
    }

    public String remove(String s) {
        int size = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i< size; i++) {
            System.out.println("i: " + i);
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
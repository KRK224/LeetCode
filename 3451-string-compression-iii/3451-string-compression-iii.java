class Solution {
    int[] alpha = new int[26];

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        
        int prev = word.charAt(0) - 'a';
        alpha[prev] +=1;

        for (int i = 1; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            alpha[idx] += 1;
            if(prev != idx){
                sb.append(convert(prev));
                alpha[prev] = 0;
                prev = idx;
            }
        }

        sb.append(convert(prev));

        System.out.println(sb.toString());
        return sb.toString();
    }

    public String convert(int i) {
        StringBuilder sb = new StringBuilder();
        int cnt = alpha[i];
        while (cnt >= 9) {
            sb.append(9);
            sb.append((char) ('a' + i));
            cnt -= 9;
        }
        
        if (cnt == 0)
            return sb.toString();
        
        sb.append(cnt);
        sb.append((char) ('a' + i));
        return sb.toString();
    }
}
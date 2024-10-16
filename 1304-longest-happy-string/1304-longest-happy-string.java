class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Info> pq = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);
        
        if(a!=0)
            pq.add(new Info(a, 'a'));
        if(b!=0)
            pq.add(new Info(b, 'b'));
        if(c!=0)
            pq.add(new Info(c, 'c'));

        for(int iter = 0; iter< a+b+c; ++iter) {
            if(pq.isEmpty()) {
                break;
            }
            Info i = pq.poll();
            if(sb.length() >=2 && sb.charAt(sb.length() -1) == i.c && sb.charAt(sb.length()-2) == i.c) {
                if(pq.isEmpty())
                    break;
                Info i2 = pq.poll();
                sb.append(i2.c);
                if(--i2.cnt > 0)
                    pq.add(i2);
            } else {
                sb.append(i.c);
                i.cnt -=1;
            }

            if(i.cnt > 0)
                pq.add(i);
            
        }
        return sb.toString();

    }

    public class Info {
        int cnt;
        char c;        

        Info(int cnt, char c) {
            this.cnt = cnt;
            this.c = c;
        }
    }
}
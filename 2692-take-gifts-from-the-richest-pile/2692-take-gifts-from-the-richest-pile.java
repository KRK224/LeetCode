class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (i2 -i1));
        for(int i : gifts) {
            pq.add(i);
        }

        while(k >0) {
            Integer value = pq.poll();
            int left = (int) Math.floor(Math.sqrt(value));
            // System.out.println(value + ", " + left);
            pq.add(left);
            k--;
        }
        long ans = 0;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for(int i =1; i<10; i++) {
            getLexicalNumbers(i, n, result);
        }
        return result;
        
    }

    public void getLexicalNumbers(int start, int limit, List<Integer> result) {
        // base case
        if(start >limit)
            return;
        
        result.add(start);

        for(int i =0; i<10; i++) {
            int next = start *10 + i;
            if(next <= limit) {
                getLexicalNumbers(next, limit, result);
            } else {
                return;
            }
        }
    }
}
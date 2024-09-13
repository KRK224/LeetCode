class Solution {
    final int max = (int) (3 * Math.pow(10,4));
    int[] c = new int[max];

    public int[] xorQueries(int[] arr, int[][] queries) {
        System.out.println(1^3^4);
        System.out.println(2^6);

        
        int[] result = new int[queries.length];
        // init cache
        Arrays.fill(c, -1);

        for(int i = 0; i< queries.length; i++) {
            int resultR = reculsiveXor(queries[i][1], arr);
            if(queries[i][0] == 0)
                result[i] = resultR;
            else {
                int resultL = reculsiveXor(queries[i][0]-1, arr);                
                result[i] = resultL ^resultR;
            }
            
        }
        return result;
        
    }

    public int reculsiveXor(int r, int[] arr) {
        if(r == 0) 
            return arr[r];                    
        
        if(c[r] != -1)
            return c[r];
        
        c[r] = reculsiveXor(r-1, arr) ^ arr[r];        
        return c[r];
    }
}
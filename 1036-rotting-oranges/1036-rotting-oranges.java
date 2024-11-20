class Solution {
    int[][] grid;
    final int[][] dirs = {
        {-1,0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        Queue<Pair<Integer,Integer>> rotten = new ArrayDeque<>();
        int freshCnt = 0;
        int elapse = -1;
        // init;
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j< grid[i].length; j++) {
                if(grid[i][j] == 1)
                    freshCnt++;
                else if(grid[i][j] == 2)
                    rotten.offer(new Pair(i, j));
            }
        }
        rotten.offer(new Pair(-1, -1));
        while(!rotten.isEmpty()) {
            Pair<Integer, Integer> curr = rotten.poll();
            int row = curr.getKey();
            if(row == -1) {
                ++elapse;
                if(!rotten.isEmpty())
                    rotten.offer(new Pair(-1,-1));
            } else {
                int col = curr.getValue();
                for(int[] dir: dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // 범위 이탈
                    if(newRow <0 || newCol <0 || newRow >= grid.length || newCol >=grid[0].length)
                        continue;
                    // 익었으면 썩혀서 저장.
                    if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCnt--;
                        rotten.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }
        return freshCnt == 0 ? elapse : -1;
    }
}
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;
        int[][] matrix = new int[N][M];

        int[] currRowSum = new int[N];
        int[] currColSum = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Math.min(rowSum[i] - currRowSum[i], colSum[j] - currColSum[j]);
                currRowSum[i] += matrix[i][j];
                currColSum[j] += matrix[i][j];
            }
        }
        return matrix;
    }
}

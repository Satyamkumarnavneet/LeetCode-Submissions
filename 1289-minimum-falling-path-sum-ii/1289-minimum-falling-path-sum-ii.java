class Solution {
   public int minFallingPathSum(int[][] grid) {
       int n = grid.length;

       for (int i = 1; i < n; i++) {
           for (int j = 0; j < n; j++) {
               int minPrev = Integer.MAX_VALUE;
               for (int k = 0; k < n; k++) {
                   if (k != j) {
                       minPrev = Math.min(minPrev, grid[i - 1][k]);
                   }
               }
               grid[i][j] += minPrev;
           }
       }

       int minSum = Integer.MAX_VALUE;
       for (int val : grid[n - 1]) {
           minSum = Math.min(minSum, val);
       }
       return minSum;
   }
}

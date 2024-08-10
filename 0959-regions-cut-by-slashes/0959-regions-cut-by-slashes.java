class Solution {
   public int regionsBySlashes(String[] grid) {
       int dim = grid.length * 3;
       int[][] gridIslands = new int[dim + 2][dim + 2];
       boolean[][] visited = new boolean[dim + 2][dim + 2];

       for (int i = 0; i < gridIslands.length; i++) {
           gridIslands[0][i] = 1;
           gridIslands[gridIslands.length - 1][i] = 1;
           gridIslands[i][0] = 1;
           gridIslands[i][gridIslands.length - 1] = 1;
       }

       for (int i = 0; i < grid.length; i++) {
           String slashes = grid[i];
           for (int j = 0; j < slashes.length(); j++) {
               int starti = (i + 1) * 3 - 2;
               int startj = (j + 1) * 3 - 2;
               if (slashes.charAt(j) == '\\') {
                   for (int m = starti, n = 0; m < starti + 3; m++, n++) {
                       gridIslands[m][n + startj] = 1;
                   }
               } else if (slashes.charAt(j) == '/') {
                   for (int m = starti, n = 2; m < starti + 3; m++, n--) {
                       gridIslands[m][n + startj] = 1;
                   }
               }
           }
       }

       int count = 0;
       for (int i = 0; i < gridIslands.length; i++) {
           for (int j = 0; j < gridIslands[0].length; j++) {
               if (gridIslands[i][j] == 0 && !visited[i][j]) {
                   dfs(i, j, gridIslands, visited);
                   count++;
               }
           }
       }
       return count;
   }
   
   private void dfs(int i, int j, int[][] gridIslands, boolean[][] visited) {
       if (i >= 0 && j >= 0 && i < gridIslands.length && j < gridIslands[0].length && gridIslands[i][j] == 0 && !visited[i][j]) {
           visited[i][j] = true;
           dfs(i + 1, j, gridIslands, visited);
           dfs(i - 1, j, gridIslands, visited);
           dfs(i, j + 1, gridIslands, visited);
           dfs(i, j - 1, gridIslands, visited);
       }
   }
}

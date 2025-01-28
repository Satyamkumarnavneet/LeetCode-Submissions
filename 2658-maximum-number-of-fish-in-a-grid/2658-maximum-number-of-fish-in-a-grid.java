class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(i, j, visited, grid));
                }
            }
        }
        return maxFish;
    }

    private int dfs(int r, int c, boolean[][] visited, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int fishCaught = grid[r][c];
        fishCaught += dfs(r + 1, c, visited, grid);
        fishCaught += dfs(r - 1, c, visited, grid);
        fishCaught += dfs(r, c + 1, visited, grid);
        fishCaught += dfs(r, c - 1, visited, grid);
        return fishCaught;
    }
}

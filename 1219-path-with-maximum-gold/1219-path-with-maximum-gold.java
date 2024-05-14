class Solution {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                res = Math.max(res, helper(grid, i, j));
            }
        }
        return res;
    }
    
    public int helper(int[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[y].length || grid[y][x] == 0) {
            return 0;
        }
        int cell = grid[y][x];
        grid[y][x] = 0;
        int result = cell;
        result = Math.max(result, helper(grid, y + 1, x) + cell);
        result = Math.max(result, helper(grid, y - 1, x) + cell);
        result = Math.max(result, helper(grid, y, x + 1) + cell);
        result = Math.max(result, helper(grid, y, x - 1) + cell);
        grid[y][x] = cell;
        return result;
    }
}

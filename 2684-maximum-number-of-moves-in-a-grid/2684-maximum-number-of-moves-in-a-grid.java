class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxMoves = 0;

        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, helper(grid, dp, i, 0, m, n));
        }

        return maxMoves;
    }

    private int helper(int[][] grid, int[][] dp, int row, int col, int m, int n) {
        if (col == n - 1) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int maxFromCurrent = 0;

        if (row - 1 >= 0 && grid[row - 1][col + 1] > grid[row][col]) {
            maxFromCurrent = Math.max(maxFromCurrent, 1 + helper(grid, dp, row - 1, col + 1, m, n));
        }
        if (grid[row][col + 1] > grid[row][col]) {
            maxFromCurrent = Math.max(maxFromCurrent, 1 + helper(grid, dp, row, col + 1, m, n));
        }
        if (row + 1 < m && grid[row + 1][col + 1] > grid[row][col]) {
            maxFromCurrent = Math.max(maxFromCurrent, 1 + helper(grid, dp, row + 1, col + 1, m, n));
        }

        dp[row][col] = maxFromCurrent;
        return maxFromCurrent;
    }
}

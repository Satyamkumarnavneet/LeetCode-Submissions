class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int x, int y) {
        if (grid[x + 1][y + 1] != 5) {
            return false;
        }
        
        int[] vals = new int[16];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || vals[val] != 0) {
                    return false;
                }
                vals[val] = 1;
            }
        }
        
        int sum1 = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        int sum2 = grid[x + 1][y] + grid[x + 1][y + 1] + grid[x + 1][y + 2];
        int sum3 = grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2];
        int sum4 = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        int sum5 = grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1];
        int sum6 = grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2];
        int sum7 = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        int sum8 = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
        
        return sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6 && sum6 == sum7 && sum7 == sum8;
    }
}

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int score = (1 << (n - 1)) * m;
        for (int j = 1; j < n; ++j) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += grid[i][j] == grid[i][0] ? 1 : 0;
            }
            score += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return score;
    }
}

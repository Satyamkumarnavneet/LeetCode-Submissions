class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum = Arrays.stream(rods).sum();
        int[][] dp = new int[n + 1][2 * sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][sum] = 0;

        for (int i = 1; i <= n; i++) {
            int rod = rods[i - 1];
            for (int j = 0; j <= 2 * sum; j++) {
                if (dp[i - 1][j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j - rod >= 0 && dp[i - 1][j - rod] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rod] + rod);
                }
                if (j + rod <= 2 * sum && dp[i - 1][j + rod] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rod]);
                }
            }
        }
        return dp[n][sum];
    }
}
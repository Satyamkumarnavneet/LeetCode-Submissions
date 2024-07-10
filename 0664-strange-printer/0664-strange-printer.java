class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int minTurns = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minTurns = Math.min(minTurns, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minTurns;
                }
            }
        }
        return dp[0][n - 1];
    }
}

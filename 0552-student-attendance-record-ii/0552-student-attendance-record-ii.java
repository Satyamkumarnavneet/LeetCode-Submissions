class Solution {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][2][3];

        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int A = 0; A < 2; A++) {
                for (int L = 0; L < 3; L++) {

                    dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A][L]) % MOD;

                    if (L > 0) {
                        dp[i][A][L] = (dp[i][A][L] + dp[i - 1][A][L - 1]) % MOD;
                    }

                    if (A > 0) {
                        dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A - 1][L]) % MOD;
                    }
                }
            }
        }

        long result = 0;
        for (int A = 0; A < 2; A++) {
            for (int L = 0; L < 3; L++) {
                result = (result + dp[n][A][L]) % MOD;
            }
        }

        return (int) result;
    }
}
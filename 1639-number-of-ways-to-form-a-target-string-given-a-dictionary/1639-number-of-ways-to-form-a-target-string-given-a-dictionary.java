class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1000000007;
        int m = words.length, n = words[0].length();
        
        int[][] char_count = new int[n][26];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                char_count[j][word.charAt(j) - 'a']++;
            }
        }
        
        long[][] dp = new long[n + 1][target.length() + 1];
        dp[0][0] = 1;
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= target.length(); i++) {
                dp[j + 1][i] = (dp[j + 1][i] + dp[j][i]) % MOD;
                if (i < target.length()) {
                    dp[j + 1][i + 1] = (dp[j + 1][i + 1] + dp[j][i] * char_count[j][target.charAt(i) - 'a']) % MOD;
                }
            }
        }
        return (int) dp[n][target.length()];
    }
}
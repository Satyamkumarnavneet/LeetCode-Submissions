class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        dfs(s, 0, dp, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int start, boolean[][] dp, List<String> partition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                partition.add(s.substring(start, end + 1));
                dfs(s, end + 1, dp, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}

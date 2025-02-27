class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        final int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int ai = arr[k] - arr[j];
                if (indexMap.containsKey(ai)) {
                    int i = indexMap.get(ai);
                    if (i < j) { 
                        dp[j][k] = (dp[i][j] > 0 ? dp[i][j] : 2) + 1;
                        ans = Math.max(ans, dp[j][k]);
                    }
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}

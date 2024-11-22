class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxCount = 0;
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                pattern.append((row[0] == 1) ? row[j] : (1 - row[j]));
            }
            patternCount.put(pattern.toString(), patternCount.getOrDefault(pattern.toString(), 0) + 1);
            maxCount = Math.max(maxCount, patternCount.get(pattern.toString()));
        }
        return maxCount;
    }
}

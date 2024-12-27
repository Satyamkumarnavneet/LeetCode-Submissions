class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int bestPrevious = values[0];

        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, bestPrevious + values[j] - j);
            bestPrevious = Math.max(bestPrevious, values[j] + j);
        }
        return maxScore;
    }
}

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (containsZero(matrix)) {
            return totalSum;
        }

        if (negativeCount % 2 == 1) {
            totalSum -= 2L * minAbsValue;
        }

        return totalSum;
    }

    private boolean containsZero(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

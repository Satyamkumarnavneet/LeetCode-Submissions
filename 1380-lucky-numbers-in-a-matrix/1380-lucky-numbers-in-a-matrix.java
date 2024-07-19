class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] rowMins = new int[rows];
        int[] colMaxs = new int[cols];
        
        Arrays.fill(rowMins, Integer.MAX_VALUE);
        Arrays.fill(colMaxs, Integer.MIN_VALUE);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
                colMaxs[j] = Math.max(colMaxs[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowMins[i] && matrix[i][j] == colMaxs[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}
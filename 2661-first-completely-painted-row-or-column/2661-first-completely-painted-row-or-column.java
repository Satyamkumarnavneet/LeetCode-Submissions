class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] rowComplete = new boolean[m];
        boolean[] colComplete = new boolean[n];
        int[] paintedRowCount = new int[m];
        int[] paintedColCount = new int[n];
        Map<Integer, int[]> valueToPosition = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(mat[i][j], new int[]{i, j});
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] position = valueToPosition.get(value);
            int row = position[0];
            int col = position[1];
            
            paintedRowCount[row]++;
            paintedColCount[col]++;
            
            if (paintedRowCount[row] == n) {
                return i;
            }
            if (paintedColCount[col] == m) {
                return i;
            }
        }
        return -1;
    }
}

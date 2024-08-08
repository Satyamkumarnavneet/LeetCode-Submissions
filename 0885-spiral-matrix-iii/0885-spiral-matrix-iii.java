class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int steps = 1;
        int countStep = 0;
        int step = 0;
        int i = 0;
        
        while (i < rows * cols) {
            for (int j = 0; j < steps; j++) {
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                }
                rStart += dirs[direction][0];
                cStart += dirs[direction][1];
            }
            
            countStep++;
            if (countStep == 2) {
                step++;
                countStep = 0;
            }
            
            direction = (direction + 1) % 4;
            if (direction == 0 || direction == 2) {
                steps++; 
            }
        }
        
        return result;
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1]; // length of the square at (i,j)
        
        int maxEdge = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] == '1') { // the current cell, represented as dp[i][j]
                    /*
                    dp[i-1][j-1] is the prev upper left diagonal cell; each diagonal represents the previous 3 directions
                    dp[i-1][j] upper
                    dp[i][j-1] lefter
                    */
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxEdge = Math.max(dp[i][j], maxEdge);
                }
            }
        }
        
        return maxEdge*maxEdge; // area of square
    }
}
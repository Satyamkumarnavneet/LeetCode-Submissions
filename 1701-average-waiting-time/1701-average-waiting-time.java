class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long totalWaitTime = 0;
        long currentTime = 0;
        
        for (int i = 0; i < n; i++) {
            currentTime = Math.max(currentTime, customers[i][0]);
            currentTime += customers[i][1];
            totalWaitTime += currentTime - customers[i][0];
        }
        return (double) totalWaitTime / n;
    }
}

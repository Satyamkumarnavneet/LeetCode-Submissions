class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumKnown = 0;
        for (int roll : rolls) {
            sumKnown += roll;
        }
        
        int targetSum = mean * (n + m) - sumKnown;
        if (targetSum < n || targetSum > n * 6) {
            return new int[]{};
        }
        
        int[] result = new int[n];
        int avg = targetSum / n;
        int remainder = targetSum % n;
        
        for (int i = 0; i < n; i++) {
            result[i] = (i < remainder) ? avg + 1 : avg;
        }
        return result;
    }
}

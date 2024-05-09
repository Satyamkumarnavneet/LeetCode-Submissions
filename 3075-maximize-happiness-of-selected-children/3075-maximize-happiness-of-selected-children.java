class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long totalHappiness = 0;
        
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            totalHappiness += happiness[i];
        }
        return totalHappiness;
    }
}

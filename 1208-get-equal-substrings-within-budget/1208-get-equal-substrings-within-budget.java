class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];
        
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int totalCost = 0;
        
        while (end < n) {
            totalCost += costs[end];
            while (totalCost > maxCost) {
                totalCost -= costs[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        
        return maxLength;
    }
}

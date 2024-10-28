class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) {
            set.add((long) num);
        }
        
        int maxLength = -1;
        for (int num : nums) {
            long current = num;
            int length = 0;
            while (set.contains(current)) {
                length++;
                current *= current;
            }
            if (length > 1) { 
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}

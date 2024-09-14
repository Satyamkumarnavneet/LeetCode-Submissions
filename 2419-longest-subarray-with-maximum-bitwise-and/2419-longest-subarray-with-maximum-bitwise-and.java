class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int longestConsecutiveCount = 0;
        int currentConsecutiveCount = 0;
        for (int num : nums) {
            if (num == maxValue) {
                currentConsecutiveCount++;
                longestConsecutiveCount = Math.max(longestConsecutiveCount, currentConsecutiveCount);
            } else {
                currentConsecutiveCount = 0;
            }
        }
        return longestConsecutiveCount;
    }
}

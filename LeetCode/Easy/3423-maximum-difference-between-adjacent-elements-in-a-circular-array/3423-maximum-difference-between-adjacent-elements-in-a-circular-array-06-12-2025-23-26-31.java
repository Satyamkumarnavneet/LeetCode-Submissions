class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            int diff = Math.abs(nums[i] - nums[next]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}

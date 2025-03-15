class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int minCap = Integer.MAX_VALUE;
        
        for (int i = 0; i < (1 << n); i++) {
            int count = 0;
            int maxRobbed = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                    maxRobbed = Math.max(maxRobbed, nums[j]);
                    if (count > k) break;
                    if (j + 1 < n && (i & (1 << (j + 1))) != 0) {
                        break;
                    }
                }
            }
            if (count == k) {
                minCap = Math.min(minCap, maxRobbed);
            }
        }
        return minCap;
    }
}

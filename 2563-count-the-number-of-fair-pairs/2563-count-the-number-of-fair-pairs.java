class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int low = Arrays.binarySearch(nums, lower - nums[i]);
            if (low < 0) low = -(low + 1);
            int high = Arrays.binarySearch(nums, upper - nums[i]);
            if (high < 0) high = -(high + 1);
            else high++;
            low = Math.max(low, i + 1);
            if (low < high) {
                count += high - low;
            }
        }

        long sameNumberPairsCount = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            int k = j - i;
            if (2 * nums[i] >= lower && 2 * nums[i] <= upper) {
                sameNumberPairsCount += (long)k * (k - 1) / 2;
            }
            i = j;
        }
        return count + sameNumberPairsCount;
    }
}

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numOperations(nums, mid) > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int numOperations(int[] nums, int maxVal) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxVal) {
                operations += (num - 1) / maxVal;
            }
        }
        return operations;
    }
}

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftLIS = new int[n];
        for (int i = 0; i < n; i++) {
            leftLIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    leftLIS[i] = Math.max(leftLIS[i], leftLIS[j] + 1);
                }
            }
        }

        int[] rightLDS = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightLDS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    rightLDS[i] = Math.max(rightLDS[i], rightLDS[j] + 1);
                }
            }
        }

        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (leftLIS[i] > 1 && rightLDS[i] > 1) {
                maxMountainLength = Math.max(maxMountainLength, leftLIS[i] + rightLDS[i] - 1);
            }
        }
        return n - maxMountainLength;
    }
}

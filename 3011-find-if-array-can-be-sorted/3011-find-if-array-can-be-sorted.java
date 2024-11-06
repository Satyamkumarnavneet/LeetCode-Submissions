class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    int bitCountI = Integer.bitCount(nums[i]);
                    int bitCountJ = Integer.bitCount(nums[j]);
                    if (bitCountI == bitCountJ) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

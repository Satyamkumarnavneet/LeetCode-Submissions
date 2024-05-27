class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int x = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i + 1) {
                    count++;
                }
            }
            if (count == i + 1) {
                x = count;
                break;
            }
        }
        return x;
    }
}

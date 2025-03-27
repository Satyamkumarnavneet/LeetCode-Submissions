class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canRob(int[] nums, int cap, int k) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i += 2;
            } else {
                i++;
            }
            if (count >= k) return true;
        }
        return false;
    }
}
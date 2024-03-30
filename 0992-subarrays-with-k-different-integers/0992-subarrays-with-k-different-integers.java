class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int distinct = 0;
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < n; right++) {
            if (count[nums[right]] == 0) {
                distinct++;
            }
            count[nums[right]]++;
            
            while (distinct > k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            
            result += right - left + 1;
        }
        
        return result;
    }
}

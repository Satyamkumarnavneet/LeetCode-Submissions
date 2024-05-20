class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        int n = nums.length;
        int limit = (1 << n) - 1;
        
        for (int mask = 1; mask <= limit; mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    xor ^= nums[i];
                }
            }
            result += xor;
        }
        return result;
    }
}

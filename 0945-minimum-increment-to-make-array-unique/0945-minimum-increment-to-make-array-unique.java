class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int moves = 0;
        for(int i = 1; i < n; i ++){
            if(nums[i] <= nums[i-1]){
                moves = moves + Math.abs(nums[i] - (nums[i-1] + 1));
                nums[i] = nums[i-1] + 1;
            }
        }
        return moves;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int reach = 0;
        for(int i=0;i<n;++i){
            if(reach<i){
                return false;
            } 
            reach = Math.max(reach,i+nums[i]);
        }
        return true;
    }
}
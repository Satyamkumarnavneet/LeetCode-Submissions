class Solution {
   public int jump(int[] nums) {
       
        int n = nums.length;
        int max_steps = 0;
        int cur = 0;
        int jumps = 0;
        
        for (int i=0;i<n-1;i++)
        {
            max_steps = Math.max(max_steps,i + nums[i]);
            if (cur == i)
            {
                cur = max_steps;
                jumps++;
            }
           
            
        }
        return jumps;
        
        
    }
}
class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        return backtrack(nums, new boolean[nums.length], -1, 0);
    }
    
    private int backtrack(int[] nums, boolean[] visited, int prevIndex, int count) {
        if (count == nums.length) {
            return 1;
        }
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            if (prevIndex == -1 || isSquareful(nums[prevIndex] + nums[i])) {
                visited[i] = true;
                result += backtrack(nums, visited, i, count + 1);
                visited[i] = false;
            }
        }
        
        return result;
    }
    private boolean isSquareful(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int complement = target - nums[i]; // complement: which is the value needed to add up to the target sum

            if(map.containsKey(complement)){
                return new int []{map.get(complement), i}; // return the indexices if target sum found
            }
            map.put(nums[i], i); // Store the current number for future iteration
        }
        return new int [0];
    }
}
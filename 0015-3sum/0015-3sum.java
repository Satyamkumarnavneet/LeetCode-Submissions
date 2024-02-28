class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            if (i>0 && nums[i] == nums[i - 1]) {
				continue;
			}

            int low=i+1;
            int high=nums.length-1;
            
            while(low<high) {
                if(nums[low]+nums[high]==-nums[i]) {
                    res.add(Arrays.asList(nums[low],nums[high],nums[i]));
                    low++;
                    high--;
                } else if(nums[low]+nums[high]>-nums[i]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
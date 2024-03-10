class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        
        solve(0, nums, visited, list, ans);
        
        return ans;
    }
    
    public void solve(int i, int nums[], boolean visited[], List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(list);
            return;
        }
        
        for(int k=0;k<nums.length;k++){
            if(!visited[k]){
                if(k!=0 && nums[k-1]==nums[k] && !visited[k-1]){
                    continue;
                }
                visited[k]=true;
                list.add(nums[k]);
                solve(k, nums, visited, new ArrayList<>(list), ans);
                list.remove(list.size()-1);
                visited[k]=false;
            }
        }
    }
} 
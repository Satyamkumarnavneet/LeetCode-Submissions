class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        freq = Counter(nums)
        operations = 0
        
        while True:
            distinct_elements = set(nums)
            
            if len(distinct_elements) == len(nums):
                break
            
            operations += 1
            nums = nums[3:]
        
        return operations

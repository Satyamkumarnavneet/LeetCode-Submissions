class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        def kadane(arr):
            max_sum, current_sum = 0, 0
            for x in arr:
                current_sum += x
                max_sum = max(max_sum, current_sum)
                if current_sum < 0:
                    current_sum = 0
            return max_sum

        max_positive = kadane(nums)
        max_negative = kadane([-x for x in nums])
        
        return max(max_positive, max_negative)
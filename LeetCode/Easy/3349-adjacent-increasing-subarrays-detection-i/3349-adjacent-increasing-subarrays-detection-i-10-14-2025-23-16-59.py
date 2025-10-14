class Solution(object):
    def hasIncreasingSubarrays(self, nums, k):
        for i in range(len(nums) - 2 * k + 1):
            if all(nums[i + j] < nums[i + j + 1] for j in range(k - 1)) and all(nums[i + k + j] < nums[i + k + j + 1] for j in range(k - 1)):
                return True
        return False

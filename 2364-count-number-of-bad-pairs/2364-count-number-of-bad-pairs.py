class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        n = len(nums)
        total_pairs = n * (n - 1) // 2
        good_pairs = 0
        diff_map = {}
        
        for i, num in enumerate(nums):
            diff = num - i
            if diff in diff_map:
                good_pairs += diff_map[diff]
            if diff not in diff_map:
                diff_map[diff] = 0
            diff_map[diff] += 1
        
        return total_pairs - good_pairs

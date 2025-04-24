class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        distinct_elements = set(nums)
        total_distinct = len(distinct_elements)
        n = len(nums)
        count = 0
        left = 0
        element_count = {}

        for right in range(n):
            element_count[nums[right]] = element_count.get(nums[right], 0) + 1

            while len(element_count) == total_distinct:
                count += (n - right)
                element_count[nums[left]] -= 1
                if element_count[nums[left]] == 0:
                    del element_count[nums[left]]
                left += 1

        return count

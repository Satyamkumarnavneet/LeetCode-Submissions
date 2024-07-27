from typing import List

class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        def maxArray(nums, k):
            stack = []
            toPop = len(nums) - k

            for num in nums:
                while toPop and stack and stack[-1] < num:
                    stack.pop()
                    toPop -= 1
                stack.append(num)

            return stack[:k]

        def mergeArray(nums1, nums2):
            res = []
            while nums1 or nums2:
                bigger = nums1 if nums1 > nums2 else nums2
                res.append(bigger[0])
                bigger.pop(0)
            return res

        result = []
        for i in range(max(0, k - len(nums2)), min(k, len(nums1)) + 1):
            merged = mergeArray(maxArray(nums1, i), maxArray(nums2, k - i))
            result = max(result, merged)

        return result

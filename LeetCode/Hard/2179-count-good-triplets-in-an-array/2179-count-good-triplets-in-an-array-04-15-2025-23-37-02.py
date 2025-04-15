class Solution:
    def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        pos2 = [0] * n
        for i in range(n):
            pos2[nums2[i]] = i

        index = [pos2[num] for num in nums1]

        def update(bit, i, delta):
            while i < len(bit):
                bit[i] += delta
                i += i & -i

        def query(bit, i):
            res = 0
            while i > 0:
                res += bit[i]
                i -= i & -i
            return res

        bit1 = [0] * (n + 2)
        bit2 = [0] * (n + 2)
        left = [0] * n
        right = [0] * n

        for i in range(n):
            left[i] = query(bit1, index[i] + 1)
            update(bit1, index[i] + 1, 1)

        for i in range(n - 1, -1, -1):
            right[i] = query(bit2, n) - query(bit2, index[i] + 1)
            update(bit2, index[i] + 1, 1)

        res = 0
        for i in range(n):
            res += left[i] * right[i]
        return res
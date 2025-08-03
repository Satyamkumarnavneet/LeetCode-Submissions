class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        from bisect import bisect_left, bisect_right

        n = len(fruits)
        positions = [pos for pos, _ in fruits]
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + fruits[i][1]

        def get_sum(left: int, right: int) -> int:
            l = bisect_left(positions, left)
            r = bisect_right(positions, right)
            return prefix[r] - prefix[l]

        ans = 0
        for steps in range(k + 1):
            left = startPos - steps
            right = startPos + max(0, k - 2 * steps)
            ans = max(ans, get_sum(left, right))

            right = startPos + steps
            left = startPos - max(0, k - 2 * steps)
            ans = max(ans, get_sum(left, right))
            
        return ans

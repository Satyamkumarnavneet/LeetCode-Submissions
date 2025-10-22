class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        from collections import Counter

        count = Counter(power)
        unique = sorted(count.keys())
        total = {x: x * count[x] for x in unique}

        n = len(unique)
        dp = [0] * n

        for i in range(n):
            take = total[unique[i]]
            j = i - 1
            while j >= 0 and unique[j] >= unique[i] - 2:
                j -= 1
            if j >= 0:
                take += dp[j]
            skip = dp[i-1] if i > 0 else 0
            dp[i] = max(skip, take)

        return dp[-1]

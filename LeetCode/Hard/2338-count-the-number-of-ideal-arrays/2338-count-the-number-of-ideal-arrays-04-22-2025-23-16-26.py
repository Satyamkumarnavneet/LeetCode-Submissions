MOD = 10**9 + 7

class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        dp = [[0] * (maxValue + 1) for _ in range(n + 1)]
        
        for i in range(1, maxValue + 1):
            dp[1][i] = 1
        
        for i in range(2, n + 1):
            for j in range(1, maxValue + 1):
                for k in range(j, maxValue + 1, j):
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD
        
        result = 0
        for i in range(1, maxValue + 1):
            result = (result + dp[n][i]) % MOD
        
        return result

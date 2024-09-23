class Solution:
    def minExtraChar(self, s: str, dictionary: list[str]) -> int:
        n = len(s)
        dictionarySet = set(dictionary)
        dp = [0] + [n] * n

        for i in range(1, n + 1):
            for j in range(i):
                if s[j:i] in dictionarySet:
                    dp[i] = min(dp[i], dp[j])
                else:
                    dp[i] = min(dp[i], dp[j] + i - j)
                    
        return dp[n]

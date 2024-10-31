class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort()

        n, m = len(robot), len(factory)
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]
        dp[0][0] = 0  

        for j in range(1, m + 1): 
            position, limit = factory[j - 1]
            dp[0][j] = 0  

            for i in range(1, n + 1):  
                dp[i][j] = dp[i][j - 1] 
            
                cost = 0
                for k in range(1, min(limit, i) + 1): 
                    cost += abs(robot[i - k] - position) 
                    dp[i][j] = min(dp[i][j], dp[i - k][j - 1] + cost) 

        return dp[n][m]
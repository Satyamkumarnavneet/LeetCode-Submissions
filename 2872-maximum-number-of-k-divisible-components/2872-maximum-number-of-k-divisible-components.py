class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        g = [[] for _ in range(n)]
        for a, b in edges:
            g[a].append(b)
            g[b].append(a)
        
        ans = 0
        
        def dfs(i: int, fa: int) -> int:
            nonlocal ans
            s = values[i]
            for j in g[i]:
                if j != fa:
                    s += dfs(j, i)
            if s % k == 0:
                ans += 1
            return s

        dfs(0, -1)
        return ans

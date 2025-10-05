class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights or not heights[0]:
            return []

        m, n = len(heights), len(heights[0])
        pacific, atlantic = set(), set()

        def dfs(i, j, visited):
            if (i < 0 or i >= m or j < 0 or j >= n or (i, j) in visited):
                return

            visited.add((i, j))
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < m and 0 <= y < n and heights[x][y] >= heights[i][j]:
                    dfs(x, y, visited)

        for i in range(m):
            dfs(i, 0, pacific)
            dfs(i, n - 1, atlantic)

        for j in range(n):
            dfs(0, j, pacific)
            dfs(m - 1, j, atlantic)

        return list(pacific & atlantic)

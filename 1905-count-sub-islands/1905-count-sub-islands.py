class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        def dfs(x, y, grid1, grid2):
            if x < 0 or x >= len(grid2) or y < 0 or y >= len(grid2[0]) or grid2[x][y] == 0:
                return True
            if grid1[x][y] == 0:
                return False
            grid2[x][y] = 0
            ans = True
            ans &= dfs(x+1, y, grid1, grid2)
            ans &= dfs(x-1, y, grid1, grid2)
            ans &= dfs(x, y+1, grid1, grid2)
            ans &= dfs(x, y-1, grid1, grid2)
            return ans
        
        count = 0
        for i in range(len(grid2)):
            for j in range(len(grid2[0])):
                if grid2[i][j] == 1 and dfs(i, j, grid1, grid2):
                    count += 1
        return count

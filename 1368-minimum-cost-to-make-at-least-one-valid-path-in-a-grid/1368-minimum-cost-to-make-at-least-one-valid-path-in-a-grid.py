class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        def get_new_pos(i, j, direction):
            if direction == 1:
                return i, j + 1
            elif direction == 2:
                return i, j - 1
            elif direction == 3:
                return i + 1, j
            elif direction == 4:
                return i - 1, j
        
        pq = [(0, 0, 0)]  # cost, row, col
        costs = [[float('inf')] * n for _ in range(m)]
        costs[0][0] = 0
        
        while pq:
            cost, x, y = heapq.heappop(pq)
            if (x, y) == (m - 1, n - 1):
                return cost
            for d, (dx, dy) in enumerate(directions, 1):
                nx, ny = x + dx, y + dy
                new_cost = cost + (grid[x][y] != d)
                if 0 <= nx < m and 0 <= ny < n and new_cost < costs[nx][ny]:
                    costs[nx][ny] = new_cost
                    heapq.heappush(pq, (new_cost, nx, ny))
        
        return costs[m - 1][n - 1]
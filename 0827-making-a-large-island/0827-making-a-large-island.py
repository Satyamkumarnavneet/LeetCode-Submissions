class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        island_id = 2
        island_sizes = {0: 0}

        def dfs(r: int, c: int) -> int:
            if r < 0 or r >= n or c < 0 or c >= n or grid[r][c] != 1:
                return 0
            grid[r][c] = island_id
            size = 1
            size += dfs(r + 1, c)
            size += dfs(r - 1, c)
            size += dfs(r, c + 1)
            size += dfs(r, c - 1)
            return size

        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    size = dfs(i, j)
                    island_sizes[island_id] = size
                    island_id += 1

        max_island_size = max(island_sizes.values()) if island_sizes else 0

        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    visited_islands = set()
                    potential_size = 1
                    for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                        ni, nj = i + dr, j + dc
                        if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] > 1:
                            island_id_neighbor = grid[ni][nj]
                            if island_id_neighbor not in visited_islands:
                                potential_size += island_sizes[island_id_neighbor]
                                visited_islands.add(island_id_neighbor)
                    max_island_size = max(max_island_size, potential_size)

        return max(max_island_size, 1)

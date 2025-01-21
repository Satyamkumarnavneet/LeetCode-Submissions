class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        num_columns = len(grid[0])
        total_row0 = sum(grid[0])
        current_row1_sum = 0
        
        for index in range(num_columns - 1):
            total_row0 -= grid[0][index]
            current_row1_sum += grid[1][index]
            if current_row1_sum >= total_row0:
                return max(total_row0, current_row1_sum - grid[1][index])
        
        return current_row1_sum
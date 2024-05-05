class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        pq.offer(new int[]{0, 0});
        visited[0][0] = true;
        int result = 0; 
        
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int x = pos[0], y = pos[1];
            int elevation = grid[x][y];
            result = Math.max(result, elevation); 

            if (x == n - 1 && y == n - 1) {
                return result;
            }
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{newX, newY});
                }
            }
        }
        return -1; 
    }
}

class Solution {
    int[] dir_X = {1, -1, 0, 0};
    int[] dir_Y = {0, 0, 1, -1};

    private void solveBFS(int[][] res, int r, int c, int n, int m) {
        boolean[][] vis = new boolean[n][m];
        vis[r][c] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] top = q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = dir_X[i] + top[0];
                int nc = dir_Y[i] + top[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && res[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    res[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            res[i] = Arrays.copyOf(grid[i], grid[i].length);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == 1) {
                    solveBFS(res, i, j, n, m);
                    ans++;
                }
            }
        }

        if (ans > 1 || ans == 0) {
            return 0;
        }

        for (int i = 0; i < list.size(); i++) {
            int r = list.get(i)[0];
            int c = list.get(i)[1];

            res = new int[n][m];
            for (int k = 0; k < n; k++) {
                res[k] = Arrays.copyOf(grid[k], grid[k].length);
            }

            res[r][c] = 0;
            ans = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (res[j][k] == 1) {
                        solveBFS(res, j, k, n, m);
                        ans++;
                    }
                }
            }

            if (ans > 1 || ans == 0) {
                return 1;
            }
        }
        return 2;
    }
}

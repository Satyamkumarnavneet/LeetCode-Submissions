class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            if (i < n - 1) {
                graph[i].add(i + 1);
            }
        }

        int m = queries.length;
        int[] results = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(v);
            results[i] = bfs(graph, n);
        }
        
        return results;
    }

    private int bfs(List<Integer>[] graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        int distance = 0;
        
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int u = queue.poll();
                if (u == n - 1) return distance;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}

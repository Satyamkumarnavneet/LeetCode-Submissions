class Solution {
    int[] res, count;
    List<Set<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res = new int[n];
        count = new int[n];
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1, n); // Pass n as a parameter
        return res;
    }
    
    private void dfs(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs(child, node);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
        count[node]++;
    }
    
    private void dfs2(int node, int parent, int n) { // Receive n as a parameter
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            res[child] = res[node] - count[child] + n - count[child];
            dfs2(child, node, n);
        }
    }
}

class Solution {
    List<Integer>[] tree;
    int[] xor, in, out;
    int time = 0, totalXor = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        tree = new ArrayList[n];
        xor = new int[n];
        in = new int[n];
        out = new int[n];

        for (int i = 0; i < n; ++i) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        dfs(0, -1, nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (i == 0 || j == 0) continue;

                int x = xor[i], y = xor[j], z = totalXor ^ x ^ y;

                if (isAncestor(i, j)) {
                    x = xor[j];
                    y = xor[i] ^ xor[j];
                    z = totalXor ^ xor[i];
                } else if (isAncestor(j, i)) {
                    x = xor[i];
                    y = xor[j] ^ xor[i];
                    z = totalXor ^ xor[j];
                }

                int max = Math.max(x, Math.max(y, z));
                int minVal = Math.min(x, Math.min(y, z));
                min = Math.min(min, max - minVal);
            }
        }

        return min;
    }
    
    void dfs(int node, int parent, int[] nums) {
        xor[node] = nums[node];
        in[node] = time++;
        for (int nei : tree[node]) {
            if (nei != parent) {
                dfs(nei, node, nums);
                xor[node] ^= xor[nei];
            }
        }
        out[node] = time++;
        totalXor = xor[0];
    }
    boolean isAncestor(int u, int v) {
        return in[u] < in[v] && out[u] > out[v];
    }
}

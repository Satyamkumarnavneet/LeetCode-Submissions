class Solution {
    public List<Integer> topological_sort(int k, List<int[]> conditions) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[k + 1];
        
        for (int[] condition : conditions) {
            int u = condition[0], v = condition[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> topo_order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo_order.add(node);
            
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return topo_order.size() == k ? topo_order : new ArrayList<>();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row_order = topological_sort(k, Arrays.asList(rowConditions));
        List<Integer> col_order = topological_sort(k, Arrays.asList(colConditions));
        
        if (row_order.isEmpty() || col_order.isEmpty()) {
            return new int[0][0];
        }
        
        Map<Integer, int[]> position_map = new HashMap<>();
        for (int i = 0; i < row_order.size(); i++) {
            position_map.put(row_order.get(i), new int[]{i, -1});
        }
        for (int j = 0; j < col_order.size(); j++) {
            if (position_map.containsKey(col_order.get(j))) {
                position_map.get(col_order.get(j))[1] = j;
            }
        }
        
        int[][] matrix = new int[k][k];
        for (Map.Entry<Integer, int[]> entry : position_map.entrySet()) {
            int num = entry.getKey();
            int[] pos = entry.getValue();
            if (pos[1] != -1) {
                matrix[pos[0]][pos[1]] = num;
            }
        }
        return matrix;
    }
}
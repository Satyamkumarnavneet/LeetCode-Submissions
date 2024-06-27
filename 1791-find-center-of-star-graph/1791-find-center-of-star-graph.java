class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int[] edge : edges) {
            freqMap.put(edge[0], freqMap.getOrDefault(edge[0], 0) + 1);
            freqMap.put(edge[1], freqMap.getOrDefault(edge[1], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == n - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

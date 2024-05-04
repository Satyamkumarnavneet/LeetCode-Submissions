class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n - 1], n - 1);
        int goodIndices = 1;

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = treeMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lo = treeMap.floorEntry(arr[i]);

            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }

            if (higher[i]) {
                goodIndices++;
            }
            treeMap.put(arr[i], i);
        }
        return goodIndices;
    }
}

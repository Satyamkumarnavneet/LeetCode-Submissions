class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> parent = new HashMap<>();
        int count = 0;

        for (int[] stone : stones) {
            int x = -stone[0] - 1;
            int y = stone[1] + 10000;
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (!parent.containsKey(y)) {
                parent.put(y, y);
                count++;
            }
            count -= union(parent, x, y);
        }

        return stones.length - count;
    }

    private int find(Map<Integer, Integer> parent, int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }

    private int union(Map<Integer, Integer> parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent.put(rootX, rootY);
            return 1;
        }
        return 0;
    }
}

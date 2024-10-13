class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxElement = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            maxElement = Math.max(maxElement, nums.get(i).get(0));
            minHeap.offer(new int[] {nums.get(i).get(0), i, 0});
        }

        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            int minRange = current[0];
            int i = current[1];
            int j = current[2];

            if (maxElement - minRange < rangeEnd - rangeStart) {
                rangeStart = minRange;
                rangeEnd = maxElement;
            }

            if (j + 1 < nums.get(i).size()) {
                int next = nums.get(i).get(j + 1);
                maxElement = Math.max(maxElement, next);
                minHeap.offer(new int[] {next, i, j + 1});
            } else {
                break; 
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }
}

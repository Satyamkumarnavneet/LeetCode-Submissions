class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> pqCost = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pqProfit = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pqCost.add(new int[]{capital[i], profits[i]});
        }
        
        while (k > 0) {
            while (!pqCost.isEmpty() && pqCost.peek()[0] <= w) {
                int[] current = pqCost.poll();
                int profit = current[1];
                pqProfit.add(profit);
            }
            if (pqProfit.isEmpty()) {
                break;
            }
            w += pqProfit.poll();
            k--;
        }
        return w;
    }
}

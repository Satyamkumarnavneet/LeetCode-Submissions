class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]); // People before k
            } else {
                total += Math.min(tickets[i], tickets[k] - 1); // People after k
            }
        }

        return total;
    }
}

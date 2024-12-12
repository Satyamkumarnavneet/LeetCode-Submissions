class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts) {
            pq.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int maxGifts = pq.poll();
            int remainingGifts = (int) Math.floor(Math.sqrt(maxGifts));
            pq.add(remainingGifts);
        }

        long totalRemainingGifts = 0;
        while (!pq.isEmpty()) {
            totalRemainingGifts += pq.poll();
        }
        return totalRemainingGifts;
    }
}
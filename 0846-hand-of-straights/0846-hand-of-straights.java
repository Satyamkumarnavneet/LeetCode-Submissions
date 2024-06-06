class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // If the hand cannot be divided equally into groups, return false
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1); // Count occurrences of each card
        }
        
        Arrays.sort(hand); // Sort the hand
        
        for (int card : hand) {
            if (map.get(card) > 0) { // If the card is available to form a group
                for (int i = 0; i < groupSize; i++) {
                    if (map.getOrDefault(card + i, 0) > 0) {
                        map.put(card + i, map.get(card + i) - 1); // Decrease count of the consecutive cards
                    } else {
                        return false; // If not enough consecutive cards are available, return false
                    }
                }
            }
        }
        return true; 
    }
}
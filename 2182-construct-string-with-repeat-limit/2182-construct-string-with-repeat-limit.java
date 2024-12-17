class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (char i = 'a'; i <= 'z'; i++) {
            if (freq[i - 'a'] > 0) {
                maxHeap.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int count = Math.min(freq[current - 'a'], repeatLimit);
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
            freq[current - 'a'] -= count;

            if (freq[current - 'a'] == 0) {
                continue;
            }

            if (!maxHeap.isEmpty()) {
                char next = maxHeap.peek();
                result.append(next);
                freq[next - 'a']--;

                if (freq[next - 'a'] == 0) {
                    maxHeap.poll();
                }
                maxHeap.add(current);
            }
        }
        return result.toString();
    }
}

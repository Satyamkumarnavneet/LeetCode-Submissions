class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> vowelIdx = new HashMap<>();
        vowelIdx.put('a', 0);
        vowelIdx.put('e', 1);
        vowelIdx.put('i', 2);
        vowelIdx.put('o', 3);
        vowelIdx.put('u', 4);

        int n = s.length();
        int[] state = new int[32]; 
        Arrays.fill(state, -1);
        state[0] = 0;

        int current = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (vowelIdx.containsKey(c)) {
                int idx = vowelIdx.get(c);
                current ^= 1 << idx;
            }

            if (state[current] != -1) {
                maxLength = Math.max(maxLength, i + 1 - state[current]);
            } else {
                state[current] = i + 1;
            }
        }
        return maxLength;
    }
}

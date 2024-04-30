class Solution {
    public long wonderfulSubstrings(String word) {
        long count = 0;
        int[] freq = new int[1 << 10];
        freq[0] = 1;
        int mask = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            mask ^= 1 << idx;
            
            count += freq[mask];
            for (int j = 0; j < 10; j++) {
                count += freq[mask ^ (1 << j)];
            }
            
            freq[mask]++;
        }
        
        return count;
    }
}

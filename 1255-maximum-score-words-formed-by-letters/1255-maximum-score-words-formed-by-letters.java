class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for (int i = 0; i < letters.length; i++) {
            freq[letters[i] - 'a']++; //creating a frequency array
        }
        return helper(words, freq, score, 0);
    }

    public int helper(String[] words, int[] freq, int[] score, int index) {
        if (index == words.length) {
            return 0;   // base case
        }
        String s = words[index];
        int last = s.length();
        int take = 0;
        // not taking the current word from the array
        int notake = helper(words, freq, score, index + 1);
        boolean valid = true;
        int currscore = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] != 0) {
                currscore += score[ch - 'a'];
                freq[ch - 'a']--;
            } else {
                valid = false;
                last = i;
                break;
            }
        }
        if (valid) {
            take += currscore;
            take += helper(words, freq, score, index + 1);
        }
        for (int i = 0; i < last; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        return Math.max(take, notake);
    }
}
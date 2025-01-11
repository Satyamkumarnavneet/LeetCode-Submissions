class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == k) {
            return true;
        }
        
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}

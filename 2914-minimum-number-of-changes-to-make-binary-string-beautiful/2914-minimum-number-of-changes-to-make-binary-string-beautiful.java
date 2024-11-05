class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int n = s.length();

        for (int i = 0; i < n; i += 2) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            
            if (first != second) {
                changes++;
            }
        }
        return changes;
    }
}

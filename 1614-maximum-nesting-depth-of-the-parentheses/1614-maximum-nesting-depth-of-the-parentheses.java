class Solution {
    public int maxDepth(String s) {
        int length = s.length();
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                currentDepth++;
                maxDepth = Math.max(currentDepth, maxDepth);
            } else if (s.charAt(i) == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}

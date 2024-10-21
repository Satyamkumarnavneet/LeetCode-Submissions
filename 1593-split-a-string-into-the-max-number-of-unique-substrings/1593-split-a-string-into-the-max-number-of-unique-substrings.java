class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, new HashSet<>());
    }

    private int backtrack(String s, Set<String> set) {
        int maxCount = 0;
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (!set.contains(sub)) {
                set.add(sub);
                maxCount = Math.max(maxCount, 1 + backtrack(s.substring(i), set));
                set.remove(sub);
            }
        }
        return maxCount;
    }
}

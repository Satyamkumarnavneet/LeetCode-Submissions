class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int[] mismatchedIdx = new int[2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count < 2) {
                    mismatchedIdx[count] = i;
                }
                count++;
            }
        }

        if (count != 2) {
            return false;
        }
        return s1.charAt(mismatchedIdx[0]) == s2.charAt(mismatchedIdx[1]) && s1.charAt(mismatchedIdx[1]) == s2.charAt(mismatchedIdx[0]);
    }
}

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (j < m) {
                if (str1.charAt(i) == str2.charAt(j) || 
                    (str1.charAt(i) - 'a' + 1) % 26 == (str2.charAt(j) - 'a')) {
                    j++;
                }
            } else {
                break;
            }
        }
        return j == m;
    }
}

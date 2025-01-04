class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<String> palindromicSubsequences = new HashSet<>();
        int n = s.length();
        
        for (char x = 'a'; x <= 'z'; x++) {
            int first = -1;
            int last = -1;

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == x) {
                    if (first == -1) {
                        first = j;
                    }
                    last = j;
                }
            }

            if (first != -1 && last != -1 && first < last) {
                HashSet<Character> middleChars = new HashSet<>();
                for (int k = first + 1; k < last; k++) {
                    middleChars.add(s.charAt(k));
                }

                for (char y : middleChars) {
                    palindromicSubsequences.add("" + x + y + x);
                }
            }
        }
        return palindromicSubsequences.size();
    }
}

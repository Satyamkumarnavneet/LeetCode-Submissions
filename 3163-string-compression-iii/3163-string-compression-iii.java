class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n;) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            while (count > 0) {
                int toTake = Math.min(9, count);
                ans.append(toTake).append(c);
                count -= toTake;
            }
        }
        return ans.toString();
    }
}

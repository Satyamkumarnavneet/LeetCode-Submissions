class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] d = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int diff = (direction == 1) ? 1 : -1;
            d[start] += diff;
            if (end + 1 < n) {
                d[end + 1] -= diff;
            }
        }
        StringBuilder result = new StringBuilder();
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += d[i];
            char newChar = (char) ((s.charAt(i) - 'a' + (currentShift % 26) + 26) % 26 + 'a');
            result.append(newChar);
        }
        return result.toString();
    }
}

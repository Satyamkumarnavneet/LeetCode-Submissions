class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int num : chalk) {
            totalChalk += num;
        }
        k %= totalChalk;
        int i = 0;
        while (k >= chalk[i]) {
            k -= chalk[i];
            i++;
        }
        return i;
    }
}

class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0, num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
        }
        int maxSize = 0;
        for (int c : count) {
            maxSize = Math.max(maxSize, c);
        }
        int largestGroups = 0;
        for (int c : count) {
            if (c == maxSize) {
                largestGroups++;
            }
        }
        return largestGroups;
    }
}

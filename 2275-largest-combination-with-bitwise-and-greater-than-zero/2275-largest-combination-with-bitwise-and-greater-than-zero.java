class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[32];
        int maxSize = 0;

        for (int num : candidates) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        for (int count : bitCount) {
            maxSize = Math.max(maxSize, count);
        }
        return maxSize;
    }
}

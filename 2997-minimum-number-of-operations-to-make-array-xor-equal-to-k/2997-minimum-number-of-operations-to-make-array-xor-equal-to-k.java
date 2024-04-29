class Solution {
    public int minOperations(int[] nums, int targetXor) {
        int operationsCount = 0;
        for (int bit = 0; bit <= 20; bit++) {
            int currentBitXor = 0;
            for (int num : nums) {
                int numBit = (1 << bit) & num;
                currentBitXor ^= numBit;
            }

            int targetBit = (1 << bit) & targetXor;
            if (currentBitXor != targetBit) {
                operationsCount++;
            }
        }
        return operationsCount;
    }
}

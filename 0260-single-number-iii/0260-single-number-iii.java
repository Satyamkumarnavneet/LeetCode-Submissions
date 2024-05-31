class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        int rightmostSetBit = 1;
        while ((diff & rightmostSetBit) == 0) {
            rightmostSetBit <<= 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }
        return new int[]{result1, result2};
    }
}

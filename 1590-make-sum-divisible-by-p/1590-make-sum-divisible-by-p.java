class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int targetMod = totalSum % p;
        if (targetMod == 0) return 0;

        int minLength = nums.length;
        HashMap<Integer, Integer> remainderIndices = new HashMap<>();
        remainderIndices.put(0, -1);
        int currentSumMod = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSumMod = (currentSumMod + nums[i]) % p;
            int neededMod = (currentSumMod - targetMod + p) % p;
            if (remainderIndices.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - remainderIndices.get(neededMod));
            }
            remainderIndices.put(currentSumMod, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Integer[] numsWrapper = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsWrapper[i] = nums[i];
        }

        Arrays.sort(numsWrapper, (a, b) -> {
            if (freqMap.get(a).equals(freqMap.get(b))) {
                return Integer.compare(b, a);
            } else {
                return Integer.compare(freqMap.get(a), freqMap.get(b));
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsWrapper[i];
        }
        return nums;
    }
}

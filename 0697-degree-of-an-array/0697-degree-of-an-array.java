class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!left.containsKey(num)) {
                left.put(num, i);
            }
            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int degree = Collections.max(count.values());

        int minSubArrayLength = nums.length;
        for (int key : count.keySet()) {
            if (count.get(key) == degree) {
                minSubArrayLength = Math.min(minSubArrayLength, right.get(key) - left.get(key) + 1);
            }
        }

        return minSubArrayLength;
    }
}

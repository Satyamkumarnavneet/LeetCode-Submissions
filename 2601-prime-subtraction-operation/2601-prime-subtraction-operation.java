class Solution {
    public boolean primeSubOperation(int[] nums) {
        int largestNum = findLargestNumber(nums);

        boolean[] primeCheck = new boolean[largestNum + 1];
        initializeArray(primeCheck, true);
        primeCheck[1] = false;
        for (int i = 2; i <= Math.sqrt(largestNum); i++) {
            if (primeCheck[i]) {
                for (int j = i * i; j <= largestNum; j += i) {
                    primeCheck[j] = false;
                }
            }
        }

        int prevValue = 1;
        int idx = 0;
        while (idx < nums.length) {
            int gap = nums[idx] - prevValue;

            if (gap < 0) {
                return false;
            }

            if (primeCheck[gap] || gap == 0) {
                idx++;
                prevValue++;
            } else {
                prevValue++;
            }
        }
        return true;
    }

    private int findLargestNumber(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void initializeArray(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
}
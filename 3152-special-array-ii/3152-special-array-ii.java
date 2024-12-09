class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] leftMostSpecial = new int[n];
        leftMostSpecial[0] = 0;

        for (int i = 1; i < n; ++i) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                leftMostSpecial[i] = leftMostSpecial[i - 1];
            } else {
                leftMostSpecial[i] = i;
            }
        }

        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int from = queries[i][0];
            int to = queries[i][1];
            answer[i] = (leftMostSpecial[to] <= from);
        }

        return answer;
    }
}

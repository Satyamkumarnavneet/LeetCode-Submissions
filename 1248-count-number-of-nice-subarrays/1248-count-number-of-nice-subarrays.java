class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1)
                deq.add(i);
            if (deq.size() > k + 1)
                deq.pop();
            if (deq.size() == k + 1)
                res += deq.get(1) - deq.get(0);
        }
        return res;
    }
}
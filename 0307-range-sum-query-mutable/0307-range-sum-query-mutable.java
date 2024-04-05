class NumArray {
    int[] segmentTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(nums, 0, n - 1, 0);
    }

    private void buildSegmentTree(int[] nums, int left, int right, int pos) {
        if (left == right) {
            segmentTree[pos] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildSegmentTree(nums, left, mid, 2 * pos + 1);
        buildSegmentTree(nums, mid + 1, right, 2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    public void update(int index, int val) {
        updateSegmentTree(0, n - 1, index, val, 0);
    }

    private void updateSegmentTree(int left, int right, int index, int val, int pos) {
        if (left == right) {
            segmentTree[pos] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateSegmentTree(left, mid, index, val, 2 * pos + 1);
        } else {
            updateSegmentTree(mid + 1, right, index, val, 2 * pos + 2);
        }
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(0, n - 1, left, right, 0);
    }

    private int querySegmentTree(int segLeft, int segRight, int left, int right, int pos) {
        if (right < segLeft || left > segRight) {
            return 0;
        }
        if (left <= segLeft && right >= segRight) {
            return segmentTree[pos];
        }
        int mid = segLeft + (segRight - segLeft) / 2;
        return querySegmentTree(segLeft, mid, left, right, 2 * pos + 1) +
                querySegmentTree(mid + 1, segRight, left, right, 2 * pos + 2);
    }
}

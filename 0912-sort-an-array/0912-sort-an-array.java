class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int i = start;
        int j = mid + 1;
        int k = start;
        
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (k = start; k <= end; k++) {
            nums[k] = temp[k];
        }
    }
}

class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return nums[0];
        }
        return nums[pivot + 1];
    }

    public int findPivot(int[] arr){
        int start = 0, end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid < arr.length - 1 && arr[mid] > arr[mid + 1]){
                return mid;
            }else if(mid > 0 && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }else if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
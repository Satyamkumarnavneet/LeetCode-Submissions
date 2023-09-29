class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        // Merge the two sorted arrays into the 'merged' array
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // If there are remaining elements in nums1, copy them to merged
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        // If there are remaining elements in nums2, copy them to merged
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        // Calculate the median based on the length of the merged array
        if ((m + n) % 2 == 0) {
            // If the total length is even, return the average of middle elements
            int mid1 = (m + n) / 2;
            int mid2 = mid1 - 1;
            return (merged[mid1] + merged[mid2]) / 2.0;
        } else {
            // If the total length is odd, return the middle element
            int mid = (m + n) / 2;
            return merged[mid];
        }
    }
}

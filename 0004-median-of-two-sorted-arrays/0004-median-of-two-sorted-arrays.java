public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Create a merged array of the two sorted arrays
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }
        // Find the median of the merged array
        int mid = merged.length / 2;
        if (merged.length % 2 == 0) {
            return (double) (merged[mid - 1] + merged[mid]) / 2;
        } else {
            return (double) merged[mid];
        }
    }
}

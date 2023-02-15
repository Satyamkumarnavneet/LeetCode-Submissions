class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m];
        
        for(int j = 0; j < m; j++){
            num[j] = nums1[j];
        }
        
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(num[i] < nums2[j]){
                nums1[k] = num[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i < m){
            nums1[k] = num[i];
                k++;
                i++;
        }
        
         while(j < n){
            nums1[k] = nums2[j];
                k++;
                j++;
        }
        
    }
}
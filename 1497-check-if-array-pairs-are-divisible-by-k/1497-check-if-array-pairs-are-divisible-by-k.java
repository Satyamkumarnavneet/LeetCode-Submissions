class Solution {
   public boolean canArrange(int[] arr, int k) {
       int[] remainderFreq = new int[k];
       
       for (int num : arr) {
           int remainder = num % k;
           if (remainder < 0) {
               remainder += k;
           }
           remainderFreq[remainder]++;
       }
       
       if (remainderFreq[0] % 2 != 0) {
           return false;
       }
       
       for (int i = 1; i <= k / 2; i++) {
           if (remainderFreq[i] != remainderFreq[k - i]) {
               return false;
           }
       }
       return true;
   }
}

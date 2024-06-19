class Solution {
   public int minDays(int[] bloomDay, int m, int k) {
       if (bloomDay.length < (long) m * k)
           return -1;

       int l = Arrays.stream(bloomDay).min().getAsInt();
       int r = Arrays.stream(bloomDay).max().getAsInt();

       while (l < r) {
           final int mid = (l + r) / 2;
           if (getBouquetCount(bloomDay, k, mid) >= m)
               r = mid;
           else
               l = mid + 1;
       }

       return l;
   }

   private int getBouquetCount(int[] bloomDay, int k, int waitingDays) {
       int bouquetCount = 0;
       int requiredFlowers = k;

       for (final int day : bloomDay)
           if (day > waitingDays) {
               requiredFlowers = k;
           } else if (--requiredFlowers == 0) {
               ++bouquetCount;
               requiredFlowers = k;
           }
       return bouquetCount;
   }
}

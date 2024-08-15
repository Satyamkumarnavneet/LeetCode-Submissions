class Solution {
   public boolean lemonadeChange(int[] bills) {
       int[] change = new int[3];
       for (int bill : bills) {
           if (bill == 5) {
               change[0]++;
           } else if (bill == 10) {
               if (change[0] > 0) {
                   change[0]--;
                   change[1]++;
               } else {
                   return false;
               }
           } else {
               if (change[1] > 0 && change[0] > 0) {
                   change[1]--;
                   change[0]--;
                   change[2]++;
               } else if (change[0] >= 3) {
                   change[0] -= 3;
                   change[2]++;
               } else {
                   return false;
               }
           }
       }
       return true;
   }
}

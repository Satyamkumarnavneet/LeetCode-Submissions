class Solution {
   public int findMaxK(int[] numbers) {
       HashSet<Integer> uniqueNumbers = new HashSet<>();
       int maxPositiveK = -1;

       for (int number : numbers) {
           uniqueNumbers.add(number);
           int negativeCounterpart = number * (-1);

           if (uniqueNumbers.contains(negativeCounterpart)) {
               maxPositiveK = Math.max(maxPositiveK, Math.abs(number));
           }
       }
       return maxPositiveK;
   }
}

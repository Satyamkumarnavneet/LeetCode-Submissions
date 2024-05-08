class Solution {
   public String[] findRelativeRanks(int[] score) {
       int n = score.length;
       int sortedScore [] = score.clone();
       Arrays.sort(sortedScore);

       HashMap<Integer, String> rankMap = new HashMap<>();
       for (int i = 0; i < n; i++) {
           int place = n - i;
           if (place == 1) {
               rankMap.put(sortedScore[i], "Gold Medal");
           } else if (place == 2) {
               rankMap.put(sortedScore[i], "Silver Medal");
           } else if (place == 3) {
               rankMap.put(sortedScore[i], "Bronze Medal");
           } else {
               rankMap.put(sortedScore[i], String.valueOf(place));
           }
       }

       String[] answer = new String[n];
       for (int i = 0; i < n; i++) {
           answer[i] = rankMap.get(score[i]);
       }
       return answer;
   }
}

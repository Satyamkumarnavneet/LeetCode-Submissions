class Solution {
   public List<String> commonChars(String[] words) {
       int[] commonCharCount = new int[26];
       for (char c : words[0].toCharArray()) {
           commonCharCount[c - 'a']++;
       }
       
       for (int i = 1; i < words.length; i++) {
           int[] currentCharCount = new int[26];
           for (char c : words[i].toCharArray()) {
               currentCharCount[c - 'a']++;
           }
           for (int j = 0; j < 26; j++) {
               commonCharCount[j] = Math.min(commonCharCount[j], currentCharCount[j]);
           }
       }
       
       List<String> result = new ArrayList<>();
       for (int i = 0; i < 26; i++) {
           for (int j = 0; j < commonCharCount[i]; j++) {
               result.add(String.valueOf((char)('a' + i)));
           }
       }
       return result;
   }
}

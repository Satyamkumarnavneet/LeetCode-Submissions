class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       Map<Integer, List<String>> map = new HashMap<>();
       return wordBreakHelper(s, 0, wordDict, map);
   }

   private List<String> wordBreakHelper(String s, int start, List<String> wordDict, Map<Integer, List<String>> map) {
       if (map.containsKey(start)) {
           return map.get(start);
       }
       
       List<String> result = new ArrayList<>();
       if (start == s.length()) {
           result.add("");
       }
       
       for (int end = start + 1; end <= s.length(); end++) {
           String word = s.substring(start, end);
           if (wordDict.contains(word)) {
               List<String> nextWords = wordBreakHelper(s, end, wordDict, map);
               for (String next : nextWords) {
                   result.add(word + (next.equals("") ? "" : " ") + next);
               }
           }
       }
       
       map.put(start, result);
       return result;
   }
}
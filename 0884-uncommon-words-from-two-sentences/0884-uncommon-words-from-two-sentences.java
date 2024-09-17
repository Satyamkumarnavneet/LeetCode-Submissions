class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        for (String word : words1) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        List<String> uncommonWords = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        return uncommonWords.toArray(new String[0]);
    }
}

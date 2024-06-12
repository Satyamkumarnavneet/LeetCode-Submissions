class Solution {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Trie trie = new Trie();
        
        for (String word : words) {
            if (isConcatenated(word, 0, trie, 0)) {
                result.add(word);
            } else {
                insertWord(word, trie);
            }
        }
        
        return result;
    }

    private boolean isConcatenated(String word, int start, Trie trie, int count) {
        if (start == word.length()) {
            return count > 1;
        }
        
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
            if (node.isEnd && isConcatenated(word, i + 1, trie, count + 1)) {
                return true;
            }
        }
        
        return false;
    }

    private void insertWord(String word, Trie trie) {
        Trie node = trie;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

class StreamChecker {
    TrieNode root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        
        for (String word : words) {
            insertWordIntoTrie(reverseString(word)); // Reverse each word before inserting into trie
        }
    }

    public boolean query(char letter) {
        sb.append(letter); // Append the new character to the existing stream

        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char ch = sb.charAt(i);
            node = node.next[ch - 'a'];
            if (node != null && node.isWord) {
                return true; // If a word is formed from the suffix, return true
            }
        }

        return false; // If no word is formed from the suffix, return false
    }

    private void insertWordIntoTrie(String word) {
        TrieNode node = root;
        
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }
            node = node.next[ch - 'a'];
        }
        node.isWord = true; // Mark the end of the word
    }

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    class TrieNode {
        TrieNode[] next;
        boolean isWord;

        public TrieNode() {
            next = new TrieNode[26]; // Assuming only lowercase English letters
            isWord = false;
        }
    }
}

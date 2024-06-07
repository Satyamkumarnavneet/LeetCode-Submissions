class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for (String rootWord : dictionary) {
            TrieNode node = root;
            for (char c : rootWord.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = rootWord;
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null || !node.word.isEmpty()) {
                    break;
                }
                node = node.children[index];
            }
            result.append(node.word.isEmpty() ? word : node.word).append(" ");
        }
        return result.toString().trim();
    }
}

class TrieNode:
    def __init__(self):
        self.children = {}
        self.counter = 0

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = TrieNode()

        for word in words:
            cur = trie
            for char in word:
                if char not in cur.children:
                    cur.children[char] = TrieNode()
                cur = cur.children[char]
                cur.counter += 1

        result = []
        for word in words:
            cur = trie
            total = 0
            for char in word:
                cur = cur.children[char]
                total += cur.counter
            result.append(total)

        return result

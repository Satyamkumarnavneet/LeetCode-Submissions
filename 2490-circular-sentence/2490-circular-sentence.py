class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        words = sentence.split()
        n = len(words)
        for i in range(n):
            last_char = words[i][-1]
            next_char = words[(i + 1) % n][0]
            if last_char != next_char:
                return False
        return True

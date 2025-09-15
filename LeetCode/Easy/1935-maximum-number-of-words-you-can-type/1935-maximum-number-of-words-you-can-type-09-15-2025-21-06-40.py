class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken = set(brokenLetters)
        count = 0
        # Split the text into words
        for word in text.split():
            if not any(letter in broken for letter in word):
                count += 1
        return count

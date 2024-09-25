class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        n = len(words)
        answer = [0] * n
        
        for i in range(n):
            for j in range(1, len(words[i]) + 1):
                prefix = words[i][:j]
                count = sum(1 for word in words if word.startswith(prefix))
                answer[i] += count
        return answer

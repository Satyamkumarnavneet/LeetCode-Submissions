class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        n = len(A)
        C = [0] * n
        count = 0
        seenA = set()
        seenB = set()
        
        for i in range(n):
            seenA.add(A[i])
            seenB.add(B[i])
            count = len(seenA & seenB)
            C[i] = count
        
        return C

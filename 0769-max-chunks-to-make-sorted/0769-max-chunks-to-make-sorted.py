
class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        max_value = 0
        chunks = 0
        
        for i in range(len(arr)):
            max_value = max(max_value, arr[i])
            if max_value == i:
                chunks += 1
        
        return chunks
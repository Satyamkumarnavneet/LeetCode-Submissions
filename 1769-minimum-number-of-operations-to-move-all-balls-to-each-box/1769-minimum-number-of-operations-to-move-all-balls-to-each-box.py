class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        n = len(boxes)
        answer = [0] * n
        
        count = 0
        ops = 0
        for i in range(n):
            answer[i] += ops
            count += int(boxes[i])
            ops += count
        
        count = 0
        ops = 0
        for i in range(n-1, -1, -1):
            answer[i] += ops
            count += int(boxes[i])
            ops += count
        
        return answer
from typing import List

class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        n = len(arr)
        pos = [i for i in range(n) if arr[i]]
        l = len(pos)
        
        if l == 0:
            return [0, 2]
        if l % 3:
            return [-1, -1]
        
        ones = l // 3
        c = 0
        for i in arr[::-1]:
            if i == 1:
                break
            c += 1
        
        ans = [-1, -1]
        ans[0] = pos[ones - 1] + c
        ans[1] = pos[2 * ones - 1] + c + 1
        
        seg1, seg2, seg3 = arr[pos[0]:ans[0] + 1], arr[pos[ones]:ans[1]], arr[pos[2 * ones]:]
        
        if seg1 != seg2 or seg1 != seg3:
            return [-1, -1]
        
        return ans

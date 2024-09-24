class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        result = 0
        for x in arr1:
            for y in arr2:
                s1 = str(x)
                s2 = str(y)
                common_len = 0
                length = min(len(s1), len(s2))
                
                for i in range(length):
                    if s1[i] == s2[i]:
                        common_len += 1
                    else:
                        break
                
                result = max(result, common_len)
        
        return result

class Solution(object):
    def compareVersion(self, version1, version2):
        v1 = version1.split('.')
        v2 = version2.split('.')
        
        length = max(len(v1), len(v2))
        
        for i in range(length):
            v1_val = int(v1[i]) if i < len(v1) else 0
            v2_val = int(v2[i]) if i < len(v2) else 0
            
            if v1_val < v2_val:
                return -1
            elif v1_val > v2_val:
                return 1
        
        return 0

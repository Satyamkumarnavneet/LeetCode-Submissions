class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        intervalMap = defaultdict(int)
        runner, output = 0, 0
        
        for start, end in intervals:
            intervalMap[start] += 1
            intervalMap[end + 1] -= 1
        
        for key in sorted(intervalMap.keys()):
            runner += intervalMap[key]
            output = max(output, runner)
            
        return output

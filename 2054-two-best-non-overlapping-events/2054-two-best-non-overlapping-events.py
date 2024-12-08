class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        e = []
        for l, r, v in events:
            e.append((l, 1, v))
            e.append((r + 1, -1, v))
        e.sort()
        maxp = 0
        best = 0
        for l, t, v in e:
            if t == 1:
                best = max(best, v + maxp)
            if t == -1:
                maxp = max(maxp, v)
        return best

class Solution:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        d = defaultdict(list)
        ans = [-1] * len(queries)

        for idx, q in enumerate(queries):
            l, r = sorted(q)
            if l == r or heights[r] > heights[l]:
                ans[idx] = r
            else:
                h = max(heights[l], heights[r])
                d[r].append((h, idx))

        heap = []
        for idx, h in enumerate(heights):
            for q_h, q_idx in d[idx]:
                heapq.heappush(heap, (q_h, q_idx))
            
            while heap and h > heap[0][0]:
                q_h, q_idx = heapq.heappop(heap)
                ans[q_idx] = idx

        return ans

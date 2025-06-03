import heapq
from typing import List
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])
        
        INF = 10**18
        dist = [[INF] * m for _ in range(n)]
        dist[0][0] = 0
        
        pq = [(0, 0, 0)]  # (time, x, y)
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        while pq:
            t, i, j = heapq.heappop(pq)
            if t > dist[i][j]:
                continue
            if i == n - 1 and j == m - 1:
                return t
            for dx, dy in dirs:
                ni, nj = i + dx, j + dy
                if 0 <= ni < n and 0 <= nj < m:
                    start_time = max(t, moveTime[ni][nj])
                    arrival_time = start_time + 1
                    if arrival_time < dist[ni][nj]:
                        dist[ni][nj] = arrival_time
                        heapq.heappush(pq, (arrival_time, ni, nj))
        
        return dist[n - 1][m - 1]

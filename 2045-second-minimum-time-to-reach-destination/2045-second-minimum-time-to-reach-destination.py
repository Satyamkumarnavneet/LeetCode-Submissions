class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        graph = [[] for _ in range(n + 1)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        pq = [(0, 1)]
        times = [[float('inf'), float('inf')] for _ in range(n + 1)]
        times[1][0] = 0
        
        while pq:
            current_time, u = heapq.heappop(pq)
            
            if (current_time // change) % 2 == 1:
                current_time = ((current_time // change) + 1) * change
            
            for v in graph[u]:
                new_time = current_time + time
                
                if new_time < times[v][0]:
                    times[v][1] = times[v][0]
                    times[v][0] = new_time
                    heapq.heappush(pq, (new_time, v))
                elif times[v][0] < new_time < times[v][1]:
                    times[v][1] = new_time
                    heapq.heappush(pq, (new_time, v))
        
        return times[n][1]

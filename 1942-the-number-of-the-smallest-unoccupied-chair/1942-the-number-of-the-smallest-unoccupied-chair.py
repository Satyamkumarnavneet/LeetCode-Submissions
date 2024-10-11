class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        events = [(t[0], 1, i) for i, t in enumerate(times)] + [(t[1], -1, i) for i, t in enumerate(times)]
        events.sort()

        chairs = list(range(len(times)))
        heap = []
        
        occupancy = [None] * len(times)

        for time, event, friend in events:
            if event == 1:
                if len(chairs) > 0:
                    seat = heapq.heappop(chairs)
                    occupancy[friend] = seat
                    if friend == targetFriend:
                        return seat
                else:
                    seat = heapq.heappop(heap)
                    occupancy[friend] = seat
                    if friend == targetFriend:
                        return seat
            else:
                seat = occupancy[friend]
                if seat is not None:
                    heapq.heappush(chairs, seat)
                else:
                    heapq.heappush(heap, seat)
        
        return -1  

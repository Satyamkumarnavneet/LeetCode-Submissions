class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        low, high = 1, max(quantities)

        def canDistribute(x):
            needed_stores = 0
            for quantity in quantities:
                needed_stores += (quantity + x - 1) // x
                if needed_stores > n:
                    return False
            return needed_stores <= n

        while low < high:
            mid = (low + high) // 2
            if canDistribute(mid):
                high = mid
            else:
                low = mid + 1
        
        return low

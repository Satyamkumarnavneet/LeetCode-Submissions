class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        if k == 1:
            return weights[0] + weights[-1]
        
        adjacent_sums = [weights[i] + weights[i+1] for i in range(len(weights) - 1)]
        adjacent_sums.sort()
        
        max_score = sum(adjacent_sums[-(k-1):])
        min_score = sum(adjacent_sums[:k-1])
        
        return max_score - min_score
from typing import List
class Solution:
    def  numTeams(self, rating: List[int]) -> int:
        n = len(rating)
        res = 0

        for j in range(1, n - 1):
            left_smaller = left_larger = right_smaller = right_larger = 0

            for i in range(j):
                if rating[i] < rating[j]:
                    left_smaller += 1
                else:
                    left_larger += 1

            for k in range(j + 1, n):
                if rating[k] < rating[j]:
                    right_smaller += 1
                else:
                    right_larger += 1

            res += left_smaller * right_larger + left_larger * right_smaller

        return res
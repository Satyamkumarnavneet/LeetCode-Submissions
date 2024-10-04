class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        n = len(skill)
        target_sum = skill[0] + skill[n-1]
        i, j = 0, n - 1
        ans = 0
        
        while i < j:
            first, second = skill[i], skill[j]
            temp_sum = first + second
            if temp_sum == target_sum:
                ans += first * second
            else:
                return -1
            i += 1
            j -= 1
        return ans
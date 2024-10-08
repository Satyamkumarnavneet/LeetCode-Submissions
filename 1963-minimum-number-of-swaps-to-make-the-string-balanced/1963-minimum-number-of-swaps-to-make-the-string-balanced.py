class Solution:
    def minSwaps(self, s: str) -> int:
        closed_brackets = 0
        open_brackets = 0

        for char in s:
            if char == ']':
                if open_brackets > 0:
                    open_brackets -= 1
                else:
                    closed_brackets += 1
            else:
                open_brackets += 1

        return (closed_brackets + 1) // 2

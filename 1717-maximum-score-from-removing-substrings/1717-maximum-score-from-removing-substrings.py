class Solution(object):
    def maximumGain(self, s, x, y):
        a_count = 0
        b_count = 0
        lesser = min(x, y)
        result = 0

        for c in s:
            if c > 'b':
                result += min(a_count, b_count) * lesser
                a_count = 0
                b_count = 0
            elif c == 'a':
                if x < y and b_count > 0:
                    b_count -= 1
                    result += y
                else:
                    a_count += 1
            elif c == 'b':
                if x > y and a_count > 0:
                    a_count -= 1
                    result += x
                else:
                    b_count += 1

        result += min(a_count, b_count) * lesser
        return result
        
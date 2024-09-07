class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        operand = 0
        res = 0
        sign = 1

        for char in s:
            if char.isdigit():
                operand = operand * 10 + int(char)
            elif char in ['+', '-']:
                res += sign * operand
                operand = 0
                sign = 1 if char == '+' else -1
            elif char == '(':
                stack.append(res)
                stack.append(sign)
                sign = 1
                res = 0
            elif char == ')':
                res += sign * operand
                res *= stack.pop()
                res += stack.pop()
                operand = 0

        return res + sign * operand

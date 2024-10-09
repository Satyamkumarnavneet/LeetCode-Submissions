class Solution:
   def minAddToMakeValid(self, s: str) -> int:
       stack = []
       count = 0
       
       for char in s:
           if char == '(':
               stack.append(char)
           elif char == ')' and stack and stack[-1] == '(':
               stack.pop()
           else:
               count += 1
       
       return count + len(stack)

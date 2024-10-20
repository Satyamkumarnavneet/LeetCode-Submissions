class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        stack = []
        operators = set(['!', '&', '|'])
        
        for char in expression:
            if char == ')':
                seen = set()
                while stack[-1] != '(':
                    seen.add(stack.pop())
                
                stack.pop()  # Pop the '('
                operator = stack.pop()  # Get the operator
                
                if operator == '!':
                    stack.append('t' if 'f' in seen else 'f')
                elif operator == '&':
                    stack.append('t' if 'f' not in seen else 'f')
                else:  # operator == '|'
                    stack.append('t' if 't' in seen else 'f')
            elif char in operators or char == '(':
                stack.append(char)
            elif char == 't' or char == 'f':
                stack.append(char)
        
        return True if stack[0] == 't' else False

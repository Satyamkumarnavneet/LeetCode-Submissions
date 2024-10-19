class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def invert(bit):
            return '1' if bit == '0' else '0'
        
        def reverse(s):
            return s[::-1]
        
        def generate_string(n):
            if n == 1:
                return "0"
            prev = generate_string(n - 1)
            return prev + "1" + ''.join(invert(bit) for bit in prev[::-1])
        
        binary_string = generate_string(n)
        return binary_string[k - 1]

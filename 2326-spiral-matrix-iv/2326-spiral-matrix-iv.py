# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def spiralMatrix(self, m, n, head):
        """
        :type m: int
        :type n: int
        :type head: Optional[ListNode]
        :rtype: List[List[int]]
        """
        # Initialize the matrix with -1
        ans = [[-1 for _ in range(n)] for _ in range(m)]
        
        top, bottom, left, right = 0, m - 1, 0, n - 1
        curr = head
        
        # Traverse the matrix in spiral order
        while curr and top <= bottom and left <= right:
            # Fill top row (left to right)
            for i in range(left, right + 1):
                if curr:
                    ans[top][i] = curr.val
                    curr = curr.next
            top += 1
            
            # Fill right column (top to bottom)
            for i in range(top, bottom + 1):
                if curr:
                    ans[i][right] = curr.val
                    curr = curr.next
            right -= 1
            
            # Fill bottom row (right to left)
            for i in range(right, left - 1, -1):
                if curr:
                    ans[bottom][i] = curr.val
                    curr = curr.next
            bottom -= 1
            
            # Fill left column (bottom to top)
            for i in range(bottom, top - 1, -1):
                if curr:
                    ans[i][left] = curr.val
                    curr = curr.next
            left += 1
        
        return ans
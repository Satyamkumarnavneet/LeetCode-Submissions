# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        total_nodes = 0
        curr = head
        while curr:
            total_nodes += 1
            curr = curr.next

        min_size = total_nodes // k
        remainder = total_nodes % k

        result = [None] * k
        curr = head

        for i in range(k):
            result[i] = curr
            part_size = min_size + (1 if remainder > 0 else 0)
            remainder -= 1

            for _ in range(part_size - 1):
                if curr:
                    curr = curr.next

            if curr:
                next_node = curr.next
                curr.next = None
                curr = next_node

        return result

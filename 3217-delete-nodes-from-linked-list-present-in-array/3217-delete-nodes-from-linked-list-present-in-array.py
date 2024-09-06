class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        values_set = set(nums)
        dummy = ListNode(0)
        dummy.next = head
        current = dummy

        while current.next:
            if current.next.val in values_set:
                current.next = current.next.next
            else:
                current = current.next
        return dummy.next
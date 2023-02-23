class Solution {
   public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null && prev.next.next != null) {
        if (prev.next.val == prev.next.next.val) {
            int dup = prev.next.val;
            while (prev.next != null && prev.next.val == dup) {
                prev.next = prev.next.next;
            }
        } else {
            prev = prev.next;
        }
    }
    return dummy.next;
}
}
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.val > curr.next.val) {
                ListNode prev = dummy;
                while (prev.next.val < curr.next.val) {
                    prev = prev.next;
                }
                
                ListNode temp = curr.next;
                curr.next = curr.next.next;
                temp.next = prev.next;
                prev.next = temp;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverse(ListNode list) {
        ListNode dummy = null;
        ListNode curr = list;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = next;
        }
        return dummy;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        ListNode prev = head;
        int me = head.val;
        while (curr != null) {
            me = Math.max(me, curr.val);
            if (me > curr.val) {
                prev.next = prev.next.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        head = reverse(head);
        return head;
    }
}
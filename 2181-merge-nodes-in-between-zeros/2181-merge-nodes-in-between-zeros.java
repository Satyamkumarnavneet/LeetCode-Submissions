class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.val != 0) {
            prev = prev.next;
        }
        
        while (prev.next != null && prev.next.next != null) {
            ListNode start = prev.next;
            ListNode end = start.next;
            
            while (end.next != null && end.next.val != 0) {
                end = end.next;
            }
            
            int sum = 0;
            ListNode curr = start;
            while (curr != end) {
                sum += curr.val;
                curr = curr.next;
            }
            sum += end.val;
            
            prev.next = new ListNode(sum);
            prev.next.next = end.next;
        }
        
        return dummy.next;
    }
}

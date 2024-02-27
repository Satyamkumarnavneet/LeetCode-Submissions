class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null  || head.next==null){
            return head;
        }
        ListNode t=head;
        ListNode n=head.next;
        ListNode s=t.next.next;
        n.next=head;
        head=t.next;
        t.next=swapPairs(s);
        return  head;
    }
}
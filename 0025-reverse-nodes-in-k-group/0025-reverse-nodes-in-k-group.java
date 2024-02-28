/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode curr = head;
       int len=0;
       while(curr!=null){
           curr=curr.next;
           len++;
       }
       return reverse(head,k,len);
    
    }
    public ListNode reverse(ListNode head,int k,int l){
        if(l<k){
            return head;
        }
        int count=0;
            ListNode prev=null;
            ListNode curr=head;
            ListNode nxt=null;
            while( curr!=null && count<k){
                nxt=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nxt;
                count++;

            }
            if(nxt!=null ){
                head.next=reverse(nxt,k,l-k);

            }
            return prev;
    }
}
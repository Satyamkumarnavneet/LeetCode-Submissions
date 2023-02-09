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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode reversed = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){ // Find mid
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){ // Reverse half of the list
            ListNode next = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = next;
        }
        while(reversed != null){
             if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
        
    }
}
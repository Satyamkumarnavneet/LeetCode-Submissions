class Solution {
    public ListNode doubleIt(ListNode head) {
        // Reverse the linked list to simplify the doubling process
        ListNode reversed = reverseLinkedList(head);
        ListNode current = reversed;
        int carry = 0;

        while (current != null) {
            int doubledValue = current.val * 2 + carry;
            current.val = doubledValue % 10;
            carry = doubledValue / 10;
            current = current.next;
        }
        
        // If there's a remaining carry, add it as a new node
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            if (reversed == null) {
                reversed = newNode;
            } else {
                // Find the last node and append the new node
                ListNode lastNode = reversed;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }
                lastNode.next = newNode;
            }
        }
        
        // Reverse the linked list again to get the correct order
        return reverseLinkedList(reversed);
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }
}

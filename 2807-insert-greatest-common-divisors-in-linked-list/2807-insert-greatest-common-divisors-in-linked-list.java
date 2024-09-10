class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            int gcd = calculateGCD(current.val, current.next.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        return head;
    }
    
    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}

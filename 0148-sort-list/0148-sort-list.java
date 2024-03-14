class Solution {
    public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int[] arr = new int[count];
        temp = head;
        count = 0;
        while(temp!=null){
            arr[count++] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        temp = head;
        count = 0;
        while(temp!=null){
            temp.val = arr[count++];
            temp = temp.next;
        }
        return head;
    }
}
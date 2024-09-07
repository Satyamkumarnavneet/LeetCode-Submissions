class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSubPathFrom(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean isSubPathFrom(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        
        if (head.val == root.val) {
            return isSubPathFrom(head.next, root.left) || isSubPathFrom(head.next, root.right);
        }
        return false;
    }
}

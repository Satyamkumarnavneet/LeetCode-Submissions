/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int idx = 0;
        
        while (idx < traversal.length()) {
            int level = 0;
            while (traversal.charAt(idx) == '-') {
                level++;
                idx++;
            }
            
            int val = 0;
            while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
                val = val * 10 + (traversal.charAt(idx) - '0');
                idx++;
            }
            
            TreeNode node = new TreeNode(val);
            while (stack.size() > level) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}
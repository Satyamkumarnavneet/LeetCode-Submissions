class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[1];
        ans[0] = "zzzzz";
        smallestFromLeaf1(root, sb, ans);
        return ans[0];
    }
    public void smallestFromLeaf1(TreeNode root, StringBuilder sb, String[] ans) {
        char a = (char) (root.val + 97);
        sb.insert(0, a);
        if (root.left == null && root.right == null) {
            int x = sb.toString().compareTo(ans[0]);
            if (x < 0) {
                ans[0] = sb.toString();
            }
        }
        if (root.left != null) {
            smallestFromLeaf1(root.left, sb, ans);
            sb.deleteCharAt(0);
        }
        if (root.right!=null) {
            smallestFromLeaf1(root.right, sb, ans);
            sb.deleteCharAt(0);
        }
    }
}
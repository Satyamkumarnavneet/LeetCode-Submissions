class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insert(root,depth,val,1);
        return root; 
    }
    public void insert(TreeNode node, int depth, int val, int currentDepth){
        if(node == null){
            return;
        }
        if(currentDepth == depth-1){
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        else{
            insert(node.left,depth,val,currentDepth+1);
            insert(node.right,depth,val,currentDepth+1);
        }
    }
}
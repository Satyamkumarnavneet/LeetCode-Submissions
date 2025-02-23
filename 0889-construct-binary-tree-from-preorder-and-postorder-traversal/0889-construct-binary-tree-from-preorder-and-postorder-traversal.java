class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postIndexMap, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> postIndexMap, 
                               int preStart, int preEnd, int postStart) {
        if (preStart > preEnd) {
            return null; 
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        if (preStart == preEnd) {
            return root;
        }
        
        int leftChild = preorder[preStart + 1];
        int leftChildIndex = postIndexMap.get(leftChild);
        int leftSubtreeSize = leftChildIndex - postStart + 1;
        root.left = buildTree(preorder, postIndexMap, preStart + 1, preStart + leftSubtreeSize, postStart);
        root.right = buildTree(preorder, postIndexMap, preStart + leftSubtreeSize + 1, preEnd, leftChildIndex + 1);
        return root;
    }
}

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        dfs(root, toDeleteSet, result, true);
        return result;
    }
    
    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> result, boolean isRoot) {
        if (node == null) {
            return null;
        }

        boolean deleted = toDeleteSet.contains(node.val);

        if (isRoot && !deleted) {
            result.add(node);
        }

        node.left = dfs(node.left, toDeleteSet, result, deleted);
        node.right = dfs(node.right, toDeleteSet, result, deleted);
        return deleted ? null : node;
    }
}

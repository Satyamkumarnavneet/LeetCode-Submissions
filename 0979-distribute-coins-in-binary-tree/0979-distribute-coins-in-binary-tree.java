class Solution {
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftCoins = dfs(node.left);
        int rightCoins = dfs(node.right);

        int total = leftCoins + rightCoins + node.val - 1;

        moves += Math.abs(total);

        return total;
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int totalSum = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int currentSum = current.getValue() * 10 + node.val;

            if (node.left == null && node.right == null) {
                totalSum += currentSum;
            } else {
                if (node.right != null) {
                    stack.push(new Pair<>(node.right, currentSum));
                }
                if (node.left != null) {
                    stack.push(new Pair<>(node.left, currentSum));
                }
            }
        }
        return totalSum;
    }
}
